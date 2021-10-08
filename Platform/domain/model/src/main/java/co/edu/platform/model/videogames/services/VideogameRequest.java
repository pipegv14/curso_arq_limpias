package co.edu.platform.model.videogames.services;

import lombok.Data;

@Data
public class VideogameRequest {

    private String name;
    private String description;
    private String modality;

    public VideogameRequest(String name, String description, String modality) {
        this.name = name;
        this.description = description;
        this.modality = modality;
    }
}
