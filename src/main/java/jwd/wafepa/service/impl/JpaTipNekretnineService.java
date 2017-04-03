package jwd.wafepa.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.TipNekretnine;
import jwd.wafepa.repository.TipNekretnineRepository;
import jwd.wafepa.service.TipNekretnineService;

@Service
@Transactional
public class JpaTipNekretnineService implements TipNekretnineService {

	@Autowired
	private TipNekretnineRepository tipRepo;

	@Override
	public TipNekretnine findOne(Long tipNekretnineID) {
		return tipRepo.findOne(tipNekretnineID);
	}

	@Override
	public Page<TipNekretnine> findAll(Integer page) {
		return tipRepo.findAll(new PageRequest(page, 10));
	}

	@Override
	public TipNekretnine save(TipNekretnine tipNekretnine) {
		return tipRepo.save(tipNekretnine);
	}

	@Override
	public TipNekretnine delete(Long tipNekretnineID) {
		TipNekretnine retVal = tipRepo.findOne(tipNekretnineID);
		tipRepo.delete(tipNekretnineID);
		return retVal;
	}

}
