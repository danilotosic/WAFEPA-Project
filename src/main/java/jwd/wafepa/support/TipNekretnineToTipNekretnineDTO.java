package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.TipNekretnine;
import jwd.wafepa.web.dto.TipNekretnineDTO;

@Component
public class TipNekretnineToTipNekretnineDTO implements Converter<TipNekretnine, TipNekretnineDTO> {

	NekretninaToNekretninaWTip toNekretninaWT = new NekretninaToNekretninaWTip();

	@Override
	public TipNekretnineDTO convert(TipNekretnine tipNekretnine) {
		if (tipNekretnine == null) {
			return null;
		}

		TipNekretnineDTO dto = new TipNekretnineDTO();
		dto.setTipID(tipNekretnine.getTipID());
		dto.setNaziv(tipNekretnine.getNaziv());
		dto.setNekretnine(toNekretninaWT.convert(tipNekretnine.getNekretnine()));

		return dto;
	}

	public List<TipNekretnineDTO> convert(List<TipNekretnine> tipoviNekretina) {
		if (tipoviNekretina == null) {
			return null;
		}

		List<TipNekretnineDTO> dtos = new ArrayList<>();

		for (TipNekretnine tN : tipoviNekretina) {
			dtos.add(convert(tN));
		}

		return dtos;
	}

}
