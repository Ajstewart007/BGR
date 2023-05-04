package com.example.BGRecruiter.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    @Override
    Optional<Game> findById(Long aLong);

    Optional<List<Game>> findTop50ByMinPlayersIsLessThanEqualAndMaxPlayersGreaterThanEqualAndComplexityIsLessThanEqualAndDomainContainsAndPlayTimeIsLessThanEqualOrderByRank(Integer groupSizeMin, Integer groupSizeMax, Integer Complexity, String Domain, Integer playtime);

}
