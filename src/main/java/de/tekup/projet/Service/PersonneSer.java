package de.tekup.projet.Service;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import de.tekup.projet.DTO.PersonneDTO;
import de.tekup.projet.Entity.Agent;
import de.tekup.projet.Entity.Client;
import de.tekup.projet.Entity.Personne;
import de.tekup.projet.Entity.Proprietaire;
import de.tekup.projet.Repository.AgentRepo;
import de.tekup.projet.Repository.ClientRepo;
import de.tekup.projet.Repository.PersonneRepo;
import de.tekup.projet.Repository.ProprietaireRepo;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonneSer {
	
	private ModelMapper mapper;
	private ClientRepo clirep;
	private ProprietaireRepo propreo;
	private AgentRepo agentrep;
	private PersonneRepo personneRepo;
	
	
	//add personne
	public PersonneDTO AddPersonneTDO (PersonneDTO personneTdo) {
		Personne personne = null;
		switch (personneTdo.getType()) {
		case "client":
			personne = mapper.map(personneTdo, Client.class);
		break;
		
		case "Proprietaire":
			personne = mapper.map(personneTdo, Proprietaire.class);
			
			break;
		case "Agent":
			personne = mapper.map(personneTdo, Agent.class);
			
			break;
		}
		   personne = personneRepo.save(personne);
		   personneTdo.setId(personne.getId());
		
		return personneTdo ;
	}
	
	//getAll
	public List<PersonneDTO> GetALLPersonnes(){
		
		
		  return personneRepo.findAll().stream().map((Personne ent) ->{ PersonneDTO dto
		  = mapper.map(ent, PersonneDTO.class); return dto;
		  }).collect(Collectors.toList());
		 
	}
	
	
	
	//getById
	public PersonneDTO GetById(int id) {
		
		  Optional<Personne> personne = personneRepo.findById(id);
		  personne.orElseThrow(() -> new NoSuchElementException("n'existe pas"));
		  PersonneDTO dto = mapper.map(personne.get(), PersonneDTO.class); return dto;
		 
	}
	
	
	//UpdateById
	public PersonneDTO UpdateById(int id , PersonneDTO newPersonne) {
		PersonneDTO dto = GetById(id);
			Personne k=null;
				switch(dto.getType()) {
		case("client"):
			k = mapper.map(dto, Client.class);
		break;
		case("Proprietaire"):
			k = mapper.map(dto, Proprietaire.class);
		break;
		case("Agent"):
			k = mapper.map(dto, Agent.class);
		break;}
		System.out.println(k);
	if(newPersonne.getNom()!=null)
		k.setNom(newPersonne.getNom());
	    
	if(newPersonne.getPrenom()!=null)
		k.setPrenom(newPersonne.getPrenom());
	if(newPersonne.getMail()!=null)
		k.setMail(newPersonne.getMail());
	if(newPersonne.getTel()!=null)
		k.setTel(newPersonne.getTel());
	if(newPersonne.getDob()!=null)
		k.setDob(newPersonne.getDob());
	
	personneRepo.save(k);
	System.out.println(k);
	PersonneDTO dtos = mapper.map(k, PersonneDTO.class);
	System.out.println(k);
		//dtos.setType(newPersonne.getType());
	
	return dtos;
	}
	
	
	
	
	
	
	
	
	//DeleteByID
	public PersonneDTO DeletById(int id) {
		PersonneDTO dto = GetById(id);
		Personne k = null;
		switch(dto.getType()) {
		case("client"):
			k = mapper.map(dto, Client.class);
		break;
		case("Proprietaire"):
			k = mapper.map(dto, Proprietaire.class);
		break;
		case("Agent"):
			k = mapper.map(dto, Agent.class);
		break;}
		
		personneRepo.delete(k);
		return dto;
	}
}
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	


