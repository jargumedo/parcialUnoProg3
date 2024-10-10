package com.example.mutantes.controladores;


import com.example.mutantes.dto.DnaDto;
import com.example.mutantes.servicios.DnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dna")
@RequiredArgsConstructor
public class DnaController {

    private final DnaService dnaService;

    @PostMapping("/test")
    public ResponseEntity<?> testDna(@RequestBody DnaDto dnaRequest){
        if(dnaService.validDna(dnaRequest.getDna())){
            boolean res = dnaService.isMutant(dnaRequest.getDna());
            if (res){
                return ResponseEntity.ok(res);
            }
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("No es un mutante");
        }
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Dna incorrecto");
    }

    @GetMapping("/stats")
    public ResponseEntity<?> stats(){
        return ResponseEntity.ok(dnaService.getStats());
    }
}
