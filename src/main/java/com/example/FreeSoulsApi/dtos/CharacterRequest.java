package com.example.FreeSoulsApi.dtos;

public record CharacterRequest(
        String name,
        int level,
        String characterType,
        int health,
        int stamina,
        int strength
) {
}
