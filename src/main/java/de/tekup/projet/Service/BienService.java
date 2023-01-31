package de.tekup.projet.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import de.tekup.projet.DTO.BienDto;
import de.tekup.projet.Entity.Appartement;
import de.tekup.projet.Entity.BienImmobiliare;
import de.tekup.projet.Entity.Maison;
import de.tekup.projet.Entity.Studio;
import de.tekup.projet.Entity.Terrain;
import de.tekup.projet.Repository.BienRepo;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BienService {
	private BienRepo Bienrepos;
	private ModelMapper mapper;
	
	public BienDto AddNewBien(BienDto newbien) {
		BienImmobiliare bien = null;
		switch (newbien.getType()) {
		case "terrain" : 
			bien = mapper.map(newbien, Terrain.class);
			break;
		case "studio" :
			bien = mapper.map(newbien, Studio.class);
			break;
		case "maison" :
			bien = mapper.map(newbien , Maison.class);
			break;

	
		case "appartement" :
			bien = mapper.map(newbien , Appartement.class);
			break;
		
		}
		System.out.println(bien);
		bien = Bienrepos.save(bien);
		System.out.println(bien);
		BienDto dtos = mapper.map(newbien, BienDto.class);
		dtos.setId(bien.getId());
		return dtos;
	}
	
	public List<BienDto> GetAllBien() {
		
		
		  return Bienrepos.findAll().stream().map((BienImmobiliare ent) ->{ BienDto dto
		  = mapper.map(ent, BienDto.class); return dto;
		  }).collect(Collectors.toList());
		 
		 
	
	}
	public BienDto GetBienById(int id) {
		
		  Optional<BienImmobiliare> bien = Bienrepos.findById(id);
		  bien.orElseThrow(() -> new NoSuchElementException("n'existe pas"));
		  BienDto dto = mapper.map(bien.get(), BienDto.class);
		  return dto;
		 
		
	}
	
	public BienDto UpdateDto(int id , BienDto newbien) {
		BienDto dto = GetBienById(id);
		BienImmobiliare bien = null;
		switch (dto.getType()) {
		case "terrain" : 
			bien = mapper.map(dto, Terrain.class);
			break;
		case "studio" :
			bien = mapper.map(dto, Studio.class);
			break;
		case "maison" :
			bien = mapper.map(dto , Maison.class);
			break;

	
		case "appartement" :
			bien = mapper.map(dto , Appartement.class);
			break;
		
		}
		
		if (newbien.getDiscription() != null)
			bien.setDiscription(newbien.getDiscription());
		
		if (newbien.getAdress() != null)
			bien.setAdress(newbien.getAdress());
		
		if (newbien.getEtat() != null)
			bien.setEtat(newbien.getEtat());
		
		if (newbien.getPrix() != null)
			bien.setPrix(newbien.getPrix());
		
		
		if (newbien.getEtat() != null)
			bien.setEtat(newbien.getEtat());
		if (newbien.getType() != null)
			bien.setType(newbien.getType());
		Bienrepos.save(bien);
		BienDto dtos = mapper.map(bien, BienDto.class);
		return dtos;
	}
	
	
	public BienDto DeletById(int id) {
		BienDto dto = GetBienById(id);
		BienImmobiliare bien = null;
		switch (dto.getType()) {
		case "terrain" : 
			bien = mapper.map(dto, Terrain.class);
			break;
		case "studio" :
			bien = mapper.map(dto, Studio.class);
			break;
		case "maison" :
			bien = mapper.map(dto , Maison.class);
			break;

	
		case "appartement" :
			bien = mapper.map(dto , Appartement.class);
			break;
		
		}
		Bienrepos.delete(bien);
		BienDto dtos = mapper.map(bien, BienDto.class);
		return dtos;
		
	}

}
