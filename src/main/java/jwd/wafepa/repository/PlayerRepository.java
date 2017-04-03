package jwd.wafepa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Player;

@Repository
public interface PlayerRepository extends PagingAndSortingRepository<Player, Long> {
	
	Iterable<Player> findByClubClubID(Long clubID);

	Page<Player> findByFirstnameContains(String firstname, Pageable page);

	Page<Player> findByLastnameContains(String lastname, Pageable page);

	Page<Player> findByFirstnameContainsAndLastnameContains(String firstname, String lastname, Pageable page);

}
