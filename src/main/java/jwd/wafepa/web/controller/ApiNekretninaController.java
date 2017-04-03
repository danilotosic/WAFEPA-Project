package jwd.wafepa.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.wafepa.model.Nekretnina;
import jwd.wafepa.service.NekretninaService;
import jwd.wafepa.support.NekretninaToNekretninaDTO;
import jwd.wafepa.web.dto.NekretninaDTO;

@RestController
@RequestMapping(value = "/api/nekretnine")
public class ApiNekretninaController {

	@Autowired
	private NekretninaService nekretninaService;

	@Autowired
	private NekretninaToNekretninaDTO toDTO;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<NekretninaDTO>> getNekretnine(
			@RequestParam(value = "page", required=false) Integer page,
			@RequestParam(value = "adresa", required = false) String adresa,
			@RequestParam(value = "min", required = false) Double min,
			@RequestParam(value = "max", required = false) Double max,
			@RequestParam(value = "cena", required = false) Double cena) {

		
		List<Nekretnina> retVal = new ArrayList<>();
		int totalPages = -1;
		
		if(page == null) {
			Iterable<Nekretnina> nekretnine = nekretninaService.findAll();
			for(Nekretnina n: nekretnine) {
				retVal.add(n);
			}
		} else {
		
			Page<Nekretnina> nekretnine;
	
			if (adresa != null) {
				nekretnine = nekretninaService.findByAdresa(adresa, page);
			} else if (cena != null && min != null && max != null) {
				nekretnine = nekretninaService.findByCena(min, max, cena, page);
			} else {
				nekretnine = nekretninaService.findAll(page);
			}
		
			retVal = nekretnine.getContent();
			totalPages = nekretnine.getTotalPages();
		}

		HttpHeaders headers = new HttpHeaders();
		
		if(totalPages >= 0) {
			headers.add("totalpages", totalPages + "");
		}

		if (retVal.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(toDTO.convert(retVal), headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<NekretninaDTO> getNekretnina(@PathVariable Long id) {

		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Nekretnina retVal = nekretninaService.findOne(id);
		if (retVal == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(retVal), HttpStatus.OK);
	}

	@RequestMapping(consumes = "application/json", method = RequestMethod.POST)
	public ResponseEntity<NekretninaDTO> postNekretnina(@RequestBody Nekretnina nekretnina) {
		if (nekretnina == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Nekretnina retVal = nekretninaService.save(nekretnina);
		if (retVal == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(toDTO.convert(retVal), HttpStatus.CREATED);
	}

	@RequestMapping(consumes = "application/json", value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<NekretninaDTO> putNekretnina(@RequestBody Nekretnina nekretnina, @PathVariable Long id) {
		if (nekretnina == null || id == null || nekretnina.getNekretninaID() == null
				|| !nekretnina.getNekretninaID().equals(id)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Nekretnina retVal = nekretninaService.save(nekretnina);

		return new ResponseEntity<>(toDTO.convert(retVal), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<NekretninaDTO> deleteNekretnina(@PathVariable Long id) {
		if(id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Nekretnina retVal = nekretninaService.delete(id);
		
		return new ResponseEntity<>(toDTO.convert(retVal), HttpStatus.OK);
	}

}
