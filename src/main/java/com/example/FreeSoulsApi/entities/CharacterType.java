package com.example.FreeSoulsApi.entities;

import lombok.Getter;

@Getter
public enum CharacterType {
    ASTROLOGER(80,40,15),
    BANDIT(100,50,30),
    CONFESSOR(85,35,20),
    WARRIOR(100,50,50),
    HERO(100,55,50),
    MISERABLE(50,20,20),
    PRISONER(80,30,30),
    PROPHET(85,35,35),
    SAMURAI(95,45,45),
    VAGRANT(100,50,55);


    private final int health;
    private final int stamina;
    private final int strength;

    CharacterType(int health, int stamina, int strength) {
        this.health = health;
        this.stamina = stamina;
        this.strength = strength;
    }

}
