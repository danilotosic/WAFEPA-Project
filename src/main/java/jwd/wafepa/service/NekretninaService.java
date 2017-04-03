package jwd.wafepa.service;

import org.springframework.data.domain.Page;

import jwd.wafepa.model.Nekretnina;

public interface NekretninaService {

	Nekretnina findOne(Long nekretninaID);

	Page<Nekretnina> findAll(Integer page);

	Nekretnina save(Nekretnina nekretnina);

	Nekretnina delete(Long nekretninaID);

	Page<Nekretnina> findByAdresa(String adresa, Integer page);

	Page<Nekretnina> findByCena(double min, double max, double cena, Integer page);
	
	Iterable<Nekretnina> findAll();

}
