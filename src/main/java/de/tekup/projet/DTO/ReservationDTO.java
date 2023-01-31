package de.tekup.projet.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ReservationDTO {
	private int id;
	private LocalDate date;
	private String etat;

}
