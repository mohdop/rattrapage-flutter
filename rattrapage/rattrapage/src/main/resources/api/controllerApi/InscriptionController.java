package com.rattrapage.api.controllerApi;
import com.rattrapage.api.dto.*;
import com.rattrapage.repositories.*;
import api.dto.EtudiantDto;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;


@RestController
@RequestMapping("/api/inscription")
@CrossOrigin(origins = "http://localhost:3000")

public class InscriptionController {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @GetMapping
    public ResponseEntity<List<EtudiantDto>> getAllInscriptions() {
        List<EtudiantDto> etudiants = etudiantRepository.findAll();
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

    @GetMapping(params = "classe")
    public ResponseEntity<List<EtudiantDto>> getEtudiantsByClasse(@RequestParam("classe") String classe) {
        List<EtudiantDto> etudiants = etudiantRepository.findByClasse(classe);
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }


 
}
