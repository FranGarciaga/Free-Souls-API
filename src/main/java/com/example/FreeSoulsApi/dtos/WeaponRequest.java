package com.example.FreeSoulsApi.dtos;

public record WeaponRequest(
    String name,
    int damage,
    int weight,
    String weaponType,
    Long characterId
) {
}
