package jwd.wafepa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblNekretnina")
public class Nekretnina {

	@Id
	@GeneratedValue
	@Column(name = "nekretninaID")
	private Long nekretninaID;

	@Column(name = "cena")
	private double cena;
	@Column(name = "adresa")
	private String adresa;

	@ManyToOne(fetch = FetchType.LAZY)
	private TipNekretnine tipNekretnine;

	public Nekretnina() {
		super();
	}

	public Nekretnina(double cena, String adresa) {
		super();
		this.cena = cena;
		this.adresa = adresa;
	}

	public Nekretnina(double cena, String adresa, TipNekretnine tipNekretnine) {
		super();
		this.cena = cena;
		this.adresa = adresa;
		this.tipNekretnine = tipNekretnine;
	}

	public Nekretnina(Long nekretninaID, double cena, String adresa, TipNekretnine tipNekretnine) {
		super();
		this.nekretninaID = nekretninaID;
		this.cena = cena;
		this.adresa = adresa;
		this.tipNekretnine = tipNekretnine;
	}

	public Long getNekretninaID() {
		return nekretninaID;
	}

	public void setNekretninaID(Long nekretninaID) {
		this.nekretninaID = nekretninaID;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public TipNekretnine getTipNekretnine() {
		return tipNekretnine;
	}

	public void setTipNekretnine(TipNekretnine tipNekretnine) {
		this.tipNekretnine = tipNekretnine;
	}

}
