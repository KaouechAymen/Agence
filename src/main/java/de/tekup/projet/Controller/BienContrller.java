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

import de.tekup.projet.DTO.BienDto;
import de.tekup.projet.Service.BienService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BienContrller {
	private BienService bienser;
	
	@PostMapping ("api/add")
	public BienDto AddBien(@RequestBody BienDto newbien) {
		return bienser.AddNewBien(newbien);
	}
	
	@GetMapping ("api/GetAllBien")
	public List<BienDto> GetAllBien() {
		return bienser.GetAllBien();
	}
	
	@GetMapping("api/GetBienById/{id}")
	public BienDto GetBienById(@PathVariable("id") int id) {
		return bienser.GetBienById(id);
	}
	
	@PutMapping("api/PutBienById/{id}")
	public BienDto PutBien(@PathVariable ("id")int id , @RequestBody BienDto newbien) {
		return bienser.UpdateDto(id, newbien);
	}
	
	@DeleteMapping("api/DeleteBienById/{id}")
	private BienDto DeleteBien(@PathVariable("id") int id) {
		return bienser.DeletById(id);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	  public ResponseEntity<String> handleNSEE(NoSuchElementException e){
		  return ResponseEntity.status(HttpStatus.NOT_FOUND)
				  .body("Error in search : "+e.getMessage());
	  }
	}


