package co.edu.platform.model.players.services;

import lombok.Data;

@Data
public class PlayerRequest {

    private String name;
    private String description;
    private String nickname;
    private String city;
    private String country;
}
