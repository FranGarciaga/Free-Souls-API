package com.example.FreeSoulsApi.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_character", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private int level;

    @Column(name = "characterType")
    private String characterType;

    @Column(name = "health")
    private int health;

    @Column(name = "stamina")
    private int stamina;

    @Column(name = "strength")
    private  int strength;

    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "character")
    private List<Weapon> weapons;

    @OneToMany(mappedBy = "character", cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "character")
    private List<Armor> armors;

    public Character(String name, int level, String characterType, int health, int stamina, int strength) {
        this.name = name;
        this.level = level;
        this.characterType = characterType;
        this.health = health;
        this.stamina = stamina;
        this.strength = strength;
    }
}
