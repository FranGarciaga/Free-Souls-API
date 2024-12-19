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

public class Armor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_armor")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "defense")
    private int defense;

    @Column(name = "weight")
    private int weight;

    @ManyToOne
    @JoinColumn(name = "character_id")
    @JsonIgnoreProperties(value = "armors")
    private Character character;

    public Armor(String name, int defense, int weight, Character character) {
        this.name = name;
        this.defense = defense;
        this.weight = weight;
        this.character = character;
    }
}
