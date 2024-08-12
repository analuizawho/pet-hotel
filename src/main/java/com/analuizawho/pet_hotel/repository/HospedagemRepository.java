package com.analuizawho.pet_hotel.repository;

import com.analuizawho.pet_hotel.entities.Hospedagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospedagemRepository extends JpaRepository<Hospedagem, Long> {

    List<Hospedagem> findAllByPetId(Long petId);
}
