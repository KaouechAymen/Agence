package de.tekup.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.projet.Entity.BienImmobiliare;

public interface BienRepo extends JpaRepository<BienImmobiliare , Integer> {

}
