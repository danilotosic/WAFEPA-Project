package jwd.wafepa.service;

import org.springframework.data.domain.Page;

import jwd.wafepa.model.TipNekretnine;

public interface TipNekretnineService {

	TipNekretnine findOne(Long tipNekretnineID);

	Page<TipNekretnine> findAll(Integer page);

	TipNekretnine save(TipNekretnine tipNekretnine);

	TipNekretnine delete(Long tipNekretnineID);

}
