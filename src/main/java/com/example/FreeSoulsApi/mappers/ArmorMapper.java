package com.example.FreeSoulsApi.mappers;

import com.example.FreeSoulsApi.dtos.ArmorRequest;
import com.example.FreeSoulsApi.dtos.ArmorResponse;
import com.example.FreeSoulsApi.entities.Armor;

public class ArmorMapper {
    public static Armor fromRequest(ArmorRequest armorRequest, Character character) {
        return new Armor(armorRequest.name(),armorRequest.defense(),armorRequest.weight(), character);
    }

    public static ArmorResponse toResponse(Armor armor) {
        return new ArmorResponse(
                armor.getId(),
                armor.getName(),
                armor.getDefense(),
                armor.getWeight(),
                CharacterMapper.toResponse(armor.getCharacter())
        );
    }
}
