package com.example.BGRecruiter.gamer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class GamerTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Gamer#Gamer()}
     *   <li>{@link Gamer#setComplexity(String)}
     *   <li>{@link Gamer#setEmail(String)}
     *   <li>{@link Gamer#setGroupSize(Integer)}
     *   <li>{@link Gamer#setId(Long)}
     *   <li>{@link Gamer#setInterestedGames(Set)}
     *   <li>{@link Gamer#setOwnedGames(Set)}
     *   <li>{@link Gamer#setPrefDomains(String)}
     *   <li>{@link Gamer#setPrefPlayTime(String)}
     *   <li>{@link Gamer#getComplexity()}
     *   <li>{@link Gamer#getEmail()}
     *   <li>{@link Gamer#getGroupSize()}
     *   <li>{@link Gamer#getId()}
     *   <li>{@link Gamer#getInterestedGames()}
     *   <li>{@link Gamer#getOwnedGames()}
     *   <li>{@link Gamer#getPrefDomains()}
     *   <li>{@link Gamer#getPrefPlayTime()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Gamer actualGamer = new Gamer();
        actualGamer.setComplexity("Complexity");
        actualGamer.setEmail("jane.doe@example.org");
        actualGamer.setGroupSize(3);
        actualGamer.setId(1L);
        HashSet<Long> interestedGames = new HashSet<>();
        actualGamer.setInterestedGames(interestedGames);
        HashSet<Long> ownedGames = new HashSet<>();
        actualGamer.setOwnedGames(ownedGames);
        actualGamer.setPrefDomains("Pref Domains");
        actualGamer.setPrefPlayTime("Pref Play Time");
        assertEquals("Complexity", actualGamer.getComplexity());
        assertEquals("jane.doe@example.org", actualGamer.getEmail());
        assertEquals(3, actualGamer.getGroupSize().intValue());
        assertEquals(1L, actualGamer.getId().longValue());
        assertSame(interestedGames, actualGamer.getInterestedGames());
        assertSame(ownedGames, actualGamer.getOwnedGames());
        assertEquals("Pref Domains", actualGamer.getPrefDomains());
        assertEquals("Pref Play Time", actualGamer.getPrefPlayTime());
    }
}

