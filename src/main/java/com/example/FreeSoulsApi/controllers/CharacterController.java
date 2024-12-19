package com.example.FreeSoulsApi.controllers;

import com.example.FreeSoulsApi.dtos.CharacterRequest;
import com.example.FreeSoulsApi.dtos.CharacterResponse;
import com.example.FreeSoulsApi.services.CharacterService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<CharacterResponse> getCharacter(@RequestParam(name = "name", required = false) String name) {

        if (name != null && !name.isEmpty()) {
            return characterService.searchByName(name);
        }
        List<CharacterResponse> characterList = characterService.getAllCharacter();
        return characterList;
    }
    
    @PostMapping
    public ResponseEntity<CharacterResponse> createCharacter(@Valid @RequestBody CharacterRequest characterRequest){

        CharacterResponse character = characterService.createCharacter(characterRequest);
        return new ResponseEntity<>(character, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public CharacterResponse getCharacterById (@PathVariable Long id){
        return characterService.findCharacterById(id);
    }
    
    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable Long id) {
        characterService.deleteById(id);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<CharacterResponse> updateCharacter(@PathVariable Long id, @RequestBody CharacterRequest characterRequest){
        CharacterResponse character = characterService.updateCharacter(id, characterRequest);
        return new ResponseEntity<>(character, HttpStatus.OK);
    }
}

