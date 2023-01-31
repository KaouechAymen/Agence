package de.tekup.projet.DTO;

import lombok.Data;

@Data
public class BienDto {
	private int id;
	private String discription;
	private String etat;
	private Float prix;
	private String adress;
	private String type;

}
