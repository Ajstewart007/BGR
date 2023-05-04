package com.example.BGRecruiter.game;

import com.example.BGRecruiter.gamer.Gamer;
import com.example.BGRecruiter.gamer.GamerService;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GameService {

    private final GameRepository gameRepository;
    private final GamerService gamerService;

    @Autowired
    public GameService(GameRepository gameRepository, GamerService gamerService) {
        this.gameRepository = gameRepository;
        this.gamerService = gamerService;
    }


    public List<Game> getGame() {
        return gameRepository.findAll();
    }

    public Optional<List<Game>> getRecommendations(String gamerEmail) {

        Gamer gamer = gamerService.getGamerByEmail(gamerEmail);
        Set<Long> ownedGames = gamer.getOwnedGames();
        List<Long> mainList = new ArrayList<Long>();

        Optional<List<Game>> rec = gameRepository.findTop50ByMinPlayersIsLessThanEqualAndMaxPlayersGreaterThanEqualAndComplexityIsLessThanEqualAndDomainContainsAndPlayTimeIsLessThanEqualOrderByRank(
                gamer.getGroupSize(),
                gamer.getGroupSize(),
                getComplexity(gamer),
                gamer.getPrefDomains(),
                getPlayTime(gamer)
        );

        gamerService.getOwnedGames(gamerEmail).forEach(i->{
            rec.get().remove(i);
        });

        return rec;
    }

    private Integer getComplexity(Gamer gamer) {
        if (gamer.getComplexity().equals("Hard")) {
            return 10;
        } else if (gamer.getComplexity().equals("Medium")) {
            return 6;
        } else {
            return 3;
        }
    }

    private Integer getPlayTime(Gamer gamer) {
        if (gamer.getPrefPlayTime().equals("Long")) {
            return 60000;
        } else if (gamer.getPrefPlayTime().equals("Medium")) {
            return 90;
        } else {
            return 30;
        }
    }

}
