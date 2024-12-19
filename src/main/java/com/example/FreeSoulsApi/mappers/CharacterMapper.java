package com.example.FreeSoulsApi.mappers;

import com.example.FreeSoulsApi.dtos.CharacterRequest;
import com.example.FreeSoulsApi.dtos.CharacterResponse;
import com.example.FreeSoulsApi.entities.Character;
import com.example.FreeSoulsApi.entities.CharacterType;  // Asegúrate de importar el enum

public class CharacterMapper {
    public static Character fromRequest(CharacterRequest characterRequest) {

        if (characterRequest.name() == null || characterRequest.name().isEmpty()) {
            throw new IllegalArgumentException("Character name cannot be null or empty");
        }

        if (characterRequest.characterType() == null) {
            throw new IllegalArgumentException("Character type cannot be null");
        }
        String characterTypeString = characterRequest.characterType();
        CharacterType characterType = CharacterType.valueOf(characterTypeString.toUpperCase());

        return new Character(
                characterRequest.name(),
                characterRequest.level(),
                characterType,
                characterType.getHealth(),
                characterType.getStamina(),
                characterType.getStrength()
        );
    }

    public static CharacterResponse toResponse(Character character) {
        return new CharacterResponse(
                character.getId(),
                character.getName(),
                character.getLevel(),
                character.getCharacterType().toString(),
                character.getHealth(),
                character.getStamina(),
                character.getStrength()
        );
    }
}