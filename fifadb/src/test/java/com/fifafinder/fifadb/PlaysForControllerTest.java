package com.fifafinder.fifadb;
import com.fifafinder.fifadb.DTOs.AddPlaysForDTO;
import com.fifafinder.fifadb.DTOs.SpielerDTO;
import com.fifafinder.fifadb.controllers.FifaController;
import com.fifafinder.fifadb.controllers.MannschaftenController;
import com.fifafinder.fifadb.controllers.PlaysForController;
import com.fifafinder.fifadb.dto.UpdateDTO;
import com.fifafinder.fifadb.entities.PlaysForId;
import com.fifafinder.fifadb.entities.Spieler;
import com.fifafinder.fifadb.repositories.PlaysForRepository;
import com.fifafinder.fifadb.services.PlaysForService;
import com.fifafinder.fifadb.services.SpielerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.time.LocalDate;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class PlaysForControllerTest {

    @Mock
    private PlaysForService playsForService;
    @Mock
    private SpielerService spielerService;
    @Mock
    private FifaController fifaController;
    @Mock
    private MannschaftenController mannschaftenController;

    @InjectMocks
    @Spy
    private PlaysForController playsForController;

    public void setUp() {
        AddPlaysForDTO addPlaysForDTO = new AddPlaysForDTO(null,null,null,null,null,null,null,null,
                null,null,null,null,null,null,null,null,null,null,null,null,
                null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
                null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
                null,null,null,null,null,null,null,null,null,null);

        AddPlaysForDTO addPlaysForDTO2 = new AddPlaysForDTO(null,null,null,null,null,null,null,22,
                null,null,"Arsenal",null,null,null,null,null,null,null,null,null,
                null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
                null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
                null,null,null,null,null,null,null,null,null,null);
    }

    @Test
    public void addPlaysForTest(){
        Date date = new Date(2020-12-12);

        AddPlaysForDTO playsForDTO = new AddPlaysForDTO("a","a",null,null,null,"a", date,22,
                null,null,"Arsenal",null,null,null,null,null,null,null,null,null,
                null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
                null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
                null,null,null,null,null,null,null,null,null,null);
        playsForController.addPlayer(playsForDTO);


    }

    @Test
    public void getDetails() {
        String name = "Messi";
        int fifaVersion = 23;
        Spieler spieler = new Spieler();
        spieler.setId(1);
        spieler.setFullName(name);

        Mockito.when(spielerService.getSpieler(name)).thenReturn(spieler);

        playsForController.getDetails(name, fifaVersion);

        Mockito.verify(spielerService, times(1)).getSpieler(name);
        Mockito.verify(playsForService, times(1)).getDetails(spieler.getId(), fifaVersion);
    }

    @Test
    public void editDetails() {
        UpdateDTO updateDTO = new UpdateDTO(100, "a", 100, "a", 100, "a", 100, "a", "a",
                100, 100, 100, "a", "a", 100L, 100L, 100L, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100,100,
                100, 100, 100, 100, 100, 100, "a");
        int playerId = 1;
        int fifaVersion = 23;
        PlaysForId playsForId = new PlaysForId(playerId, fifaVersion);

        playsForController.editDetails(playerId, fifaVersion, updateDTO);

        Mockito.verify(playsForService, times(1)).editDetails(playsForId, updateDTO);
    }

    @Test
    public void getDetailsForEdit() {
        int playerId = 1;
        int fifaVersion = 23;
        PlaysForId playsForId = new PlaysForId();
        playsForId.setPlayerID(playerId);
        playsForId.setFifaVersion(fifaVersion);

        playsForController.getDetailsForEdit(playerId, fifaVersion);

        Mockito.verify(playsForService, times(1)).getDetailsForEdit(playsForId);
    }
}
