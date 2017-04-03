package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Nekretnina;
import jwd.wafepa.web.dto.NekretninaWTip;

@Component
public class NekretninaToNekretninaWTip implements Converter<Nekretnina, NekretninaWTip> {

	@Override
	public NekretninaWTip convert(Nekretnina nekretnina) {
		if (nekretnina == null) {
			return null;
		}

		NekretninaWTip nekretninaWTip = new NekretninaWTip();

		nekretninaWTip.setNekretninaID(nekretnina.getNekretninaID());
		nekretninaWTip.setAdresa(nekretnina.getAdresa());
		nekretninaWTip.setCena(nekretnina.getCena());

		return nekretninaWTip;
	}

	public List<NekretninaWTip> convert(List<Nekretnina> nekretnine) {
		if (nekretnine == null) {
			return null;
		}

		List<NekretninaWTip> dtosWT = new ArrayList<>();

		for (Nekretnina n : nekretnine) {
			dtosWT.add(convert(n));
		}

		return dtosWT;
	}

}
