package jwd.wafepa.web.dto;

import java.util.List;

public class TipNekretnineDTO {

	private Long tipID;
	private String naziv;
	private List<NekretninaWTip> nekretnine;

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

	public List<NekretninaWTip> getNekretnine() {
		return nekretnine;
	}

	public void setNekretnine(List<NekretninaWTip> nekretnine) {
		this.nekretnine = nekretnine;
	}

}
