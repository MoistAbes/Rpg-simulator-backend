package dev.zymixon.rpg_simulation.services;

import dev.zymixon.rpg_simulation.entities.Character;
import dev.zymixon.rpg_simulation.entities.UserEntity;
import dev.zymixon.rpg_simulation.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Character> findAllCharactersByPlayerId(Long id){
        return characterRepository.findAllByUserId(id);
    }

    public Character createCharacter(String characterName, Long userId){
        Character generatedCharacter = generateCharacter(characterName);
        generatedCharacter.setUser(new UserEntity(userId));

        return characterRepository.save(generatedCharacter);
    }

    private Character generateCharacter(String characterName){


        return Character.builder()
                .name(characterName)
                .level(1)
                .experience(0)
                .attack(10)
                .defense(5)
                .health(100)
                .luck(5)
                .speed(5)
                .build();
    }
}
