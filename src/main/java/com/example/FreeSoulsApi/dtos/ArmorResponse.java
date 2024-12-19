package com.example.FreeSoulsApi.dtos;

public record ArmorResponse(
        Long id,
        String name,
        int defense,
        int weight,
        CharacterResponse character) {
}
