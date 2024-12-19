package com.example.FreeSoulsApi.repositories;

import com.example.FreeSoulsApi.entities.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface CharacterRepository extends JpaRepository<Character, Long> {
    @Query(value = "SELECT c FROM Character c WHERE c.name LIKE %:name%")
    List<Character> findLikeName(String name);
}
