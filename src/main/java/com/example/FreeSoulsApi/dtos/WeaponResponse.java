package com.example.FreeSoulsApi.dtos;

public record WeaponResponse(
        Long id,
        String name,
        int damage,
        int weight,
        String weaponType
) {
}
