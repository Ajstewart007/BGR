package com.example.BGRecruiter.gamer;

import com.example.BGRecruiter.game.Game;
import com.example.BGRecruiter.recruit.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/gamer")
@CrossOrigin("http://localhost:3000/")
public class GamerController {

    private final GamerService gamerService;

    @Autowired
    public GamerController(GamerService gamerService) {
        this.gamerService = gamerService;
    }

    @GetMapping
    public List<Gamer> getGamer() {
        return gamerService.getGamer();
    }

    @GetMapping(path = "/recruits")
    public List<Recruit> getRecruits(@RequestParam String gamerEmail) {
        return gamerService.getRecruits(gamerEmail);
    }

    @GetMapping(path = "/ownedGames")
    public List<Game> getOwnedGames(@RequestParam String gamerEmail) {
        return gamerService.getOwnedGames(gamerEmail);
    }

    @GetMapping(path = "/interestedGames")
    public List<Game> getInterestedGames(@RequestParam String gamerEmail) {
        return gamerService.getInterestedGames(gamerEmail);
    }


    @PostMapping
    public void addGamer(@RequestBody Gamer gamer) {
        gamerService.addGamer(gamer);
    }

    @PostMapping(path = "/addOwnedGame")
    public void updateGamerOwnedGames(@RequestParam String gamerEmail, @RequestParam Long gameId) {
        gamerService.updateGamerOwnedGames(gamerEmail, gameId);
    }

    @PostMapping(path = "/addInterestedGame")
    public void updateGamerInterestedGames(@RequestParam String gamerEmail, @RequestParam Long gameId) {
        gamerService.updateGamerInterestedGames(gamerEmail, gameId);
    }
}
