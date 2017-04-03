package jwd.wafepa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Club;

@Repository
public interface ClubRepository extends PagingAndSortingRepository<Club, Long> {

	Page<Club> findByNameContains(String name, Pageable page);

}
