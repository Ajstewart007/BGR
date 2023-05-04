package com.example.BGRecruiter.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GameTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Game#Game()}
     *   <li>{@link Game#setComplexity(Integer)}
     *   <li>{@link Game#setDomain(String)}
     *   <li>{@link Game#setId(Long)}
     *   <li>{@link Game#setMaxPlayers(Integer)}
     *   <li>{@link Game#setMinAge(Integer)}
     *   <li>{@link Game#setMinPlayers(Integer)}
     *   <li>{@link Game#setName(String)}
     *   <li>{@link Game#setPlayTime(Integer)}
     *   <li>{@link Game#setRank(Integer)}
     *   <li>{@link Game#setRating(Integer)}
     *   <li>{@link Game#setYearPublished(String)}
     *   <li>{@link Game#getComplexity()}
     *   <li>{@link Game#getDomain()}
     *   <li>{@link Game#getId()}
     *   <li>{@link Game#getMaxPlayers()}
     *   <li>{@link Game#getMinAge()}
     *   <li>{@link Game#getMinPlayers()}
     *   <li>{@link Game#getName()}
     *   <li>{@link Game#getPlayTime()}
     *   <li>{@link Game#getRank()}
     *   <li>{@link Game#getRating()}
     *   <li>{@link Game#getYearPublished()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Game actualGame = new Game();
        actualGame.setComplexity(1);
        actualGame.setDomain("Domain");
        actualGame.setId(1L);
        actualGame.setMaxPlayers(3);
        actualGame.setMinAge(1);
        actualGame.setMinPlayers(1);
        actualGame.setName("Name");
        actualGame.setPlayTime(1);
        actualGame.setRank(1);
        actualGame.setRating(1);
        actualGame.setYearPublished("Year Published");
        assertEquals(1, actualGame.getComplexity().intValue());
        assertEquals("Domain", actualGame.getDomain());
        assertEquals(1L, actualGame.getId().longValue());
        assertEquals(3, actualGame.getMaxPlayers().intValue());
        assertEquals(1, actualGame.getMinAge().intValue());
        assertEquals(1, actualGame.getMinPlayers().intValue());
        assertEquals("Name", actualGame.getName());
        assertEquals(1, actualGame.getPlayTime().intValue());
        assertEquals(1, actualGame.getRank().intValue());
        assertEquals(1, actualGame.getRating().intValue());
        assertEquals("Year Published", actualGame.getYearPublished());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Game#Game(Long, String, String, Integer, Integer, Integer, Integer, Integer, Integer, Integer, String)}
     *   <li>{@link Game#setComplexity(Integer)}
     *   <li>{@link Game#setDomain(String)}
     *   <li>{@link Game#setId(Long)}
     *   <li>{@link Game#setMaxPlayers(Integer)}
     *   <li>{@link Game#setMinAge(Integer)}
     *   <li>{@link Game#setMinPlayers(Integer)}
     *   <li>{@link Game#setName(String)}
     *   <li>{@link Game#setPlayTime(Integer)}
     *   <li>{@link Game#setRank(Integer)}
     *   <li>{@link Game#setRating(Integer)}
     *   <li>{@link Game#setYearPublished(String)}
     *   <li>{@link Game#getComplexity()}
     *   <li>{@link Game#getDomain()}
     *   <li>{@link Game#getId()}
     *   <li>{@link Game#getMaxPlayers()}
     *   <li>{@link Game#getMinAge()}
     *   <li>{@link Game#getMinPlayers()}
     *   <li>{@link Game#getName()}
     *   <li>{@link Game#getPlayTime()}
     *   <li>{@link Game#getRank()}
     *   <li>{@link Game#getRating()}
     *   <li>{@link Game#getYearPublished()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Game actualGame = new Game(1L, "Name", "Year Published", 1, 3, 1, 1, 1, 1, 1, "Domain");
        actualGame.setComplexity(1);
        actualGame.setDomain("Domain");
        actualGame.setId(1L);
        actualGame.setMaxPlayers(3);
        actualGame.setMinAge(1);
        actualGame.setMinPlayers(1);
        actualGame.setName("Name");
        actualGame.setPlayTime(1);
        actualGame.setRank(1);
        actualGame.setRating(1);
        actualGame.setYearPublished("Year Published");
        assertEquals(1, actualGame.getComplexity().intValue());
        assertEquals("Domain", actualGame.getDomain());
        assertEquals(1L, actualGame.getId().longValue());
        assertEquals(3, actualGame.getMaxPlayers().intValue());
        assertEquals(1, actualGame.getMinAge().intValue());
        assertEquals(1, actualGame.getMinPlayers().intValue());
        assertEquals("Name", actualGame.getName());
        assertEquals(1, actualGame.getPlayTime().intValue());
        assertEquals(1, actualGame.getRank().intValue());
        assertEquals(1, actualGame.getRating().intValue());
        assertEquals("Year Published", actualGame.getYearPublished());
    }
}

