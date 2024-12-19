package com.example.FreeSoulsApi.mappers;

import com.example.FreeSoulsApi.dtos.WeaponRequest;
import com.example.FreeSoulsApi.dtos.WeaponResponse;
import com.example.FreeSoulsApi.entities.Character;
import com.example.FreeSoulsApi.entities.Weapon;

public class WeaponMapper {
    public static Weapon fromRequest(WeaponRequest weaponRequest, Character character) {
        return new Weapon(weaponRequest.name(), weaponRequest.damage(),
                weaponRequest.weight(), weaponRequest.weaponType(), character);
    }

    public static WeaponResponse toResponse(Weapon weapon) {
        return new WeaponResponse(
                weapon.getId(),
                weapon.getName(),
                weapon.getDamage(),
                weapon.getWeight(),
                weapon.getWeaponType()

        );
    }
}
