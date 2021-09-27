package co.edu.platform.model.players;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Players {
    private final int idPlayer;
    private final String name;
    private final String description;
    private final String nickname;
    private final String city;
    private final String country;
    private final int idVideogames;
}
