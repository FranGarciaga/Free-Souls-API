package com.example.FreeSoulsApi.entities;

import lombok.Getter;

@Getter
public enum WeaponType {

    DAGGER(15,2),
    SHORT_SWORD(25,6),
    LONG_SWORD(35,10),
    CURVED_SWORD(60,15),
    GREAT_SWORD(90,25),
    AXE(45,12),
    BOW(30,7),
    GLINT_STONE_STAFF(60,15);



        private final int damage;
        private final int weight;


        WeaponType(int damage, int weight) {
            this.damage = damage;
            this.weight = weight;

        }
        public int getDamage() {
            return damage;
        }

        public int getWeight() {
            return weight;
        }

    }

