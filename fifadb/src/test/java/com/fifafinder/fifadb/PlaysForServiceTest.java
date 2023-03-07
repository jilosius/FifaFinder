package com.fifafinder.fifadb;

import com.fifafinder.fifadb.dto.SpielerDetailDTO;
import com.fifafinder.fifadb.dto.UpdateDTO;
import com.fifafinder.fifadb.entities.*;
import com.fifafinder.fifadb.repositories.MannschaftenRepository;
import com.fifafinder.fifadb.repositories.PlaysForRepository;
import com.fifafinder.fifadb.repositories.SpielerRepository;
import com.fifafinder.fifadb.services.PlaysForService;
import org.assertj.core.util.Arrays;
import org.hibernate.sql.Update;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class PlaysForServiceTest {

    @Mock
    PlaysForRepository playsForRepository;
    @Mock
    SpielerRepository spielerRepository;

    @Mock
    MannschaftenRepository mannschaftenRepository;
    @Mock
    ModelMapper modelMapper;

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

    @Test
    public void editDetails() {
        PlaysForId testPlaysForId = new PlaysForId(0, 0);
        Mannschaften testMannschaft = new Mannschaften();
        testMannschaft.setId(1);
        testMannschaft.setClubName("a");
        UpdateDTO testUpdateDTO = new UpdateDTO(100, "a", 100, "a", 100, "a", 100, "a", "a",
                100, 100, 100, "a", "a", 100L, 100L, 100L, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,100,
                100, 100, 100, 100, 100, 100, "a");

        PlaysFor testPlaysFor = new PlaysFor(testPlaysForId, null, null, null, null, null, null, null, null,
                null, null, null, 20, null, null, null, null, null, null, null,null,
                null,null,null,null,null,null,null,null,null,null,null,null,
                null,null,null,null,null,null,null,null,null,null,null,null,null,
                null,null,null,null,null,null,null,null,null,null,null,null, null);

        PlaysFor expectedResult = new PlaysFor(testPlaysForId, null, null,100, "a", 100, "a", 100, "a", 100, "a",
                "a", 20, 100, 100, 100, "a", testMannschaft, 100L, 100L, 100L, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,100,
                100, 100, 100, 100, 100, 100, "a");

        Mockito.when(playsForRepository.findPlaysForById(testPlaysForId)).thenReturn(testPlaysFor);
        Mockito.when(mannschaftenRepository.findMannschaftenByClubName("a")).thenReturn(testMannschaft);

        PlaysFor actualResult = playsForService.editDetails(testPlaysForId, testUpdateDTO);

        Mockito.verify(playsForRepository, times(1)).findPlaysForById(testPlaysForId);
        Mockito.verify(playsForRepository, times(1)).save(any());
        assertEquals(expectedResult.getWeight(), actualResult.getWeight());
        assertEquals(expectedResult.getClubPosition(), actualResult.getClubPosition());

    }

    @Test
    void getDetailsForEdit() {
        PlaysForId playsForId = new PlaysForId(0, 0);
        Mannschaften mannschaften = new Mannschaften();
        mannschaften.setId(1);
        mannschaften.setClubName("wuhu");
        PlaysFor playsFor = new PlaysFor(null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, mannschaften, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null);

        UpdateDTO expectedResult = new UpdateDTO(null, null, null, null, null, null, null, null, null,
                null, null, null, null, "wuhu", null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null);
        Mockito.when(playsForRepository.findPlaysForById(playsForId)).thenReturn(playsFor);
        UpdateDTO actualResult = playsForService.getDetailsForEdit(playsForId);
        verify(playsForRepository, times(1)).findPlaysForById(playsForId);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getDetails() {
        int playerId = 1;
        int fifaVersion = 1;
        PlaysForId playsForId = new PlaysForId(playerId, fifaVersion);

        PlaysFor playsFor = new PlaysFor(playsForId, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null);

        SpielerDetailDTO expectedResult = new SpielerDetailDTO(playsForId, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null,
                null, null);

        Mockito.when(playsForRepository.findPlaysForById(playsForId)).thenReturn(playsFor);
        Mockito.when(modelMapper.map(playsFor, SpielerDetailDTO.class)).thenReturn(expectedResult);

        SpielerDetailDTO actualResult = playsForService.getDetails(playerId, fifaVersion);

        Mockito.verify(playsForRepository, times(1)).findPlaysForById(playsForId);
        Mockito.verify(modelMapper, times(1)).map(playsFor, SpielerDetailDTO.class);
        assertEquals(expectedResult, actualResult);

    }






}