package com.example.FreeSoulsApi.dtos;

import jakarta.validation.constraints.*;

public record WeaponRequest(
        @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "The name must contain only letters.")
        @NotBlank(message = "The name cannot be blank")
        @NotEmpty(message = "The name cannot be empty.")
        @NotNull(message = "The name cannot be null.")
        @Size(max = 25, message = "The name cannot be greater than 25 numbers.")
        String name,
        @NotNull(message = "The damage cannot be null.")
        @Size(max = 100, message = "The damage cannot be greater than 100.")
        int damage,
        @NotNull(message = "The weight cannot be null.")
        @Size(max = 100, message = "The weight cannot be greater than 25 numbers.")
        int weight,
        @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "The weaponType must contain only letters.")
        @NotBlank(message = "The weaponType cannot be blank")
        @NotEmpty(message = "The weaponType cannot be empty.")
        @NotNull(message = "The weaponType cannot be null.")
        String weaponType,
        Long characterId
) {
}
