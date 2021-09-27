package co.edu.platform.model.videogames.gateways;

import co.edu.platform.model.videogames.Videogames;
import co.edu.platform.model.videogames.services.VideogameRequest;

import java.util.List;

public interface VideogamesRepository {
    public Videogames insertVideogame(VideogameRequest videogameRequest);

    List<Videogames> getALlVideogames();
}
