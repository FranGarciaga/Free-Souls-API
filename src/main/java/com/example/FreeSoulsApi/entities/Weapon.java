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

public class Weapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_weapon", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "damage")
    private int damage;

    @Column(name = "weight")
    private int weight;

    @Enumerated(EnumType.STRING)
    @Column(name = "weaponType")
    private WeaponType weaponType;

    @ManyToOne
    @JoinColumn(name = "character_id")
    @JsonIgnoreProperties(value = "weapons")
    private Character character;

    public Weapon(String name, int damage, int weight, WeaponType weaponType, Character character) {
        this.name = name;
        this.damage = weaponType.getDamage();
        this.weight = weaponType.getWeight();
        this.weaponType = weaponType;
        this.character = character;
    }
}
