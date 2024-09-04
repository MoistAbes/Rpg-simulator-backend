package dev.zymixon.rpg_simulation.controllers;

import dev.zymixon.rpg_simulation.entities.Character;
import dev.zymixon.rpg_simulation.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/character")
public class CharacterController {

    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<List<Character>> getPlayerCharacters(@PathVariable Long userId) {
        List<Character> characters = characterService.findAllCharactersByPlayerId(userId);
        System.out.println("Characters: " + characters);
        return ResponseEntity.ok(characters);
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Character> createCharacter(@RequestBody Character character) {
        Character createdCharacter = characterService.createCharacter(character);
        return ResponseEntity.ok(createdCharacter);
    }
}
