package com.example.FreeSoulsApi.dtos;

import com.example.FreeSoulsApi.entities.CharacterType;

public record CharacterRequest(
        String name,
        int level,
        String characterType,
        int health,
        int stamina,
        int strength
) {
}
