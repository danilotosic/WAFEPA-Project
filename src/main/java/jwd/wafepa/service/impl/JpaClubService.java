package jwd.wafepa.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Club;
import jwd.wafepa.repository.ClubRepository;
import jwd.wafepa.service.ClubService;

@Service
@Transactional
public class JpaClubService implements ClubService {

	@Autowired
	private ClubRepository clubRepository;

	@Override
	public Club findOne(Long clubID) {
		return clubRepository.findOne(clubID);
	}

	@Override
	public Page<Club> findAll(Integer page) {
		return clubRepository.findAll(new PageRequest(page, 10));
	}

	@Override
	public Iterable<Club> findAll() {
		return clubRepository.findAll();
	}

	@Override
	public Club save(Club club) {
		return clubRepository.save(club);
	}

	@Override
	public Club delete(Long clubID) {
		Club retVal = clubRepository.findOne(clubID);
		clubRepository.delete(clubID);
		return retVal;
	}

	@Override
	public Page<Club> findByName(String name, Integer page) {
		return clubRepository.findByNameContains(name, new PageRequest(page, 10));
	}

}
