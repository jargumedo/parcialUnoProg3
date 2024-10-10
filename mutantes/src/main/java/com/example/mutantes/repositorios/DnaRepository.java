package com.example.mutantes.repositorios;

import com.example.mutantes.entidades.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DnaRepository extends JpaRepository<Dna, Long> {

}
