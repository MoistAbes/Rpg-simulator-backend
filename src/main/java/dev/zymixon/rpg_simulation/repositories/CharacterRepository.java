package dev.zymixon.rpg_simulation.repositories;

import dev.zymixon.rpg_simulation.entities.Character;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface CharacterRepository extends JpaRepository<Character, Long> {

    //@Query()
    List<Character> findAllByUserId(long userId);
}
