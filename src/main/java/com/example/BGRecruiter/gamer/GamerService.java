package com.example.BGRecruiter.gamer;

import com.example.BGRecruiter.game.Game;
import com.example.BGRecruiter.game.GameRepository;
import com.example.BGRecruiter.recruit.Recruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GamerService {

    private final GamerRepository gamerRepository;
    private final GameRepository gameRepository;

    @Autowired
    public GamerService(GamerRepository gamerRepository, GameRepository gameRepository) {
        this.gamerRepository = gamerRepository;
        this.gameRepository = gameRepository;
    }

    public List<Gamer> getGamer() {
        return gamerRepository.findAll();
    }

    public Gamer getGamerByEmail(String gamerEmail) {
        if(gamerRepository.findGamerByEmail(gamerEmail).isPresent()){
            return gamerRepository.findGamerByEmail(gamerEmail).get();
        } else throw new NullPointerException("No User Found");
    }

    public void addGamer(Gamer gamer) {
        Optional<Gamer> gamerByEmail = gamerRepository.findGamerByEmail(gamer.getEmail());

        if (gamerByEmail.isPresent()) {
            updateGamer(gamerByEmail.get(), gamer);
        } else {
            gamerRepository.save(gamer);
        }

    }

    public void updateGamer(Gamer existingGamer, Gamer updatedGamerPreference) {
        existingGamer.setGroupSize(updatedGamerPreference.getGroupSize());
        existingGamer.setPrefPlayTime(updatedGamerPreference.getPrefPlayTime());
        existingGamer.setComplexity(updatedGamerPreference.getComplexity());
        existingGamer.setPrefDomains(updatedGamerPreference.getPrefDomains());

        gamerRepository.save(existingGamer);
    }

    public void updateGamerOwnedGames(String gamerEmail, Long gameId) {
        Gamer gamerByEmail = getGamerByEmail(gamerEmail);

        Set<Long> ownedGames = gamerByEmail.getOwnedGames();

        ownedGames.add(gameId);

        gamerByEmail.setOwnedGames(ownedGames);

        gamerRepository.save(gamerByEmail);
    }


    public void updateGamerInterestedGames(String gamerEmail, Long gameId) {
        Gamer gamerByEmail = getGamerByEmail(gamerEmail);

        if (gamerByEmail == null) {
            throw new NullPointerException("User Not Found");
        }

        Set<Long> interestedGames = gamerByEmail.getInterestedGames();

        interestedGames.add(gameId);

        gamerByEmail.setInterestedGames(interestedGames);

        gamerRepository.save(gamerByEmail);
    }

    public List<Recruit> getRecruits(String gamerEmail) {
        Gamer gamerByEmail = getGamerByEmail(gamerEmail);

        Set<Long> ownedGames = gamerByEmail.getOwnedGames();

        List<Recruit> recruits = new ArrayList<>(List.of());

        ownedGames.forEach(
                i -> {
                    if(gamerRepository.findGamersByInterestedGamesContains(i).isPresent() && gameRepository.findById(i).isPresent()){
                    List<Gamer> recruitGamer = gamerRepository.findGamersByInterestedGamesContains(i).get();
                    Game recuitGame = gameRepository.findById(i).get();
                    recruitGamer.forEach(r ->{
                        Recruit newRecruit = new Recruit();
                        newRecruit.setId(r.getId());
                        newRecruit.setEmail(r.getEmail());
                        newRecruit.setMatchedGame(recuitGame.getName());

                        recruits.add(newRecruit);

                    });
                    }
                }

        );


        return recruits;
    }

    public List<Game> getOwnedGames(String gamerEmail) {
        Gamer gamerByEmail = getGamerByEmail(gamerEmail);

        Set<Long> ownedGamesById = gamerByEmail.getOwnedGames();

        List<Game> ownedGames = new ArrayList<>(List.of());

        ownedGamesById.forEach(
                i -> {
                    if(gameRepository.findById(i).isPresent()){
                    Game ownedgame = gameRepository.findById(i).get();

                    ownedGames.add(ownedgame);}
                }

        );

        return ownedGames;
    }

    public List<Game> getInterestedGames(String gamerEmail) {
        Gamer gamerByEmail = getGamerByEmail(gamerEmail);

        Set<Long> interestedGamesById = gamerByEmail.getInterestedGames();

        List<Game> interestedGames = new ArrayList<>(List.of());

        interestedGamesById.forEach(
                i -> {
                    if(gameRepository.findById(i).isPresent()){
                    Game interestedGame = gameRepository.findById(i).get();

                    interestedGames.add(interestedGame);
                    }
                }

        );

        return interestedGames;

    }

}
