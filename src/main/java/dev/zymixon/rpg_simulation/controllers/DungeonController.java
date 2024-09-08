package dev.zymixon.rpg_simulation.controllers;

import dev.zymixon.rpg_simulation.entities.Dungeon;
import dev.zymixon.rpg_simulation.services.entity.DungeonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/dungeon")
public class DungeonController {

    private final DungeonService dungeonService;

    @Autowired
    public DungeonController(DungeonService dungeonService) {
        this.dungeonService = dungeonService;
    }

    @GetMapping
    public ResponseEntity<List<Dungeon>> getAllDungeons(){
        List<Dungeon> dungeons = dungeonService.getDungeons();
        System.out.println("DUNGEONS: " + dungeons);
        return ResponseEntity.ok(dungeons);
    }

}
