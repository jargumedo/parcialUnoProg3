package com.example.mutantes.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "dna")
public class Dna {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String dna;

    private boolean isMutant;

    public Dna(String[] dna, boolean isMutant) {
        this.dna = String.join(",", dna);
        this.isMutant = isMutant;
    }

    public String[] getSequence() {
        return dna.split(",");
    }

}
