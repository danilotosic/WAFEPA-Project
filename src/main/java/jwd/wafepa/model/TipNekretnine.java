package jwd.wafepa.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tblTipNekretnine")
public class TipNekretnine {

	@Id
	@GeneratedValue
	@Column(name = "tipID")
	private Long tipID;

	@Column(name = "naziv")
	private String naziv;

	@OneToMany(mappedBy = "tipNekretnine", cascade = CascadeType.REMOVE)
	private List<Nekretnina> nekretnine;

	public TipNekretnine() {
		super();
	}

	public TipNekretnine(String naziv) {
		super();
		this.naziv = naziv;
	}

	public TipNekretnine(String naziv, List<Nekretnina> nekretnine) {
		super();
		this.naziv = naziv;
		this.nekretnine = nekretnine;
	}

	public TipNekretnine(Long tipID, String naziv, List<Nekretnina> nekretnine) {
		super();
		this.tipID = tipID;
		this.naziv = naziv;
		this.nekretnine = nekretnine;
	}

	public Long getTipID() {
		return tipID;
	}

	public void setTipID(Long tipID) {
		this.tipID = tipID;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Nekretnina> getNekretnine() {
		return nekretnine;
	}

	public void setNekretnine(List<Nekretnina> nekretnine) {
		this.nekretnine = nekretnine;
	}

}
