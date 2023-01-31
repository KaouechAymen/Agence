package de.tekup.projet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.projet.Entity.Agent;

public interface AgentRepo extends JpaRepository<Agent, Integer> {

}
