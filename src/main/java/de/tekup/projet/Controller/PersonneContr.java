package de.tekup.projet.Controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.tekup.projet.DTO.PersonneDTO;

import de.tekup.projet.Service.PersonneSer;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PersonneContr {
	private PersonneSer perserv;
	
	
	@PostMapping("/api/Personne")
	public PersonneDTO saveDTO(@RequestBody PersonneDTO dto) {
		return perserv.AddPersonneTDO(dto);
		
	}
	
	@GetMapping("/api/GetAll")
	public List<PersonneDTO>  GetALL() {
		return perserv.GetALLPersonnes();
		
	}
	
	@GetMapping ("/api/GetById/{id}")
	public PersonneDTO GetPersonneById(@PathVariable("id")  int id) {
		return perserv.GetById(id);
	}
	
	@PutMapping("/api/Put/{id}")
	public PersonneDTO PutPersonne( @PathVariable("id")int id , @RequestBody PersonneDTO newPersonne) {
		return perserv.UpdateById(id, newPersonne);
	}
	
	@DeleteMapping("/api/DeleteById/{id}")
	public PersonneDTO DeletePersonneById(@PathVariable("id")  int id) {
		return perserv.DeletById(id);
	}

	
	
	
	
	
	
	
	
	
	
	 @ExceptionHandler(NoSuchElementException.class)
	  public ResponseEntity<String> handleNSEE(NoSuchElementException e){
		  return ResponseEntity.status(HttpStatus.NOT_FOUND)
				  .body("Error in search : "+e.getMessage());
	  }
	}


