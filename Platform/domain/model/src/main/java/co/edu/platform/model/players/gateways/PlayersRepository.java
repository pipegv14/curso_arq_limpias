package co.edu.platform.model.players.gateways;

import co.edu.platform.model.players.Players;
import co.edu.platform.model.players.services.AssignVideogameRequest;
import co.edu.platform.model.players.services.PlayerRequest;

import java.util.List;

public interface PlayersRepository {

    public Players insertPlayer(PlayerRequest playerRequest);
    public List<Players> getAllPlayers();
    Players assignVideogame(AssignVideogameRequest assignRequest);

}
