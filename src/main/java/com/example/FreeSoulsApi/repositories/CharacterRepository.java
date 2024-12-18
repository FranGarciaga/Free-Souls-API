package com.example.FreeSoulsApi.repositories;

import com.example.FreeSoulsApi.entities.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
}
