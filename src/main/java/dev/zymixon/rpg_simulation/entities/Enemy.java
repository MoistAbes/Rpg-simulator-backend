package dev.zymixon.rpg_simulation.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Enemy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int level;
    private int experience;

    private int health;
    private int attack;
    private int defense;
    private int speed;
    private int luck;

    @ManyToMany(mappedBy = "enemies")
    List<Dungeon> dungeons = new ArrayList<>();

    @Override
    public String toString() {
        return "Enemy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", experience=" + experience +
                ", health=" + health +
                ", attack=" + attack +
                ", defense=" + defense +
                ", speed=" + speed +
                ", luck=" + luck +
                '}';
    }
}
