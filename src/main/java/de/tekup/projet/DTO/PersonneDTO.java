package de.tekup.projet.DTO;



import java.time.LocalDate;

import lombok.Data;

@Data
public class PersonneDTO {
	
	private int id;
	private String nom;
	private String prenom;
	private LocalDate dob;
	private String mail;
	private String tel;
	private String type;


}
