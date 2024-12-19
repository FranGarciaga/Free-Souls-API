package com.example.FreeSoulsApi.services;

import com.example.FreeSoulsApi.dtos.ArmorRequest;
import com.example.FreeSoulsApi.dtos.ArmorResponse;
import com.example.FreeSoulsApi.entities.Armor;
import com.example.FreeSoulsApi.entities.Character;
import com.example.FreeSoulsApi.exeptions.*;
import com.example.FreeSoulsApi.mappers.ArmorMapper;
import com.example.FreeSoulsApi.repositories.ArmorsRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ArmorsService {
    private ArmorsRepository armorsRepository;
    private CharacterService characterService;

    public ArmorsService(ArmorsRepository armorsRepository, CharacterService characterRepository) {
        this.armorsRepository = armorsRepository;
        this.characterService = characterRepository;
    }

    public ArmorResponse createArmor(ArmorRequest armorRequest) {
        Character character = characterService.findCharacterEntityById(armorRequest.characterId());
        Armor armor = ArmorMapper.fromRequest(armorRequest, character);
        Armor savedArmor =armorsRepository.save(armor);
        return ArmorMapper.toResponse(savedArmor);
    }

    public List<ArmorResponse> getAllArmors() {
        List<Armor> armorList = armorsRepository.findAll();
        return armorList.stream().map(armor -> ArmorMapper.toResponse(armor)).toList();
    }

    public ArmorResponse findByIdArmor(Long id) {
        Optional<Armor> optionalArmor = armorsRepository.findById(id);

        if (optionalArmor.isEmpty()) {
            throw new NoRegistersFoundException(id);
        }
        return ArmorMapper.toResponse(optionalArmor.get());
    }
}
