package dev.zymixon.rpg_simulation.controllers;

import dev.zymixon.rpg_simulation.entities.character.Character;
import dev.zymixon.rpg_simulation.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // Allow all origins
@RestController
@RequestMapping(value = "/character")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping(value = "/find-all/{userId}")
    public ResponseEntity<List<Character>> getPlayerCharacters(@PathVariable Long userId) {
        List<Character> characters = characterService.findAllCharactersByPlayerId(userId);
        System.out.println("Characters: " + characters);
        return ResponseEntity.ok(characters);
    }

    @GetMapping(value = "/create/{characterName}/{userId}")
    public ResponseEntity<Character> createCharacter(@PathVariable String characterName ,@PathVariable Long userId) {
        Character createdCharacter = characterService.createCharacter(characterName, userId);
        return ResponseEntity.ok(createdCharacter);
    }

    @PostMapping("/update")
    public ResponseEntity<Character> updateCharacter(@RequestBody Character character) {
        System.out.println("CHARACTER TO UPDATE: " + character);
        Character updatedCharacter = characterService.updateCharacter(character);
        return ResponseEntity.ok(updatedCharacter);
    }
}
