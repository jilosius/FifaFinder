package com.fifafinder.fifadb;
import com.fifafinder.fifadb.DTOs.SpielerDTO;
import com.fifafinder.fifadb.repositories.SpielerRepository;
import com.fifafinder.fifadb.services.SpielerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SpielerServiceTest {
    @Mock
    private SpielerRepository spielerRepository;

    @InjectMocks
    private SpielerService spielerService;
    private static final int PAGE = 0;
    private static final int SIZE = 10;
    private static final Sort SORT = Sort.by("valueEUR").descending();

    private List<SpielerDTO> players;
    private Page<SpielerDTO> expectedPage;

    @Before
    public void setUp() {
        // Set up test data
        SpielerDTO player1 = new SpielerDTO(
                1,"https://example.com/player1.jpg", "J. Doe", "John Doe", 25, "https://example.com/flag.png", "SpVgg Test" ,"https://example.com/club.png", 80, 85, "Forward", 1000000L,
                185, 75, "right", 80, 70, 80, 75, 80,
                70, 80, 75, 80, 70, 80, 75, 80, 70,
                80, 75, 80, 80, 50000L);
        SpielerDTO player2 = new SpielerDTO(
                2,"https://example.com/player2.jpg", "J. Smith", "Jane Smith", 22, "https://example.com/flag.png", "FC Test","https://example.com/club.png", 75, 90, "Midfielder", 500000L,
                180, 65, "left", 70, 80, 75, 80, 70,
                80, 75, 80, 70, 80, 75, 80, 70, 80,
                75, 80,50,70, 30000L);

        players = Arrays.asList(player1, player2);
        expectedPage = new PageImpl<>(players);

        // Configure the mock repository
        when(spielerRepository.findByFullNameFiltered("Doe",
                21,"","right",70,80,30,0,80,90,70, 100,
                50,70,8000,50000000L,70,90,50,99,40,85,67,88,80,95,
                45,99,55,98,65,70,88,99,10,100,40,99,50,
                89,60,99,70,99,10,80,70,99,84,99,40,99,
                PageRequest.of(PAGE, SIZE, SORT))).thenReturn(expectedPage);
    }

    @Test
    public void testFindByFullNameFiltered() {
        // Execute the service method
        Page<SpielerDTO> result = spielerService.findByFullNameFiltered("Doe",
                21,"","right",70,80,30,0,80,90,70, 100,
                50,70,8000,50000000L,70,90,50,99,40,85,67,88,80,95,
                45,99,55,98,65,70,88,99,10,100,40,99,50,
                89,60,99,70,99,10,80,70,99,84,99,40,99,
                PAGE, SIZE, SORT);

        // Verify the results
        assertEquals(expectedPage.getContent(), result.getContent());
    }

}
