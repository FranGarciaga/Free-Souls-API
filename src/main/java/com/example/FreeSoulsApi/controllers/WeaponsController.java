package com.example.FreeSoulsApi.controllers;

import com.example.FreeSoulsApi.dtos.WeaponRequest;
import com.example.FreeSoulsApi.dtos.WeaponResponse;
import com.example.FreeSoulsApi.services.WeaponsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/weapons")
public class WeaponsController {
    private final WeaponsService weaponsService;
    public WeaponsController(WeaponsService weaponsService) {
        this.weaponsService = weaponsService;

    }

    @PostMapping
    public ResponseEntity<WeaponResponse> createWeapon(@RequestBody WeaponRequest weaponRequest) {
        WeaponResponse weapon = weaponsService.createWeapon(weaponRequest);
        return new ResponseEntity<>(weapon, HttpStatus.CREATED);
    }

    @GetMapping
    public List<WeaponResponse> showAllWeapons() {
        return weaponsService.getAllWeapons();
    }
    @GetMapping("/{id}")
    public WeaponResponse getWeaponById(@PathVariable Long id){
        return weaponsService.findWeaponById(id);
    }
}
