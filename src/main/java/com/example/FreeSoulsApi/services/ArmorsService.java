package com.example.FreeSoulsApi.services;

import com.example.FreeSoulsApi.dtos.ArmorRequest;
import com.example.FreeSoulsApi.dtos.ArmorResponse;
import com.example.FreeSoulsApi.entities.Armor;
import com.example.FreeSoulsApi.entities.Character;
import com.example.FreeSoulsApi.mappers.ArmorMapper;
import com.example.FreeSoulsApi.repositories.ArmorsRepository;
import com.example.FreeSoulsApi.repositories.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArmorsService {
    private ArmorsRepository armorsRepository;
    private CharacterRepository characterRepository;

    public ArmorsService(ArmorsRepository armorsRepository, CharacterRepository characterRepository) {
        this.armorsRepository = armorsRepository;
        this.characterRepository = characterRepository;
    }

    public ArmorResponse createArmor(ArmorRequest armorRequest) {
        Character character = characterRepository.findChracterEntityById(armorRequest.characterId());
        Armor armor = ArmorMapper.fromRequest(armorRequest, character);
        Armor savedArmor =armorsRepository.save(armor);
        return ArmorMapper.toResponse(savedArmor);
    }

    public List<ArmorResponse> getAllArmors() {
    }

    public ArmorResponse findByIdArmor(int id) {
    }
}
