package dev.zymixon.rpg_simulation.controllers;

import dev.zymixon.rpg_simulation.entities.Zone;
import dev.zymixon.rpg_simulation.services.entity.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zone")
public class ZoneController {

    private final ZoneService zoneService;

    @Autowired
    public ZoneController(ZoneService zoneService) {
        this.zoneService = zoneService;
    }

    @GetMapping("/find-all")
    public ResponseEntity<List<Zone>> getAllDungeons() {
        List<Zone> zones = zoneService.getAllZones();
        System.out.println("Zones: " + zones);
        return ResponseEntity.ok(zones);
    }
}
