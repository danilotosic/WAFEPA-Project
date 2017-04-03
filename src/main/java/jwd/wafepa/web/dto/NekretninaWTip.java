package jwd.wafepa.web.dto;

public class NekretninaWTip {

	private Long nekretninaID;
	private double cena;
	private String adresa;

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

}
