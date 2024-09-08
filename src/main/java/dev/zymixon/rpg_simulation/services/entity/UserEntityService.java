package dev.zymixon.rpg_simulation.services.entity;

import dev.zymixon.rpg_simulation.entities.UserEntity;
import dev.zymixon.rpg_simulation.repositories.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService {

    private final UserEntityRepository userRepository;

    @Autowired
    public UserEntityService(UserEntityRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity registerUser(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity loginUser(String username, String password) {
        UserEntity userEntity = userRepository.findByUsername(username);

        if (userEntity == null) return null;

        if (!password.equals(userEntity.getPassword())) return null;

        return userEntity;
    }
}
