package de.tekup.projet.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import de.tekup.projet.DTO.ReservationDTO;
import de.tekup.projet.Entity.Reservation;
import de.tekup.projet.Repository.ReservationRepository;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ReservationService {
	private ReservationRepository reservationRepos;
	private ModelMapper mapper;
	
	public ReservationDTO AddReservation(ReservationDTO newReservation) {
		Reservation res = mapper.map(newReservation, Reservation.class);
		reservationRepos.save(res);
		ReservationDTO resdto = mapper.map(res, ReservationDTO.class);
		resdto.setId(res.getId());
			return resdto ;
	}
	
	public List<ReservationDTO> GetALLReservation () {
		
		return reservationRepos.findAll().stream().map((Reservation ent) -> {ReservationDTO dto 
			= mapper.map(ent, ReservationDTO.class);return dto;
		}).collect(Collectors.toList());
		}
	
	
	}


