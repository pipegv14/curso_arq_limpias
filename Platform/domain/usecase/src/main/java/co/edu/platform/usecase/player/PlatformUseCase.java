package co.edu.platform.usecase.player;

import co.edu.platform.model.players.Players;
import co.edu.platform.model.players.gateways.PlayersRepository;
import co.edu.platform.model.players.services.PlayerRequest;
import co.edu.platform.model.videogames.Videogames;
import co.edu.platform.model.videogames.gateways.VideogamesRepository;
import co.edu.platform.model.videogames.services.VideogameRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class PlatformUseCase {
    private PlayersRepository repositoryPlayer;
    private VideogamesRepository repositoryVideogame;

    public Players savePlayer(@NonNull PlayerRequest playerRequest) {
        repositoryPlayer.insertPlayer( );
    }

    public Videogames saveVideogame(@NonNull VideogameRequest videogameRequest) {
        repositoryVideogame.insertVideogames();
    }
}
