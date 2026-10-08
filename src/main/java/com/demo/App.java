package com.demo;

import com.demo.model.Salle;
import com.demo.model.Utilisateur;
import com.demo.service.ServiceGestion;

public class App {

    public static void main(String[] args) {
        ServiceGestion service = new ServiceGestion();

        try {
            Salle salle = new Salle("Salle Démo", 20);
            service.ajouterSalle(salle);

            Utilisateur utilisateur =
                    new Utilisateur("Amine", "amine.demo@example.com", salle);
            service.ajouterUtilisateur(utilisateur);

            System.out.println("Salles enregistrées :");
            service.listerSalles().forEach(System.out::println);

            System.out.println("\nUtilisateurs de Salle Démo :");
            service.utilisateursParSalle("Salle Démo")
                    .forEach(System.out::println);

        } finally {
            service.fermer();
        }
    }
}