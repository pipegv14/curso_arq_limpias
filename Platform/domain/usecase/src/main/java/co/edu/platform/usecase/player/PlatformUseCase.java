package co.edu.platform.usecase.player;

import co.edu.platform.model.players.Players;
import co.edu.platform.model.players.gateways.PlayersRepository;
import co.edu.platform.model.players.services.AssignVideogameRequest;
import co.edu.platform.model.players.services.PlayerRequest;
import co.edu.platform.model.videogames.Videogames;
import co.edu.platform.model.videogames.gateways.VideogamesRepository;
import co.edu.platform.model.videogames.services.VideogameRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PlatformUseCase {
    private final PlayersRepository repositoryPlayer;
    private final VideogamesRepository repositoryVideogame;


    public Players savePlayer(PlayerRequest playerRequest) {
        if (!playerRequest.getName().isEmpty()) {
            //Valido por medio de la siguiente expresion regular que el nickname contenga al menos un número
            if (playerRequest.getNickname().matches("^(\\d?[a-zA-Z])*(\\d+)([a-zA-Z]\\d?)*$")) {
                return repositoryPlayer.insertPlayer(playerRequest);
            } else {
                throw new RuntimeException("El nickname debe contener al menos un numero");
            }
        } else {
            throw new RuntimeException("El jugador no contiene un nombre");
        }
    }

    public Videogames saveVideogame(VideogameRequest videogameRequest) {
        return repositoryVideogame.insertVideogame(videogameRequest);
    }

    public List<Players> getAllPlayers() {
        return repositoryPlayer.getAllPlayers();
    }

    public Players assignVideogame(@NonNull AssignVideogameRequest assignRequest) {
        return repositoryPlayer.assignVideogame(assignRequest);
    }
}
