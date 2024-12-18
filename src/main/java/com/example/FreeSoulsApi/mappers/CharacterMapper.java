package com.example.FreeSoulsApi.mappers;

import com.example.FreeSoulsApi.dtos.CharacterRequest;
import com.example.FreeSoulsApi.dtos.CharacterResponse;
import com.example.FreeSoulsApi.entities.Character;

public class CharacterMapper {
    public static Character fromRequest(CharacterRequest characterRequest) {
        return new Character(characterRequest.name(), characterRequest.level(),
                characterRequest.characterType(), characterRequest.health(),
                characterRequest.stamina(),characterRequest.strength());
    }

    public static CharacterResponse toResponse(Character character) {
        return new CharacterResponse(
                character.getId(),
                character.getName(),
                character.getLevel(),
                character.getCharacterType(),
                character.getHealth(),
                character.getStamina(),
                character.getStrength()
        );
    }
}
