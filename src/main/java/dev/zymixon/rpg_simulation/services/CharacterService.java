package dev.zymixon.rpg_simulation.services;

import dev.zymixon.rpg_simulation.entities.Character;
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

    public Character createCharacter(Character character){
        return characterRepository.save(generateStats(character));
    }

    private Character generateStats(Character character){

        character.setLevel(1);
        character.setExperience(0);

        character.setAttack(10);
        character.setDefense(5);
        character.setHealth(100);
        character.setLuck(5);
        character.setSpeed(5);

        return character;
    }
}
