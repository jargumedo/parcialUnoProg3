package com.example.mutantes.servicios;

import com.example.mutantes.entidades.Stats;

public interface DnaService {
    boolean isMutant(String[] dna);
    boolean validDna(String[] dna);

    Stats getStats();
}
