package dev.zymixon.rpg_simulation.repositories;

import dev.zymixon.rpg_simulation.entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long> {
}
