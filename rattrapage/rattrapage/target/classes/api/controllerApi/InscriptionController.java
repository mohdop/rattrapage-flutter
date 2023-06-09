package api.controllerApi;

import com.rattrapage.api.dto.*;
import com.rattrapage.entities.*;
import com.rattrapage.repositories.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/inscription")
@CrossOrigin(origins = "http://localhost:3000")

public class InscriptionController {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllInscriptions() {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }

    @GetMapping(params = "classe")
    public ResponseEntity<List<Etudiant>> getEtudiantsByClasse(@RequestParam("classe") Classe classe) {
        List<Etudiant> etudiants = etudiantRepository.findByClasse(classe);
        return new ResponseEntity<>(etudiants, HttpStatus.OK);
    }


 
}
