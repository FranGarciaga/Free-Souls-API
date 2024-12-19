package com.example.FreeSoulsApi.controllers;

import com.example.FreeSoulsApi.dtos.ArmorRequest;
import com.example.FreeSoulsApi.dtos.ArmorResponse;
import com.example.FreeSoulsApi.services.ArmorsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/armors")
public class ArmorsController {
    private final ArmorsService armorsService;
    public ArmorsController(ArmorsService armorsService) {
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
        return armorsService.findByIdArmor(id);
    }
}
