package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.TipNekretnine;
import jwd.wafepa.web.dto.TipNekretnineWN;

@Component
public class TipNekretnineToTipNekretnineWN implements Converter<TipNekretnine, TipNekretnineWN> {

	@Override
	public TipNekretnineWN convert(TipNekretnine tipNekretnine) {
		if (tipNekretnine == null) {
			return null;
		}

		TipNekretnineWN tipWN = new TipNekretnineWN();

		tipWN.setTipID(tipNekretnine.getTipID());
		tipWN.setNaziv(tipNekretnine.getNaziv());

		return tipWN;
	}

	public List<TipNekretnineWN> convert(List<TipNekretnine> tipoviNekretnina) {
		if (tipoviNekretnina == null) {
			return null;
		}

		List<TipNekretnineWN> tipoviWN = new ArrayList<>();

		for (TipNekretnine tipNekretnine : tipoviNekretnina) {
			tipoviWN.add(convert(tipNekretnine));
		}

		return tipoviWN;
	}

}
