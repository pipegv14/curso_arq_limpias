package co.edu.platform.model.players.services;

import lombok.Data;

@Data
public class PlayerRequest {

    private String name;
    private String description;
    private String nickname;
    private String city;
    private String country;

    public PlayerRequest(String name, String description, String nickname, String city, String country) {
        this.name = name;
        this.description = description;
        this.nickname = nickname;
        this.city = city;
        this.country = country;
    }
}
