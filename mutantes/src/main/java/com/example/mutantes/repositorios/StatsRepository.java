package com.example.mutantes.repositorios;

import com.example.mutantes.entidades.Stats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatsRepository extends JpaRepository<Stats, Long> {
}
