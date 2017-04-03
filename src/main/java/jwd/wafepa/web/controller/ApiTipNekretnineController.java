package jwd.wafepa.web.controller;

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

import jwd.wafepa.model.TipNekretnine;
import jwd.wafepa.service.TipNekretnineService;
import jwd.wafepa.support.TipNekretnineToTipNekretnineDTO;
import jwd.wafepa.web.dto.TipNekretnineDTO;

@RestController
@RequestMapping(value = "/api/tipnekretnine")
public class ApiTipNekretnineController {

	@Autowired
	private TipNekretnineService tipService;

	@Autowired
	private TipNekretnineToTipNekretnineDTO toDTO;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<TipNekretnineDTO>> getTips(@RequestParam(defaultValue = "0") Integer page) {

		Page<TipNekretnine> tipNekretnine = tipService.findAll(page);
		List<TipNekretnine> retVal = tipNekretnine.getContent();
		int totalPages = tipNekretnine.getTotalPages();

		HttpHeaders headers = new HttpHeaders();
		headers.add("totalpages", totalPages + "");

		if (retVal.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(retVal), headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TipNekretnineDTO> getTipNekrentine(@PathVariable Long id) {
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		TipNekretnine retVal = tipService.findOne(id);
		if (retVal == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(toDTO.convert(retVal), HttpStatus.OK);
	}

	@RequestMapping(consumes = "application/json", method = RequestMethod.POST)
	public ResponseEntity<TipNekretnineDTO> postTip(@RequestBody TipNekretnine tip) {
		if (tip == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		TipNekretnine retVal = tipService.save(tip);

		if (retVal == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(toDTO.convert(retVal), HttpStatus.OK);
	}

	@RequestMapping(consumes = "application/json", value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<TipNekretnineDTO> postTip(@RequestBody TipNekretnine tip, @PathVariable Long id) {
		if (tip == null || id == null || tip.getTipID() == null || !tip.getTipID().equals(id)) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		TipNekretnine retVal = tipService.save(tip);

		if (retVal == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(toDTO.convert(retVal), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TipNekretnineDTO> delete(@PathVariable Long id) {
		if (id == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		TipNekretnine retVal = tipService.delete(id);
		if (retVal == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(toDTO.convert(retVal), HttpStatus.OK);
	}

}
