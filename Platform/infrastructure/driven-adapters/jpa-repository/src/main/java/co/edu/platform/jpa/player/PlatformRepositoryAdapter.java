package co.edu.platform.jpa.player;

import co.edu.platform.model.players.Players;
import co.edu.platform.model.players.gateways.PlayersRepository;
import co.edu.platform.model.players.services.AssignVideogameRequest;
import co.edu.platform.model.players.services.PlayerRequest;
import co.edu.platform.model.videogames.Videogames;
import co.edu.platform.model.videogames.gateways.VideogamesRepository;
import co.edu.platform.model.videogames.services.VideogameRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatformRepositoryAdapter implements PlayersRepository, VideogamesRepository {
    private int idPlayer = 0;
    private int idVideogame = 0;
    private List<Players> listPlayer = new ArrayList<>();
    private List<Videogames> listVideogame = new ArrayList<>();
    private List<Videogames> listVideogame2;

    @Override
    public Players insertPlayer(PlayerRequest playerRequest) {
        Players player =
                Players.builder()
                        .idPlayer(idPlayer + 1)
                        .name(playerRequest.getName())
                        .description(playerRequest.getDescription())
                        .nickname(playerRequest.getNickname())
                        .city(playerRequest.getCity())
                        .country(playerRequest.getCountry())
                        .build();
        listPlayer.add(player);
        idPlayer++;
        return listPlayer.get(idPlayer - 1);
    }

    @Override
    public List<Players> getAllPlayers() {
        return listPlayer;
    }

    @Override
    public Players assignVideogame(AssignVideogameRequest assignRequest) {
        listVideogame2 = new ArrayList<>();
        Players player = Players.builder().build();
        for (int a : assignRequest.getListVideogames()) {
            for (Videogames vg : listVideogame) {
                if (a == vg.getIdVideogames()) {
                    listVideogame2.add(vg);
                }
            }
        }

        for (Players pl : listPlayer) {
            if (assignRequest.getIdPlayer() == pl.getIdPlayer()) {
                player =
                        Players.builder()
                                .idPlayer(pl.getIdPlayer())
                                .name(pl.getName())
                                .description(pl.getDescription())
                                .nickname(pl.getNickname())
                                .city(pl.getCity())
                                .country(pl.getCountry())
                                .listVideogames(listVideogame2)
                                .build();
                listPlayer.set(pl.getIdPlayer(), player);
            }
        }
        return player;
    }

    @Override
    public Videogames insertVideogame(VideogameRequest videogameRequest) {
        Videogames videogame =
                Videogames.builder()
                        .idVideogames(idVideogame + 1)
                        .name(videogameRequest.getName())
                        .description(videogameRequest.getDescription())
                        .modality(videogameRequest.getModality())
                        .build();
        listVideogame.add(videogame);
        idVideogame++;
        return listVideogame.get(idVideogame - 1);
    }

    @Override
    public List<Videogames> getALlVideogames() {
        return null;
    }
}
