package com.example.FreeSoulsApi.controllers;

import com.example.FreeSoulsApi.dtos.ArmorRequest;
import com.example.FreeSoulsApi.dtos.ArmorResponse;
import com.example.FreeSoulsApi.dtos.CharacterRequest;
import com.example.FreeSoulsApi.dtos.CharacterResponse;
import com.example.FreeSoulsApi.services.ArmorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/armors")
public class ArmorController {
    private final ArmorService armorsService;
    public ArmorController(ArmorService armorsService) {
        this.armorsService = armorsService;

    }

@PostMapping
    public ResponseEntity<ArmorResponse> createArmor(@RequestBody ArmorRequest armorRequest) {
        ArmorResponse armor = armorsService.createArmor(armorRequest);
        return new ResponseEntity<>(armor, HttpStatus.CREATED);
    }

@GetMapping
    public List<ArmorResponse> showAllArmors() {
        return armorsService.getAllArmors();
    }
@GetMapping("/{id}")
    public ArmorResponse getArmorById(@PathVariable Long id){
        return armorsService.findArmorById(id);
    }
@DeleteMapping("/{id}")
    public void deleteArmor(@PathVariable Long id) {
        armorsService.deleteById(id);
    }

@PutMapping ("/{id}")
    public ResponseEntity<ArmorResponse> updateArmor(@PathVariable Long id, @RequestBody ArmorRequest armorRequest){
        ArmorResponse armor = armorsService.updateArmor(id, armorRequest);
        return new ResponseEntity<>(armor, HttpStatus.OK);
    }
}
