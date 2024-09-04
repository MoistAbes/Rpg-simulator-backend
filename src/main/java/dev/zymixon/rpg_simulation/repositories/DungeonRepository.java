package dev.zymixon.rpg_simulation.repositories;

import dev.zymixon.rpg_simulation.entities.Dungeon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DungeonRepository extends JpaRepository<Dungeon, Long> {
}
