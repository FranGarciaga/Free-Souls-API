package com.example.FreeSoulsApi.services;

import com.example.FreeSoulsApi.dtos.WeaponRequest;
import com.example.FreeSoulsApi.dtos.WeaponResponse;
import com.example.FreeSoulsApi.entities.Character;
import com.example.FreeSoulsApi.entities.Weapon;
import com.example.FreeSoulsApi.exeptions.NoRegistersFoundException;
import com.example.FreeSoulsApi.mappers.WeaponMapper;
import com.example.FreeSoulsApi.repositories.WeaponsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WeaponsService {
    private WeaponsRepository weaponsRepository;
    private CharacterService characterService;

    public WeaponsService(WeaponsRepository weaponsRepository, CharacterService characterRepository) {
        this.weaponsRepository = weaponsRepository;
        this.characterService = characterRepository;
    }

    public WeaponResponse createWeapon(WeaponRequest weaponRequest) {
        Character character = characterService.findCharacterEntityById(weaponRequest.characterId());
        Weapon weapon = WeaponMapper.fromRequest(weaponRequest, character);
        Weapon savedWeapon =weaponsRepository.save(weapon);
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
}
