package com.ensa.gi4.controller;

import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.service.api.GestionMaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class GestionMaterielController {

    private GestionMaterielService gestionMaterielService;

    public void listerMateriel() {
        gestionMaterielService.listerMateriel();
    }

    public void afficherMenu() throws InterruptedException {
        //guide for user(menu)
        System.out.println("1- pour lister le matériel, entrer 1");
        System.out.println("2- pour ajouter un nouveau matériel, entrer 2");
        System.out.println("3- pour modifié les informations d'une matériel , entrer 3 ");
        System.out.println("4- pour  supprimer une matériel , entrer 4 ");
        System.out.println("5- Pour chercher des informations surune matériel , entrer 5 ");
        System.out.println("0- pour sortir de l'application, entrer 0");
        System.out.println("0- pour louee une Materiel, entrer 6");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("0".equals(next)) {
            sortirDeLApplication();
        } else if ("1".equals(next)) {
            listerMateriel();
        } else if ("2".equals(next)) {
            // ajouter nouveau matériel
gestionMaterielService.addMaterial();
        } else if ("3".equals(next)) {
gestionMaterielService.upDate();
        } else if ("4".equals(next)) {
            gestionMaterielService.deletMaterial();
        } else if ("5".equals(next)) {
            gestionMaterielService.search();
        } else if ("6".equals(next)) {
            gestionMaterielService.location();
        }else {
            System.out.println("choix invalide");
        }
    }

    private void sortirDeLApplication() {
        System.exit(0);
    }
    @Autowired
    @Qualifier("service")
    public void setGestionMaterielService(GestionMaterielService gestionMaterielService) {
        // injection par accesseur
        this.gestionMaterielService = gestionMaterielService;
    }
}
