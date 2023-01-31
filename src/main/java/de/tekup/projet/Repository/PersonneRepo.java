package de.tekup.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.projet.Entity.Personne;

public interface PersonneRepo extends JpaRepository<Personne, Integer>{

}
