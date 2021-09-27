package co.edu.platform.model.players.gateways;

import co.edu.platform.model.players.Players;

public interface PlayersRepository {

    public Players insertPlayer(int id, String name, String description, String nickname, String city, String country);
    public Players assignVideogame(int id, int idVideogames);
}
