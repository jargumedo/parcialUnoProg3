package com.example.mutantes.servicios;

import com.example.mutantes.entidades.Dna;
import com.example.mutantes.entidades.Stats;
import com.example.mutantes.repositorios.DnaRepository;
import com.example.mutantes.repositorios.StatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DnaServiceImpl implements DnaService {
    private final DnaRepository dnaRepository;
    private final StatsRepository statsRepository;

    public Stats getStats() {
        // Buscar las estadísticas actuales en la base de datos
        Optional<Stats> statsOptional = statsRepository.findById(Long.valueOf(1L));

        // Si ya existen estadísticas guardadas, devolverlas sin recalcular
        if (statsOptional.isPresent()) {
            return statsOptional.get();
        }

        // Si no existen estadísticas guardadas, calcularlas por primera vez
        Stats stats = new Stats();

        List<Dna> dnaList = dnaRepository.findAll();
        int human = 0;
        int mutant = 0;

        // Calcular el número de humanos y mutantes
        for (Dna dna : dnaList) {
            if (isMutant(dna.getSequence())) {
                mutant += 1;
            } else {
                human += 1;
            }
        }

        // Calcular el ratio y evitar división por cero
        double ratio = human > 0 ? (double) mutant / human : 0.0;

        // Establecer los valores calculados en el objeto Stats
        stats.setHumans(human);
        stats.setMutants(mutant);
        stats.setRatio(ratio);

        // Guardar las estadísticas en la base de datos
        statsRepository.save(stats);

        // Devolver las estadísticas calculadas
        return stats;
    }

    public boolean isMutant(String[] dna) {


        boolean isMutant = testRows(dna) || testColumn(dna) || testPrincipalDiagonals(dna) || testInfDiagonal(dna) || testSupDiagonal(dna);


        Dna newDna = new Dna(dna, isMutant);
        dnaRepository.save(newDna);
        return isMutant;
    }

    public boolean validDna(String[] dna){
            for(String row : dna){
                if(!validRow(row,dna.length)){
                    return false;
                }
            }
            return true;
    }




    public boolean validRow(String fila, int n) {
        fila = fila.toLowerCase();
        int count = 0;
        String validString[] = fila.split("");
        for (int i = 0; i < fila.length(); i++) {
            if (!validString[i].equals("a") && !validString[i].equals("c") && !validString[i].equals("g") && !validString[i].equals("t")) {
                return false;
            } else {
                count++;
            }
        }
        if (count != n) {

            return false;
        }
        return true;
    }


    //Para validar necesitamos que se mueva dna[i] = Los string
    public static boolean testRows(String[] dna) {
        for (int i = 0; i < dna.length; i++) {
            String[] validateString = dna[i].split("");
            int count = 1;
            for (int j = 0; j < validateString.length - 1; j++) {

                if (validateString[j].equals(validateString[j + 1])) {
                    count++;
                    if (count == 4) {
                        return true;
                    }
                } else {
                    count = 1;
                }
            }
        }
        return false;
    }


    public static boolean testColumn(String[] dna) {
        String[] dnaColumn = new String[dna.length];
        for (int i = 0; i < dna.length; i++) {
            dnaColumn[i] = "";
            for (int j = 0; j < dna[i].length(); j++) {
                dnaColumn[i] = dnaColumn[i].concat(dna[j].substring(i, i + 1));
            }
        }
        return testRows(dnaColumn);
    }

    public static boolean testPrincipalDiagonals(String[] dna) {
        int position = 0;
        String[] dnaDiagonal = new String[2];
        for (int i = 0; i < dnaDiagonal.length; i++) {
            dnaDiagonal[i] = "";
            for (int k = 0; k < dna[i].length(); k++) {
                for (int j = 0; j < dna[i].length(); j++) {
                    if (k == j && i == 0) {
                        dnaDiagonal[0] = dnaDiagonal[0].concat(dna[k].substring(j, j + 1));
                        break;
                    } else if (k + j == dna.length - 1 && i == 1) {
                        dnaDiagonal[1] = dnaDiagonal[1].concat(dna[k].substring(j, j + 1));
                    }
                }

            }
        }
        return testRows(dnaDiagonal);

    }
    public static boolean testSupDiagonal(String[] dna) {
        int n = dna.length;

        String[] dnaDiagonalSup = new String[n-4];
        int index = 0;

        for (int i = 0; i < n - 1; i++) {
            String diagonal = "";
            for (int j = 0; j < n - i - 1; j++) {
                diagonal = diagonal.concat(dna[j].substring(j + i + 1, j + i + 2));
            }
            if (diagonal.length() >= 4) {
                dnaDiagonalSup[index] = diagonal;
                index++;
            }
        }
//        for (int i = 0; i < dnaDiagonalSup.length; i++) {
//            System.out.println("Diagonal " + (i + 1) + ": " + dnaDiagonalSup[i]);
//        }

        return testRows(dnaDiagonalSup);
    }

    public static boolean testInfDiagonal(String[] dna) {
        int n = dna.length;

        String[] dnaDiagonalInf = new String[n-4];
        int index = 0;

        for (int i = 1; i < n; i++) {
            String diagonal = "";
            for (int j = 0; j < n - i; j++) {
                diagonal = diagonal.concat(dna[j + i].substring(j, j + 1));
            }
            if (diagonal.length() >= 4) {
                dnaDiagonalInf[index] = diagonal;
                index++;
            }
        }

//        for (int i = 0; i < dnaDiagonalInf.length; i++) {
//            System.out.println("Diagonal " + (i + 1) + ": " + dnaDiagonalInf[i]);
//        }

        return testRows(dnaDiagonalInf);
    }

}
