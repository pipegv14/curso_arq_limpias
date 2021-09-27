package co.edu.platform.api.player;

import co.edu.platform.model.players.Players;
import co.edu.platform.model.players.services.AssignVideogameRequest;
import co.edu.platform.model.players.services.PlayerRequest;
import co.edu.platform.model.videogames.Videogames;
import co.edu.platform.model.videogames.services.VideogameRequest;
import co.edu.platform.usecase.player.PlatformUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/platform", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PlayerService {

    private final PlatformUseCase platformUseCase;


    @PostMapping(path = "/setplayer")
    public ResponseEntity setPlayer(@RequestBody PlayerRequest playerRequest) {

        Players player = platformUseCase.savePlayer(playerRequest);

        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @PostMapping(path = "/setvideogame")
    public ResponseEntity setVideogame(@RequestBody VideogameRequest videogameRequest) {

        Videogames videogames = platformUseCase.saveVideogame(videogameRequest);

        return new ResponseEntity<>(videogames, HttpStatus.OK);
    }

    @GetMapping(path = "/getallplayers")
    public ResponseEntity getAllPlayers() {

        List<Players> playersList = platformUseCase.getAllPlayers();

        return new ResponseEntity<>(playersList, HttpStatus.OK);
    }

    @PutMapping(path = "/assignvideogame")
    public ResponseEntity assignVideogame(@RequestBody AssignVideogameRequest videogameAssign) {

        Players player = platformUseCase.assignVideogame(videogameAssign);

        return new ResponseEntity<>(player, HttpStatus.OK);
    }

}
