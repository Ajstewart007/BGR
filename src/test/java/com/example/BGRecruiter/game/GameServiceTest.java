package com.example.BGRecruiter.game;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.BGRecruiter.gamer.Gamer;
import com.example.BGRecruiter.gamer.GamerRepository;
import com.example.BGRecruiter.gamer.GamerService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GameServiceTest {
    /**
     * Method under test: {@link GameService#getGame()}
     */
    @Test
    void testGetGame() {

        GameRepository gameRepository = mock(GameRepository.class);
        ArrayList<Game> gameList = new ArrayList<>();
        when(gameRepository.findAll()).thenReturn(gameList);
        List<Game> actualGame = (new GameService(gameRepository,
                new GamerService(mock(GamerRepository.class), mock(GameRepository.class)))).getGame();
        assertSame(gameList, actualGame);
        assertTrue(actualGame.isEmpty());
        verify(gameRepository).findAll();
    }

    /**
     * Method under test: {@link GameService#getRecommendations(String)}
     */
    @Test
    void testGetRecommendations() {

        GameRepository gameRepository = mock(GameRepository.class);
        Optional<List<Game>> ofResult = Optional.of(new ArrayList<>());
        when(gameRepository
                .findTop50ByMinPlayersIsLessThanEqualAndMaxPlayersGreaterThanEqualAndComplexityIsLessThanEqualAndDomainContainsAndPlayTimeIsLessThanEqualOrderByRank(
                        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any(),
                        Mockito.<Integer>any())).thenReturn(ofResult);
        GamerRepository gamerRepository = mock(GamerRepository.class);
        HashSet<Long> ownedGames = new HashSet<>();
        when(gamerRepository.findGamerByEmail(Mockito.<String>any())).thenReturn(
                Optional.of(new Gamer(1L, "jane.doe@example.org", 3, "Hard", "Hard", "Hard", ownedGames, new HashSet<>())));
        Optional<List<Game>> actualRecommendations = (new GameService(gameRepository,
                new GamerService(gamerRepository, mock(GameRepository.class)))).getRecommendations("jane.doe@example.org");
        assertSame(ofResult, actualRecommendations);
        assertTrue(actualRecommendations.isPresent());
        verify(gameRepository)
                .findTop50ByMinPlayersIsLessThanEqualAndMaxPlayersGreaterThanEqualAndComplexityIsLessThanEqualAndDomainContainsAndPlayTimeIsLessThanEqualOrderByRank(
                        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<String>any(),
                        Mockito.<Integer>any());
        verify(gamerRepository, atLeast(1)).findGamerByEmail(Mockito.<String>any());
    }

}

