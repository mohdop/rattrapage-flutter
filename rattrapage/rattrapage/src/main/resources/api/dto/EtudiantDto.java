package com.rattrapage.api.dto;

import com.rattrapage.entities.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EtudiantDto {

    private Long id;
    private String nomComplet;
    private String adresseEmail;
    private String matricule;

    public EtudiantDto(Etudiant etudiant) {
        id = etudiant.getId();
        nomComplet = etudiant.getNomComplet();
        adresseEmail = etudiant.getAdresseEmail();
        matricule = etudiant.getMatricule();
    }
}


