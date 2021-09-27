package co.edu.platform.model.videogames;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Videogames {
    private final int idVideogames;
    private final String name;
    private final String description;
    private final String modality;
}
