package de.tekup.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.projet.Entity.Proprietaire;



public interface ProprietaireRepo extends JpaRepository<Proprietaire, Integer> {

}
