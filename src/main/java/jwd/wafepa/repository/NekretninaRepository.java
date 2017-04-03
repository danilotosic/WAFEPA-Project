package jwd.wafepa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import jwd.wafepa.model.Nekretnina;

@Repository
public interface NekretninaRepository extends PagingAndSortingRepository<Nekretnina, Long> {
	
	Page<Nekretnina> findByAdresaContains(String adresa, Pageable page);

	Page<Nekretnina> findByCenaBetween(double min, double max, double cena, Pageable page);

}
