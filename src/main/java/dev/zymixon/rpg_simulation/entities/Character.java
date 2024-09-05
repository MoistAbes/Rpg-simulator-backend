package dev.zymixon.rpg_simulation.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int level;
    private int experience;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stats_id", nullable = false)
    private CharacterStats stats;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties("characters")
    private UserEntity user;

    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("character")
    private List<CharacterStorage> storage = new ArrayList<>();

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", experience=" + experience +
                ", stats=" + stats +
                '}';
    }
}
