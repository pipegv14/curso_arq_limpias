package co.edu.platform.usecase.player;

import co.edu.platform.model.players.Players;
import co.edu.platform.model.players.gateways.PlayersRepository;
import co.edu.platform.model.players.services.PlayerRequest;
import co.edu.platform.model.videogames.Videogames;
import co.edu.platform.model.videogames.gateways.VideogamesRepository;
import co.edu.platform.model.videogames.services.VideogameRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.either;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = PlatformUseCaseTest.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PlatformUseCaseTest {

    private Players players;
    private Videogames videogames;
    PlayerRequest playerRequest;
    VideogameRequest videogameRequest;
    @SpyBean
    PlatformUseCase platformUseCase;
    @MockBean
    private PlayersRepository repositoryPlayer;
    @MockBean
    private VideogamesRepository repositoryVideogame;


    @BeforeEach
    void fillData() {
        this.players = Players.builder()
                .idPlayer(1)
                .name("Felipe")
                .nickname("pipe14")
                .build();
        when(this.repositoryPlayer.insertPlayer(any())).thenReturn(players);

        this.videogames = Videogames.builder()
                .idVideogames(1)
                .name("Fifa 22")
                .description("Soccer videogame")
                .build();
        when(this.repositoryVideogame.insertVideogame(any())).thenReturn(videogames);
    }


    @Test
    void verifyNotNullNameTest() {
        this.playerRequest = new PlayerRequest("", "fifa player", "", "Medellin", "Colombia");
        try {
            Players result = platformUseCase.savePlayer(this.playerRequest);
        } catch (RuntimeException ex) {
            assertEquals("El jugador no contiene un nombre", ex.getMessage());
        }
    }

    @Test
    void verifyNickNameContainsAnyNumber() {
        this.playerRequest = new PlayerRequest("Felipe", "fifa player", "pipe", "Medellin", "Colombia");
        try {
            Players result = platformUseCase.savePlayer(this.playerRequest);
        } catch (RuntimeException ex) {
            assertEquals("El nickname debe contener al menos un numero", ex.getMessage());
        }
    }

    @Test
    void verifyModalityVideogame() {
        this.videogameRequest = new VideogameRequest("NBA", "basketball video game", "competitiva");
        Videogames result = platformUseCase.saveVideogame(this.videogameRequest);
        assertThat(result.getModality(),
                either(containsString("individual")).
                        or(containsString("competitiva")).
                        or(containsString("cooperativa")));

    }
}

