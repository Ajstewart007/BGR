package com.example.BGRecruiter.gamer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.BGRecruiter.game.Game;
import com.example.BGRecruiter.game.GameRepository;
import com.example.BGRecruiter.recruit.Recruit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GamerControllerTest {
    /**
     * Method under test: {@link GamerController#getGamer()}
     */
    @Test
    void testGetGamer() {
        GamerRepository gamerRepository = mock(GamerRepository.class);
        ArrayList<Gamer> gamerList = new ArrayList<>();
        when(gamerRepository.findAll()).thenReturn(gamerList);
        List<Gamer> actualGamer = (new GamerController(new GamerService(gamerRepository, mock(GameRepository.class))))
                .getGamer();
        assertSame(gamerList, actualGamer);
        assertTrue(actualGamer.isEmpty());
        verify(gamerRepository).findAll();
    }

    /**
     * Method under test: {@link GamerController#getGamer()}
     */
    @Test
    void testGetGamer2() {
        GamerService gamerService = mock(GamerService.class);
        ArrayList<Gamer> gamerList = new ArrayList<>();
        when(gamerService.getGamer()).thenReturn(gamerList);
        List<Gamer> actualGamer = (new GamerController(gamerService)).getGamer();
        assertSame(gamerList, actualGamer);
        assertTrue(actualGamer.isEmpty());
        verify(gamerService).getGamer();
    }

    /**
     * Method under test: {@link GamerController#getRecruits(String)}
     */
    @Test
    void testGetRecruits() {

        GamerRepository gamerRepository = mock(GamerRepository.class);
        HashSet<Long> ownedGames = new HashSet<>();
        when(gamerRepository.findGamerByEmail(Mockito.<String>any())).thenReturn(Optional.of(new Gamer(1L,
                "jane.doe@example.org", 3, "Pref Play Time", "Complexity", "Pref Domains", ownedGames, new HashSet<>())));
        assertTrue((new GamerController(new GamerService(gamerRepository, mock(GameRepository.class))))
                .getRecruits("jane.doe@example.org")
                .isEmpty());
        verify(gamerRepository, atLeast(1)).findGamerByEmail(Mockito.<String>any());
    }

    /**
     * Method under test: {@link GamerController#getOwnedGames(String)}
     */
    @Test
    void testGetOwnedGames() {

        GamerRepository gamerRepository = mock(GamerRepository.class);
        HashSet<Long> ownedGames = new HashSet<>();
        when(gamerRepository.findGamerByEmail(Mockito.<String>any())).thenReturn(Optional.of(new Gamer(1L,
                "jane.doe@example.org", 3, "Pref Play Time", "Complexity", "Pref Domains", ownedGames, new HashSet<>())));
        assertTrue((new GamerController(new GamerService(gamerRepository, mock(GameRepository.class))))
                .getOwnedGames("jane.doe@example.org")
                .isEmpty());
        verify(gamerRepository, atLeast(1)).findGamerByEmail(Mockito.<String>any());
    }
    

    /**
     * Method under test: {@link GamerController#getInterestedGames(String)}
     */
    @Test
    void testGetInterestedGames() {
        GamerRepository gamerRepository = mock(GamerRepository.class);
        HashSet<Long> ownedGames = new HashSet<>();
        when(gamerRepository.findGamerByEmail(Mockito.<String>any())).thenReturn(Optional.of(new Gamer(1L,
                "jane.doe@example.org", 3, "Pref Play Time", "Complexity", "Pref Domains", ownedGames, new HashSet<>())));
        assertTrue((new GamerController(new GamerService(gamerRepository, mock(GameRepository.class))))
                .getInterestedGames("jane.doe@example.org")
                .isEmpty());
        verify(gamerRepository, atLeast(1)).findGamerByEmail(Mockito.<String>any());
    }

    /**
     * Method under test: {@link GamerController#addGamer(Gamer)}
     */
    @Test
    void testAddGamer() {
        GamerRepository gamerRepository = mock(GamerRepository.class);
        when(gamerRepository.save(Mockito.<Gamer>any())).thenReturn(new Gamer());
        when(gamerRepository.findGamerByEmail(Mockito.<String>any())).thenReturn(Optional.of(new Gamer()));
        GamerController gamerController = new GamerController(
                new GamerService(gamerRepository, mock(GameRepository.class)));
        gamerController.addGamer(new Gamer());
        verify(gamerRepository).save(Mockito.<Gamer>any());
        verify(gamerRepository).findGamerByEmail(Mockito.<String>any());
    }

    /**
     * Method under test: {@link GamerController#updateGamerOwnedGames(String, Long)}
     */
    @Test
    void testUpdateGamerOwnedGames() {
        GamerRepository gamerRepository = mock(GamerRepository.class);
        when(gamerRepository.save(Mockito.<Gamer>any())).thenReturn(new Gamer());
        HashSet<Long> ownedGames = new HashSet<>();
        when(gamerRepository.findGamerByEmail(Mockito.<String>any())).thenReturn(Optional.of(new Gamer(1L,
                "jane.doe@example.org", 3, "Pref Play Time", "Complexity", "Pref Domains", ownedGames, new HashSet<>())));
        (new GamerController(new GamerService(gamerRepository, mock(GameRepository.class))))
                .updateGamerOwnedGames("jane.doe@example.org", 1L);
        verify(gamerRepository).save(Mockito.<Gamer>any());
        verify(gamerRepository, atLeast(1)).findGamerByEmail(Mockito.<String>any());
    }
    

    /**
     * Method under test: {@link GamerController#updateGamerInterestedGames(String, Long)}
     */
    @Test
    void testUpdateGamerInterestedGames() {
        GamerRepository gamerRepository = mock(GamerRepository.class);
        when(gamerRepository.save(Mockito.<Gamer>any())).thenReturn(new Gamer());
        HashSet<Long> ownedGames = new HashSet<>();
        when(gamerRepository.findGamerByEmail(Mockito.<String>any())).thenReturn(Optional.of(new Gamer(1L,
                "jane.doe@example.org", 3, "Pref Play Time", "Complexity", "Pref Domains", ownedGames, new HashSet<>())));
        (new GamerController(new GamerService(gamerRepository, mock(GameRepository.class))))
                .updateGamerInterestedGames("jane.doe@example.org", 1L);
        verify(gamerRepository).save(Mockito.<Gamer>any());
        verify(gamerRepository, atLeast(1)).findGamerByEmail(Mockito.<String>any());
    }

}

