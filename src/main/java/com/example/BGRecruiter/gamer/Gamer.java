package com.example.BGRecruiter.gamer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Gamer {

    @Id
    @SequenceGenerator(
            name = "gamer_seq",
            sequenceName = "gamer_seq",
            allocationSize = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "gamer_seq"
    )
    private Long id;
    private String email;
    private Integer groupSize;
    private String prefPlayTime;
    private String complexity;
    private String prefDomains;

    @ElementCollection
    @CollectionTable(name = "gamer_owned_games", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "owned_games")
    private Set<Long> ownedGames;

    @ElementCollection
    @CollectionTable(name = "gamer_interested_games", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "interested_games")
    private Set<Long> interestedGames;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(Integer groupSize) {
        this.groupSize = groupSize;
    }

    public String getPrefPlayTime() {
        return prefPlayTime;
    }

    public void setPrefPlayTime(String prefPlayTime) {
        this.prefPlayTime = prefPlayTime;
    }

    public String getComplexity() {
        return complexity;
    }

    public void setComplexity(String complexity) {
        this.complexity = complexity;
    }

    public String getPrefDomains() {
        return prefDomains;
    }

    public void setPrefDomains(String prefDomains) {
        this.prefDomains = prefDomains;
    }

    public Set<Long> getOwnedGames() {
        return ownedGames;
    }

    public void setOwnedGames(Set<Long> ownedGames) {
        this.ownedGames = ownedGames;
    }

    public Set<Long> getInterestedGames() {
        return interestedGames;
    }

    public void setInterestedGames(Set<Long> interestedGames) {
        this.interestedGames = interestedGames;
    }
}
