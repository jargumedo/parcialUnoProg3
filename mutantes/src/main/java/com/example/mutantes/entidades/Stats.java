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
@Table(name = "stats")
public class Stats implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "count_mutant_dna")
    private Integer humans;

    @Column(name = "count_human_dna")
    private Integer mutants;
    private Double ratio;



}
