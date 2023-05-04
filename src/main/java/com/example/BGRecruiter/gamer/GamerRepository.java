package com.example.BGRecruiter.gamer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GamerRepository extends JpaRepository<Gamer, Long> {

    @Override
    Optional<Gamer> findById(Long aLong);

    Optional<Gamer> findGamerByEmail(String email);

    Optional<List<Gamer>> findGamersByInterestedGamesContains(Long gameId);


}
