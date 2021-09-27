package co.edu.platform.model.videogames;

import co.edu.platform.model.modalities.Modalities;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Videogames {
    private final int idVideogames;
    private final String name;
    private final String description;
    private final Modalities modality;
}
