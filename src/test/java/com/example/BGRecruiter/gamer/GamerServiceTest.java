package com.example.BGRecruiter.gamer;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.BGRecruiter.game.GameRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GamerServiceTest {
    /**
     * Method under test: {@link GamerService#getGamer()}
     */
    @Test
    void testGetGamer() {

        GamerRepository gamerRepository = mock(GamerRepository.class);
        ArrayList<Gamer> gamerList = new ArrayList<>();
        when(gamerRepository.findAll()).thenReturn(gamerList);
        List<Gamer> actualGamer = (new GamerService(gamerRepository, mock(GameRepository.class))).getGamer();
        assertSame(gamerList, actualGamer);
        assertTrue(actualGamer.isEmpty());
        verify(gamerRepository).findAll();
    }

    /**
     * Method under test: {@link GamerService#getGamerByEmail(String)}
     */
    @Test
    void testGetGamerByEmail() {

        GamerRepository gamerRepository = mock(GamerRepository.class);
        Gamer gamer = new Gamer();
        when(gamerRepository.findGamerByEmail(Mockito.<String>any())).thenReturn(Optional.of(gamer));
        assertSame(gamer,
                (new GamerService(gamerRepository, mock(GameRepository.class))).getGamerByEmail("jane.doe@example.org"));
        verify(gamerRepository, atLeast(1)).findGamerByEmail(Mockito.<String>any());
    }

    /**
     * Method under test: {@link GamerService#addGamer(Gamer)}
     */
    @Test
    void testAddGamer() {

        GamerRepository gamerRepository = mock(GamerRepository.class);
        when(gamerRepository.save(Mockito.<Gamer>any())).thenReturn(new Gamer());
        when(gamerRepository.findGamerByEmail(Mockito.<String>any())).thenReturn(Optional.of(new Gamer()));
        GamerService gamerService = new GamerService(gamerRepository, mock(GameRepository.class));
        gamerService.addGamer(new Gamer());
        verify(gamerRepository).save(Mockito.<Gamer>any());
        verify(gamerRepository).findGamerByEmail(Mockito.<String>any());
    }

    /**
     * Method under test: {@link GamerService#updateGamer(Gamer, Gamer)}
     */
    @Test
    void testUpdateGamer() {

        GamerRepository gamerRepository = mock(GamerRepository.class);
        when(gamerRepository.save(Mockito.<Gamer>any())).thenReturn(new Gamer());
        GamerService gamerService = new GamerService(gamerRepository, mock(GameRepository.class));
        Gamer existingGamer = new Gamer();
        gamerService.updateGamer(existingGamer, new Gamer());
        verify(gamerRepository).save(Mockito.<Gamer>any());
        assertNull(existingGamer.getComplexity());
        assertNull(existingGamer.getPrefPlayTime());
        assertNull(existingGamer.getPrefDomains());
        assertNull(existingGamer.getGroupSize());
    }
    

    /**
     * Method under test: {@link GamerService#updateGamerOwnedGames(String, Long)}
     */
    @Test
    void testUpdateGamerOwnedGames() {

        GamerRepository gamerRepository = mock(GamerRepository.class);
        when(gamerRepository.save(Mockito.<Gamer>any())).thenReturn(new Gamer());
        HashSet<Long> ownedGames = new HashSet<>();
        when(gamerRepository.findGamerByEmail(Mockito.<String>any())).thenReturn(Optional.of(new Gamer(1L,
                "jane.doe@example.org", 3, "Pref Play Time", "Complexity", "Pref Domains", ownedGames, new HashSet<>())));
        (new GamerService(gamerRepository, mock(GameRepository.class))).updateGamerOwnedGames("jane.doe@example.org", 1L);
        verify(gamerRepository).save(Mockito.<Gamer>any());
        verify(gamerRepository, atLeast(1)).findGamerByEmail(Mockito.<String>any());
    }
    

    /**
     * Method under test: {@link GamerService#updateGamerInterestedGames(String, Long)}
     */
    @Test
    void testUpdateGamerInterestedGames() {

        GamerRepository gamerRepository = mock(GamerRepository.class);
        when(gamerRepository.save(Mockito.<Gamer>any())).thenReturn(new Gamer());
        HashSet<Long> ownedGames = new HashSet<>();
        when(gamerRepository.findGamerByEmail(Mockito.<String>any())).thenReturn(Optional.of(new Gamer(1L,
                "jane.doe@example.org", 3, "Pref Play Time", "Complexity", "Pref Domains", ownedGames, new HashSet<>())));
        (new GamerService(gamerRepository, mock(GameRepository.class))).updateGamerInterestedGames("jane.doe@example.org",
                1L);
        verify(gamerRepository).save(Mockito.<Gamer>any());
        verify(gamerRepository, atLeast(1)).findGamerByEmail(Mockito.<String>any());
    }

    /**
     * Method under test: {@link GamerService#getRecruits(String)}
     */
    @Test
    void testGetRecruits() {

        GamerRepository gamerRepository = mock(GamerRepository.class);
        HashSet<Long> ownedGames = new HashSet<>();
        when(gamerRepository.findGamerByEmail(Mockito.<String>any())).thenReturn(Optional.of(new Gamer(1L,
                "jane.doe@example.org", 3, "Pref Play Time", "Complexity", "Pref Domains", ownedGames, new HashSet<>())));
        assertTrue((new GamerService(gamerRepository, mock(GameRepository.class))).getRecruits("jane.doe@example.org")
                .isEmpty());
        verify(gamerRepository, atLeast(1)).findGamerByEmail(Mockito.<String>any());
    }

    /**
     * Method under test: {@link GamerService#getOwnedGames(String)}
     */
    @Test
    void testGetOwnedGames() {

        GamerRepository gamerRepository = mock(GamerRepository.class);
        HashSet<Long> ownedGames = new HashSet<>();
        when(gamerRepository.findGamerByEmail(Mockito.<String>any())).thenReturn(Optional.of(new Gamer(1L,
                "jane.doe@example.org", 3, "Pref Play Time", "Complexity", "Pref Domains", ownedGames, new HashSet<>())));
        assertTrue((new GamerService(gamerRepository, mock(GameRepository.class))).getOwnedGames("jane.doe@example.org")
                .isEmpty());
        verify(gamerRepository, atLeast(1)).findGamerByEmail(Mockito.<String>any());
    }

    /**
     * Method under test: {@link GamerService#getInterestedGames(String)}
     */
    @Test
    void testGetInterestedGames() {

        GamerRepository gamerRepository = mock(GamerRepository.class);
        HashSet<Long> ownedGames = new HashSet<>();
        when(gamerRepository.findGamerByEmail(Mockito.<String>any())).thenReturn(Optional.of(new Gamer(1L,
                "jane.doe@example.org", 3, "Pref Play Time", "Complexity", "Pref Domains", ownedGames, new HashSet<>())));
        assertTrue(
                (new GamerService(gamerRepository, mock(GameRepository.class))).getInterestedGames("jane.doe@example.org")
                        .isEmpty());
        verify(gamerRepository, atLeast(1)).findGamerByEmail(Mockito.<String>any());
    }
}

