package co.edu.platform.model.videogames.gateways;

import co.edu.platform.model.videogames.Videogames;
import co.edu.platform.model.videogames.services.VideogameRequest;

import java.util.List;

public interface VideogamesRepository {
    Videogames insertVideogame(VideogameRequest videogameRequest);

    List<Videogames> getALlVideogames();
}
