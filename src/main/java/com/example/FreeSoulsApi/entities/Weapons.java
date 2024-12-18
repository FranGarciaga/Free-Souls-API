package com.example.FreeSoulsApi.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Weapons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_weapon", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "damage")
    private int damage;

    @Column(name = "weight")
    private int weight;

    @Column(name = "weaponType")
    private String weaponType;

    @ManyToOne
    @JoinColumn(name = "character_id")
    @JsonIgnoreProperties(value = "weapons")
    private Character character;

    public Weapons(String name, int damage, int weight, String weaponType, Character character) {
        this.name = name;
        this.damage = damage;
        this.weight = weight;
        this.weaponType = weaponType;
        this.character = character;
    }
}
