package co.edu.platform.model.players.services;

import lombok.Data;

import java.util.List;

@Data
public class AssignVideogameRequest {
    private int idPlayer;
    private List<Integer> listVideogames;
}
