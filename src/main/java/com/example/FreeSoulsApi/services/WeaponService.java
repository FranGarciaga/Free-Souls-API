package com.example.FreeSoulsApi.services;

import com.example.FreeSoulsApi.dtos.CharacterRequest;
import com.example.FreeSoulsApi.dtos.CharacterResponse;
import com.example.FreeSoulsApi.dtos.WeaponRequest;
import com.example.FreeSoulsApi.dtos.WeaponResponse;
import com.example.FreeSoulsApi.entities.Character;
import com.example.FreeSoulsApi.entities.CharacterType;
import com.example.FreeSoulsApi.entities.Weapon;
import com.example.FreeSoulsApi.entities.WeaponType;
import com.example.FreeSoulsApi.exeptions.NoRegistersFoundException;
import com.example.FreeSoulsApi.mappers.CharacterMapper;
import com.example.FreeSoulsApi.mappers.WeaponMapper;
import com.example.FreeSoulsApi.repositories.WeaponRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeaponService {
    private WeaponRepository weaponsRepository;
    private CharacterService characterService;

    public WeaponService(WeaponRepository weaponsRepository, CharacterService characterRepository) {
        this.weaponsRepository = weaponsRepository;
        this.characterService = characterRepository;
    }

    public WeaponResponse createWeapon(WeaponRequest weaponRequest) {
        Character character = characterService.findCharacterEntityById(weaponRequest.characterId());
        Weapon weapon = WeaponMapper.fromRequest(weaponRequest, character);
        Weapon savedWeapon = weaponsRepository.save(weapon);
        return WeaponMapper.toResponse(savedWeapon);
    }

    public List<WeaponResponse> getAllWeapons() {
        List<Weapon> weaponList = weaponsRepository.findAll();
        return weaponList.stream().map(weapon -> WeaponMapper.toResponse(weapon)).toList();
    }

    public WeaponResponse findWeaponById(Long id) {
        Optional<Weapon> optionalWeapon = weaponsRepository.findById(id);

        if (optionalWeapon.isEmpty()) {
            throw new NoRegistersFoundException(id);
        }
        return WeaponMapper.toResponse(optionalWeapon.get());
    }

    public void deleteById(Long id) {
        Optional<Weapon> optionalWeapon = weaponsRepository.findById(id);

        if (!optionalWeapon.isPresent()) {
            throw new NoRegistersFoundException(id);
        }
        weaponsRepository.deleteById(id);
    }

    public WeaponResponse updateWeapon(Long id, WeaponRequest weaponRequest) {
        Optional<Weapon> weaponToUpdate = weaponsRepository.findById(id);

        if (weaponToUpdate.isEmpty()) {
            throw new NoRegistersFoundException(id);
        }

        Weapon weapon = weaponToUpdate.get();
        weapon.setName(weaponRequest.name());
        weapon.setDamage(weaponRequest.damage());
        weapon.setWeight(weaponRequest.weight());
        weapon.setWeaponType(WeaponType.valueOf(weaponRequest.weaponType()));

        Weapon updatedWeapon = weaponsRepository.save(weapon);

        return WeaponMapper.toResponse(updatedWeapon);
    }
}
