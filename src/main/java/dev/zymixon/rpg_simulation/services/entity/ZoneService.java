package dev.zymixon.rpg_simulation.services.entity;

import dev.zymixon.rpg_simulation.entities.Zone;
import dev.zymixon.rpg_simulation.repositories.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneService {

    private final ZoneRepository zoneRepository;

    @Autowired
    public ZoneService(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    public List<Zone> getAllZones(){
        return zoneRepository.findAll();
    }
}
