package com.example.BGRecruiter.game;

import jakarta.persistence.*;

@Entity
@Table
public class Game {

    @Id
    @SequenceGenerator(
            name = "game_seq",
            sequenceName = "game_seq",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "game_seq"
    )
    private Long id;
    private String name;
    private String yearPublished;
    private Integer minPlayers;
    private Integer maxPlayers;
    private Integer playTime;
    private Integer minAge;
    private Integer rating;
    private Integer complexity;
    private Integer rank;
    private String domain;

    public Game() {
    }

    public Game(Long id, String name, String yearPublished, Integer minPlayers, Integer maxPlayers, Integer playTime, Integer minAge, Integer rating, Integer complexity, Integer rank, String domain) {
        this.id = id;
        this.name = name;
        this.yearPublished = yearPublished;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.playTime = playTime;
        this.minAge = minAge;
        this.rating = rating;
        this.complexity = complexity;
        this.rank = rank;
        this.domain = domain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    public Integer getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(Integer minPlayers) {
        this.minPlayers = minPlayers;
    }

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public Integer getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Integer playTime) {
        this.playTime = playTime;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getComplexity() {
        return complexity;
    }

    public void setComplexity(Integer complexity) {
        this.complexity = complexity;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}