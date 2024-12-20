package com.example.FreeSoulsApi.controllers;

import com.example.FreeSoulsApi.dtos.ArmorRequest;
import com.example.FreeSoulsApi.dtos.ArmorResponse;
import com.example.FreeSoulsApi.dtos.WeaponRequest;
import com.example.FreeSoulsApi.dtos.WeaponResponse;
import com.example.FreeSoulsApi.services.WeaponService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/weapons")
public class WeaponController {
    private final WeaponService weaponsService;
    public WeaponController(WeaponService weaponsService) {
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

    @DeleteMapping("/{id}")
    public void deleteWeapon(@PathVariable Long id) {
        weaponsService.deleteById(id);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<WeaponResponse> updateWeapon(@PathVariable Long id, @RequestBody WeaponRequest weaponRequest){
        WeaponResponse weapon = weaponsService.updateWeapon(id, weaponRequest);
        return new ResponseEntity<>(weapon, HttpStatus.OK);
    }
}
