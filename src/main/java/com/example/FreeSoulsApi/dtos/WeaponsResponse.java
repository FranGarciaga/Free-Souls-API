package com.example.FreeSoulsApi.dtos;

public record WeaponsResponse(
        Long id,
        String name,
        int damage,
        int weight,
        String weaponType
) {
}
