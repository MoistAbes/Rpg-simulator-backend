package dev.zymixon.rpg_simulation.services.entity;

import dev.zymixon.rpg_simulation.entities.character.Character;
import dev.zymixon.rpg_simulation.entities.character.CharacterEquipment;
import dev.zymixon.rpg_simulation.entities.character.CharacterStats;
import dev.zymixon.rpg_simulation.entities.UserEntity;
import dev.zymixon.rpg_simulation.entities.items.InventoryItem;
import dev.zymixon.rpg_simulation.entities.items.Item;
import dev.zymixon.rpg_simulation.enums.EquipmentSlot;
import dev.zymixon.rpg_simulation.repositories.CharacterRepository;
import dev.zymixon.rpg_simulation.services.StatModifierService;
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

    private Character calculateCharacterStats(Character character) {

        int additionalDefense = character.getEquipment().stream()
                .filter(characterEquipment -> characterEquipment.getItem().getArmor() != null) // Filter items with armor
                .mapToInt(characterEquipment -> characterEquipment.getItem().getArmor().getDefense()) // Map to armor values
                .sum(); // Sum the armor values

        int additionalDamage = character.getEquipment().stream()
                .filter(characterEquipment -> characterEquipment.getItem().getWeapon() != null)
                .mapToInt(characterEquipment -> characterEquipment.getItem().getWeapon().getDamage())
                .sum();

        character.getStats().setAttack(character.getStats().getAttack() + additionalDamage);
        character.getStats().setDefense(character.getStats().getDefense() + additionalDefense);

        return character;
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

        Character prevCharacter = characterRepository.findById(character.getId()).orElse(null);

        List<CharacterEquipment> prevEquipmentList = prevCharacter.getEquipment();
        List<CharacterEquipment> currentEquipmentList = character.getEquipment();


        for (int i = 0; i < prevEquipmentList.size(); i++) {

            Item prevItem = prevEquipmentList.get(i).getItem();
            Item currentItem = currentEquipmentList.get(i).getItem();

            if (prevItem == null && currentItem == null) {
                // No change, do nothing
                continue;
            }

            if (prevItem == null) {
                // Adding new item
                applyItemStats(character, currentItem, true);
            } else if (currentItem == null) {
                // Removing item
                applyItemStats(character, prevItem, false);
            } else {
                // Replacing item (remove old, add new)
                applyItemStats(character, prevItem, false);
                applyItemStats(character, currentItem, true);
            }
        }


        character.getInventory().forEach(inventoryItem -> inventoryItem.setCharacter(character));
        character.getEquipment().forEach(equipment -> equipment.setCharacter(character));

        return characterRepository.save(character);
    }

    private void applyItemStats(Character character, Item item, boolean isAdding) {
        StatModifierService.fromItem(item).applyTo(character.getStats(), isAdding);
    }
}
