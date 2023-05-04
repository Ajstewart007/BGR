package com.example.BGRecruiter.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/game")
@CrossOrigin("http://localhost:3000/")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> getGame() {
        return gameService.getGame();
    }


    @GetMapping(path = "/recommend")
    public Optional<List<Game>> getRecommendations(@RequestParam String gamerEmail) {
        return gameService.getRecommendations(gamerEmail);
    }


}
