package jwd.wafepa;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Author;
import jwd.wafepa.model.Book;
import jwd.wafepa.model.Club;
import jwd.wafepa.model.Nekretnina;
import jwd.wafepa.model.Player;
import jwd.wafepa.model.TipNekretnine;
import jwd.wafepa.service.AuthorService;
import jwd.wafepa.service.BookService;
import jwd.wafepa.service.ClubService;
import jwd.wafepa.service.NekretninaService;
import jwd.wafepa.service.PlayerService;
import jwd.wafepa.service.TipNekretnineService;

@Component
public class TestData {

	@Autowired
	private AuthorService authorService;

	@Autowired
	private BookService bookService;

	@Autowired
	private ClubService clubService;

	@Autowired
	private PlayerService playerService;

	@Autowired
	private TipNekretnineService tipService;
	
	@Autowired
	private NekretninaService nekretninaService;
	
	@PostConstruct
	public void init() {
		// for (int i = 0; i < 20; i++) {
		// Author author = new Author("firstname_" + i, "lastname_" + i);
		// author = authorService.save(author);
		// for (int j = 0; j < 3; j++) {
		// Book book = new Book("naslov_" + j, "isbn_00" + j);
		// book.setAuthor(author);
		// bookService.save(book);
		// }
		// }

//		for (int i = 1; i <= 20; i++) {
//			Club club = new Club("klub_" + i);
//			Club saved = clubService.save(club);
//			for (int j = 1; j <= 12; j++) {
//				Player player = new Player("imeIgraca_" + j, "prezimeIgraca_" + j, club);
//				playerService.save(player);
//			}
//		}
		
		for (int i = 0; i < 20; i++) {
			TipNekretnine tip = new TipNekretnine("nazivNekretnine_" + i);
			TipNekretnine retVal = tipService.save(tip);
			for (int j = 0; j < 5; j++) {
				Nekretnina nekretnina = new Nekretnina(20.2 + j, "adresa_" + j);
				nekretnina.setTipNekretnine(retVal);
				nekretninaService.save(nekretnina);
			}
		}
		
	}

}
