package com.example.FreeSoulsApi.dtos;

import jakarta.validation.constraints.*;

public record ArmorRequest(
        @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "The name must contain only letters.")
        @NotBlank(message = "The name cannot be blank")
        @NotEmpty(message = "The name cannot be empty.")
        @NotNull(message = "The name cannot be null.")
        @Size(max = 25, message = "The name cannot be greater than 25 letters.")
        String name,
        @NotNull(message = "The defense cannot be null.")
        @Max (value = 100, message = "The defense cannot be greater than 110.")
        int defense,
        @NotNull(message = "The weight cannot be null.")
        @Max (value = 100, message = "The weight cannot be greater than 110.")
        int weight,
        Long characterId
) {
}
