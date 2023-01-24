package com.fifafinder.fifadb.services;

import com.fifafinder.fifadb.dto.SpielerDetailDTO;
import com.fifafinder.fifadb.dto.UpdateDTO;
import com.fifafinder.fifadb.entities.PlaysFor;
import com.fifafinder.fifadb.entities.PlaysForId;
import com.fifafinder.fifadb.repositories.PlaysForRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


@RunWith(MockitoJUnitRunner.class)
public class PlaysForServiceTest {
    @InjectMocks
    private final PlaysForService underTest;
    @Mock
    private final PlaysForRepository playsForRepository;

    public PlaysForServiceTest(PlaysForService playsForService, PlaysForRepository playsForRepository) {
        this.underTest = playsForService;
        this.playsForRepository = playsForRepository;
    }

    @Test
    public void shouldUpdateDetails() {
        //given
        PlaysForId playsForId = new PlaysForId();
        playsForId.setPlayerID(158023);
        playsForId.setFifaVersion(23);
        UpdateDTO updateDTO = new UpdateDTO(
                100, "a", 100, "b", 100, "c", 100, "d", "e", 100, 100, 100, "f", 100L, 100L, 100L, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, "g");

        UpdateDTO backUpData = new UpdateDTO(
                169, "RW", 30, "RW", 10, "Left", 2023, "FALSE", "Argentina", 72, 91, 91, "CAM", 54000000L, 195000L, 99900000L,
                5, 4, 4, 84, 90, 70, 91, 88, 95, 93, 93, 90, 93, 87, 76, 91, 92, 95, 86, 68, 70, 68, 91, 44, 40, 93,
                94, 75, 96, 20, 35, 24, 6, 11, 15, 14, 8, "https://cdn.sofifa.net/players/158/023/23_60.png");

        PlaysFor oldDetails = playsForRepository.findPlaysForById(playsForId);

        //when
        underTest.editDetails(playsForId, updateDTO);

        //then
        PlaysFor newDetails = playsForRepository.findPlaysForById(playsForId);
        assertNotEquals(oldDetails, newDetails);
    }
}
