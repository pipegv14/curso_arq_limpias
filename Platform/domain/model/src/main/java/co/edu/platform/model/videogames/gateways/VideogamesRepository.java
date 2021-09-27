package co.edu.platform.model.videogames.gateways;

import co.edu.platform.model.modalities.Modalities;
import co.edu.platform.model.videogames.Videogames;

import java.util.List;

public interface VideogamesRepository {
    public Videogames insertVideogames(int id, String name, String description, Modalities modality);
    List<Videogames> getALlVideogames();
}
