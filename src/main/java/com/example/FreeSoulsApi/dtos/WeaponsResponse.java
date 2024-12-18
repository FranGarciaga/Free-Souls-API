package com.example.FreeSoulsApi.dtos;

public record WeaponsResponse(
        int id,
        String name,
        int damage,
        int weight,
        String weaponType
) {
}
