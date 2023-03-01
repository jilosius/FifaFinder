package com.fifafinder.fifadb;

import com.fifafinder.fifadb.DTOs.SpielerDTO;
import com.fifafinder.fifadb.repositories.SpielerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SpielerRepositoryTest {

    @Mock
    private SpielerRepository spielerRepository;

    @Test
    public void testFindByFullNameFiltered() {
        // Create test data
        SpielerDTO player1 = new SpielerDTO(
                1,
                "https://example.com/player1.jpg",
                "J. Doe",
                "John Doe",
                25,
                "https://example.com/flag.png",
                "Test Club",
                "https://example.com/club.png",
                80,
                85,
                "Forward",
                1000000L,
                185,
                75,
                "right",
                80,
                70,
                80,
                75,
                80,
                70, 80, 75, 80, 70, 80, 75, 80, 70, 80, 75, 80, 80, 50000L);
        SpielerDTO player2 = new SpielerDTO(
                2,
                "https://example.com/player2.jpg",
                "J. Smith",
                "Jane Smith",
                22,
                "https://example.com/flag.png",
                "Test Club",
                "https://example.com/club.png",
                75,
                90,
                "Midfielder",
                500000L,
                180,
                65,
                "left",
                70,
                80,
                75,
                80,
                70,
                80, 75, 80, 70, 80, 75, 80, 70, 80, 75, 80,50,70, 30000L);

        List<SpielerDTO> players = Arrays.asList(player1, player2);
        Pageable pageable = PageRequest.of(0, 10);
        Page<SpielerDTO> playerPage = new PageImpl<>(players, pageable, players.size());

        // Configure mock repository
        when(spielerRepository.findByFullNameFiltered("Doe",
                21,"","right",70,80,30,0,80,90,70, 100,
                50,70,8000,50000000L,70,90,50,99,40,85,67,88,80,95,
                45,99,55,98,65,70,88,99,10,100,40,99,50,
                89,60,99,70,99,10,80,70,99,84,99,40,99,
                pageable))
                .thenReturn(playerPage);

        // Test the repository method
        Page<SpielerDTO> result = spielerRepository.findByFullNameFiltered("Doe",
                21,"","right",70,80,30,0,80,90,70, 100,
                50,70,8000,50000000L,70,90,50,99,40,85,67,88,80,95,
                45,99,55,98,65,70,88,99,10,100,40,99,50,
                89,60,99,70,99,10,80,70,99,84,99,40,99,
                pageable);
        assertEquals(players, result.getContent());
    }
}