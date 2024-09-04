package dev.zymixon.rpg_simulation.repositories;

import dev.zymixon.rpg_simulation.entities.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
}
