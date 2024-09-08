package dev.zymixon.rpg_simulation.services.entity;

import dev.zymixon.rpg_simulation.entities.Dungeon;
import dev.zymixon.rpg_simulation.repositories.DungeonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DungeonService {

    private final DungeonRepository dungeonRepository;

    @Autowired
    public DungeonService(DungeonRepository dungeonRepository) {
        this.dungeonRepository = dungeonRepository;
    }

    public List<Dungeon> getDungeons() {
        return dungeonRepository.findAll();
    }
}
