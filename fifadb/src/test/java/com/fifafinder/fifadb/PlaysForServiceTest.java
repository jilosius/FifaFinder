package com.fifafinder.fifadb;

import com.fifafinder.fifadb.repositories.PlaysForRepository;
import com.fifafinder.fifadb.repositories.SpielerRepository;
import com.fifafinder.fifadb.services.PlaysForService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PlaysForServiceTest {

    @Mock
    PlaysForRepository playsForRepository;
    @Mock
    SpielerRepository spielerRepository;

    @InjectMocks
    PlaysForService playsForService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void deleteAllByPlayerID() {
        playsForService.deleteAllByPlayerID(10);
        verify(playsForRepository, times(1)).deleteAllById_PlayerID(10);
        verify(spielerRepository, times(1)).deleteById(10);
    }

    @Test
    void deleteAllByPlayerIDAndFifaVersionWhenNoEntriesLeft() {
        when(playsForRepository.countById_PlayerID(11)).thenReturn(0);
        playsForService.deleteAllByPlayerIDAndFifaVersion(11,23);
        verify(playsForRepository, times(1)).deleteAllById_PlayerIDAndId_FifaVersion(11,23);
        verify(playsForRepository, times(1)).countById_PlayerID(11);
        verify(spielerRepository, times(1)).deleteById(11);
    }

    @Test
    void deleteAllByPlayerIDAndFifaVersionWhenEntriesLeft(){
        when(playsForRepository.countById_PlayerID(10)).thenReturn(1);
        playsForService.deleteAllByPlayerIDAndFifaVersion(10, 23);
        verify(playsForRepository, times(1)).deleteAllById_PlayerIDAndId_FifaVersion(10,23);
        verify(playsForRepository, times(1)).countById_PlayerID(10);
        verify(spielerRepository, times(0)).deleteById(10);
    }
}