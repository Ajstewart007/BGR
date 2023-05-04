package com.example.BGRecruiter.recruit;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Recruit {

    private Long id;
    private String email;
    private String matchedGame;

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

    public String getMatchedGame() {
        return matchedGame;
    }

    public void setMatchedGame(String matchedGame) {
        this.matchedGame = matchedGame;
    }
}
