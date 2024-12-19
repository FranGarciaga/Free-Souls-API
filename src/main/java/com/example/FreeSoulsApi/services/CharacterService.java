package com.example.FreeSoulsApi.services;

import com.example.FreeSoulsApi.dtos.CharacterRequest;
import com.example.FreeSoulsApi.dtos.CharacterResponse;
import com.example.FreeSoulsApi.exeptions.GlobalExceptionHandler;
import com.example.FreeSoulsApi.exeptions.NoRegistersFoundException;
import com.example.FreeSoulsApi.mappers.CharacterMapper;
import com.example.FreeSoulsApi.repositories.CharacterRepository;
import org.springframework.stereotype.Service;
import com.example.FreeSoulsApi.entities.Character;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    private CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {

        this.characterRepository = characterRepository;
    }

    private void validateCharacter(String character) {
        if (character == null || character.trim().isEmpty()) {
            throw new IllegalArgumentException("character name cannot be empty or contain only spaces.");
        }
    }

    public CharacterResponse createCharacter(CharacterRequest characterRequest) {
        Character character = CharacterMapper.fromRequest(characterRequest);
        Character savedCharacter = characterRepository.save(character);
        return CharacterMapper.toResponse(savedCharacter);
    }

    public CharacterResponse findCharacterById(Long id) {

        Optional<Character> optionalCharacter = characterRepository.findById(id);

        if (optionalCharacter.isEmpty()){
            throw new NoRegistersFoundException(id);
        }

        return CharacterMapper.toResponse(optionalCharacter.get());
    }


    public List<CharacterResponse> getAllCharacter() {

        List<Character> characterList = characterRepository.findAll();
        return characterList.stream()
                .map(character -> CharacterMapper.toResponse(character)).toList();
    }

    public List<CharacterResponse> searchByName(String name) {

        List<Character> characterList = characterRepository.findLikeName(name);

        return characterList.stream()
                .map(character -> CharacterMapper.toResponse(character)).toList();
    }

    public void deleteById(Long id) {
        Optional<Character> optionalCharacter = characterRepository.findById(id);

        if (!optionalCharacter.isPresent()) {
            throw new NoRegistersFoundException(id);
        }

        Character character = optionalCharacter.get();
        if (!character.getArmors().isEmpty()) {
            throw new IllegalStateException("Cannot delete Character with Armors");
        }

        characterRepository.deleteById(id);
    }

    public CharacterResponse updateCharacter(Long id, CharacterRequest characterRequest) {
        Optional<Character> characterToUpdate = characterRepository.findById(id);

        if (characterToUpdate.isEmpty()) {
            throw new NoRegistersFoundException(id);
        }

        Character character = characterToUpdate.get();
        character.setName(characterRequest.name());
        character.setLevel(characterRequest.level());
        character.setCharacterType(characterRequest.characterType());
        character.setHealth(characterRequest.health());
        character.setStamina(characterRequest.stamina());
        character.setStrength(characterRequest.strength());

        Character updatedCharacter = characterRepository.save(character);

        return CharacterMapper.toResponse(updatedCharacter);
    }

    public Character findCharacterEntityById(Long id) {
        return characterRepository.findById(id)
                .orElseThrow(() -> new NoRegistersFoundException(id));
    }


    public long countCharacter() {
        return characterRepository.count();
    }
}
