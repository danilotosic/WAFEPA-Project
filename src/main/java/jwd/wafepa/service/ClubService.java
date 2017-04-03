package jwd.wafepa.service;

import org.springframework.data.domain.Page;

import jwd.wafepa.model.Club;

public interface ClubService {

	Club findOne(Long clubID);

	Page<Club> findAll(Integer page);

	Iterable<Club> findAll();

	Club save(Club club);

	Club delete(Long clubID);

	Page<Club> findByName(String name, Integer page);

}
