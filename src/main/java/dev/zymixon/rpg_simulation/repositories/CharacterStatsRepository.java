package dev.zymixon.rpg_simulation.repositories;

import dev.zymixon.rpg_simulation.entities.CharacterStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterStatsRepository extends JpaRepository<CharacterStats, Long> {
}
