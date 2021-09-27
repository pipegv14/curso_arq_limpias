package co.edu.platform.model.players;
import co.edu.platform.model.videogames.Videogames;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class Players {
    private final int idPlayer;
    private final String name;
    private final String description;
    private final String nickname;
    private final String city;
    private final String country;
    private final List<Videogames> listVideogames;
}
