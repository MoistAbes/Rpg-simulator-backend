package dev.zymixon.rpg_simulation.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Dungeon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;


    @JsonIgnoreProperties("dungeons")
    @ManyToMany
    @JoinTable(
            name = "dungeons_enemies",
            joinColumns = @JoinColumn(name = "dungeon_id"),
            inverseJoinColumns = @JoinColumn(name = "enemy_id"))
    List<Enemy> enemies;


    @Override
    public String toString() {
        return "Dungeon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", enemies=" + enemies +
                '}';
    }
}
