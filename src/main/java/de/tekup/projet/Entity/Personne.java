package de.tekup.projet.Entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;


import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public  abstract class Personne {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private LocalDate dob;
	private String mail;
	private String tel;
	private String type;
	
	@OneToMany (mappedBy = "personne")
	private List<BienImmobiliare> Bi;
	

}
