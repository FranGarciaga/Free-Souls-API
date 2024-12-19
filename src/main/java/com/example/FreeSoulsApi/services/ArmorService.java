package com.example.FreeSoulsApi.services;

import com.example.FreeSoulsApi.dtos.ArmorRequest;
import com.example.FreeSoulsApi.dtos.ArmorResponse;
import com.example.FreeSoulsApi.entities.Armor;
import com.example.FreeSoulsApi.entities.Character;
import com.example.FreeSoulsApi.exeptions.*;
import com.example.FreeSoulsApi.mappers.ArmorMapper;
import com.example.FreeSoulsApi.repositories.ArmorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ArmorService {
    private ArmorRepository armorsRepository;
    private CharacterService characterService;

    public ArmorService(ArmorRepository armorsRepository, CharacterService characterRepository) {
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

    public ArmorResponse findArmorById(Long id) {
        Optional<Armor> optionalArmor = armorsRepository.findById(id);

        if (optionalArmor.isEmpty()) {
            throw new NoRegistersFoundException(id);
        }
        return ArmorMapper.toResponse(optionalArmor.get());
    }

    public void deleteById(Long id) {
        Optional<Armor> optionalArmor = armorsRepository.findById(id);

        if (!optionalArmor.isPresent()) {
            throw new NoRegistersFoundException(id);
        }
        armorsRepository.deleteById(id);
    }

    public ArmorResponse updateArmor(Long id, ArmorRequest armorRequest) {
        Optional<Armor> armorToUpdate = armorsRepository.findById(id);

        if (armorToUpdate.isEmpty()) {
            throw new NoRegistersFoundException(id);
        }

        Armor armor = armorToUpdate.get();
        armor.setName(armorRequest.name());
        armor.setDefense(armorRequest.defense());
        armor.setWeight(armorRequest.weight());

        Armor updatedArmor = armorsRepository.save(armor);

        return ArmorMapper.toResponse(updatedArmor);
    }
}
