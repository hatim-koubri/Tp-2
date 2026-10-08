package com.demo.service;



import com.demo.dao.SalleDao;
import com.demo.model.Salle;
import com.demo.model.Utilisateur;
import com.demo.dao.UtilisateurDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ServiceGestion {

    private EntityManagerFactory emf;
    private EntityManager em;
    private SalleDao salleDao;
    private UtilisateurDao utilisateurDao;

    public ServiceGestion() {
        emf = Persistence.createEntityManagerFactory("gestionPU");
        em = emf.createEntityManager();
        salleDao = new SalleDao(em);
        utilisateurDao = new UtilisateurDao(em);
    }

    public void fermer() {
        em.close();
        emf.close();
    }

    public void ajouterSalle(Salle salle) {
        salleDao.create(salle);
    }

    public void ajouterUtilisateur(Utilisateur utilisateur) {
        utilisateurDao.create(utilisateur);
    }

    public List<Salle> listerSalles() {
        return salleDao.findAll();
    }

    public List<Utilisateur> listerUtilisateurs() {
        return utilisateurDao.findAll();
    }

    public List<Utilisateur> utilisateursParSalle(String nomSalle) {
        return utilisateurDao.findBySalleNom(nomSalle);
    }

    public List<Utilisateur> utilisateursDontNomContient(String texte) {
        return utilisateurDao.findByNomContenant(texte);
    }
}