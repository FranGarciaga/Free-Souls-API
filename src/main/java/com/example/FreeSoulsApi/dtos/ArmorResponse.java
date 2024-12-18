package com.example.FreeSoulsApi.dtos;

public record ArmorResponse(
        int id,
        String name,
        int defense,
        int weight,
        CharacterResponse character) {
}
