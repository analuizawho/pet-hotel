package com.analuizawho.pet_hotel.repository;

import com.analuizawho.pet_hotel.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findAllByAtivoTrue();
}
