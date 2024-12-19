package com.example.FreeSoulsApi.dtos;

public record  CharacterResponse(
        Long id,
        String name,
        int level,
        String characterType,
        int health,
        int stamina,
        int strength
) {
}
