package com.example.FreeSoulsApi.dtos;

import com.example.FreeSoulsApi.entities.CharacterType;
import jakarta.validation.constraints.*;

public record CharacterRequest(
        @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "The name must contain only letters.")
        @NotBlank(message = "The name cannot be blank")
        @NotEmpty(message = "The name cannot be empty.")
        @NotNull(message = "The name cannot be null.")
        @Size(max = 25, message = "The name cannot be greater than 25 letters.")
        String name,
        @NotNull(message = "The level cannot be null.")
        @Min(1)
        @Max(value = 100, message = "The level cannot be greater than 100")
        int level,
        @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "The characterType must contain only letters.")
        @NotBlank(message = "The characterType cannot be blank")
        @NotEmpty(message = "The characterType cannot be empty.")
        @NotNull(message = "The characterType cannot be null.")
        String characterType,
        @NotNull(message = "The health cannot be null.")
        @Max(value = 100, message = "The health cannot be greater than 110.")
        int health,
        @NotNull(message = "The stamina cannot be null.")
        @Max (value = 100, message = "The stamina cannot be greater than 100.")
        int stamina,
        @NotNull(message = "The strength cannot be null.")
        @Max (value = 100, message = "The strength cannot be greater than 100.")
        int strength
) {
}
