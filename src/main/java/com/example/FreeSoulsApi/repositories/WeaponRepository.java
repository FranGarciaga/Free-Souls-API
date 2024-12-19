package com.example.FreeSoulsApi.repositories;

import com.example.FreeSoulsApi.entities.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {
}
