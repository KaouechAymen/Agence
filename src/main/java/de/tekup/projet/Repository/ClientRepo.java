package de.tekup.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.projet.Entity.Client;


public interface ClientRepo extends JpaRepository<Client, Integer> {

}
