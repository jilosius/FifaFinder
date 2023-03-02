package com.fifafinder.fifadb;
import com.fifafinder.fifadb.DTOs.AddPlaysForDTO;
import com.fifafinder.fifadb.DTOs.SpielerDTO;
import com.fifafinder.fifadb.controllers.FifaController;
import com.fifafinder.fifadb.controllers.MannschaftenController;
import com.fifafinder.fifadb.controllers.PlaysForController;
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

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.when;





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
}
