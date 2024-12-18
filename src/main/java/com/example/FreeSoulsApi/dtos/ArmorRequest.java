package com.example.FreeSoulsApi.dtos;

public record ArmorRequest(
        String name,
        int defense,
        int weight
) {
}
