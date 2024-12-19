package com.example.FreeSoulsApi.mappers;

import com.example.FreeSoulsApi.dtos.WeaponRequest;
import com.example.FreeSoulsApi.dtos.WeaponResponse;
import com.example.FreeSoulsApi.entities.Character;
import com.example.FreeSoulsApi.entities.Weapon;
import com.example.FreeSoulsApi.entities.WeaponType;

public class WeaponMapper {
    public static Weapon fromRequest(WeaponRequest weaponRequest, Character character) {

        if (weaponRequest.name() == null || weaponRequest.name().isEmpty()) {
            throw new IllegalArgumentException("Character name cannot be null or empty");
        }

        if (weaponRequest.weaponType() == null) {
            throw new IllegalArgumentException("Character type cannot be null");
        }
        String weaponTypeString = weaponRequest.weaponType();
        WeaponType weaponType = WeaponType.valueOf(weaponTypeString.toUpperCase());
        return new Weapon(weaponRequest.name(),
                weaponType.getDamage(),
                weaponType.getWeight(),
                weaponType, character);
    }

    public static WeaponResponse toResponse(Weapon weapon) {
        return new WeaponResponse(
                weapon.getId(),
                weapon.getName(),
                weapon.getDamage(),
                weapon.getWeight(),
                weapon.getWeaponType().toString()
        );
    }
}
