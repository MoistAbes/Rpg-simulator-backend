package dev.zymixon.rpg_simulation.services;

import dev.zymixon.rpg_simulation.entities.character.Character;
import dev.zymixon.rpg_simulation.entities.character.CharacterEquipment;
import dev.zymixon.rpg_simulation.entities.character.CharacterStats;
import dev.zymixon.rpg_simulation.entities.UserEntity;
import dev.zymixon.rpg_simulation.entities.items.InventoryItem;
import dev.zymixon.rpg_simulation.enums.EquipmentSlot;
import dev.zymixon.rpg_simulation.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        Character generatedCharacter = Character.builder()
                .name(characterName)
                .level(1)
                .experience(0)
                .stats(CharacterStats.builder()
                        .attack(5)
                        .defense(5)
                        .health(100)
                        .build())
                .build();

        //generate inventory
        List<InventoryItem> inventory = new ArrayList<>();

        for (int i = 0; i < 10; i++){
            inventory.add(InventoryItem.builder()
                    .character(generatedCharacter)
                    .item(null)
                    .location(i)
                    .quantity(0)
                    .build());
        }
        generatedCharacter.setInventory(inventory);

        //generate equipment
        List<CharacterEquipment> equipment = new ArrayList<>();

        for (EquipmentSlot slot: EquipmentSlot.values()){
            equipment.add(CharacterEquipment.builder()
                            .slot(slot)
                            .character(generatedCharacter)
                            .item(null)
                    .build());
        }

        generatedCharacter.setEquipment(equipment);

        return generatedCharacter;
    }

    public Character updateCharacter(Character character){


        character.getInventory().forEach(inventoryItem -> inventoryItem.setCharacter(character));

        return characterRepository.save(character);
    }
}
