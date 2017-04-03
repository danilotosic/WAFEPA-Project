package jwd.wafepa.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Nekretnina;
import jwd.wafepa.repository.NekretninaRepository;
import jwd.wafepa.service.NekretninaService;

@Service
@Transactional
public class JpaNekretninaService implements NekretninaService {

	@Autowired
	private NekretninaRepository nekretninaRepo;

	@Override
	public Nekretnina findOne(Long nekretninaID) {
		return nekretninaRepo.findOne(nekretninaID);
	}

	@Override
	public Page<Nekretnina> findAll(Integer page) {
		return nekretninaRepo.findAll(new PageRequest(page, 10));
	}

	@Override
	public Nekretnina save(Nekretnina nekretnina) {
		return nekretninaRepo.save(nekretnina);
	}

	@Override
	public Nekretnina delete(Long nekretninaID) {
		Nekretnina retVal = nekretninaRepo.findOne(nekretninaID);
		nekretninaRepo.delete(nekretninaID);
		return retVal;
	}

	@Override
	public Page<Nekretnina> findByAdresa(String adresa, Integer page) {
		return nekretninaRepo.findByAdresaContains(adresa, new PageRequest(page, 10));
	}

	@Override
	public Page<Nekretnina> findByCena(double min, double max, double cena, Integer page) {
		return nekretninaRepo.findByCenaBetween(min, max, cena, new PageRequest(page, 10));
	}

	@Override
	public Iterable<Nekretnina> findAll() {
		return nekretninaRepo.findAll();
	}

}
