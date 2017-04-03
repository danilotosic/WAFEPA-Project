package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Nekretnina;
import jwd.wafepa.web.dto.NekretninaDTO;

@Component
public class NekretninaToNekretninaDTO implements Converter<Nekretnina, NekretninaDTO> {

	TipNekretnineToTipNekretnineWN toTipWN = new TipNekretnineToTipNekretnineWN();

	@Override
	public NekretninaDTO convert(Nekretnina nekretnina) {
		if (nekretnina == null) {
			return null;
		}

		NekretninaDTO dto = new NekretninaDTO();

		dto.setAdresa(nekretnina.getAdresa());
		dto.setCena(nekretnina.getCena());
		dto.setNekretninaID(nekretnina.getNekretninaID());
		dto.setTipNekretnine(toTipWN.convert(nekretnina.getTipNekretnine()));

		return dto;
	}

	public List<NekretninaDTO> convert(List<Nekretnina> nekretnine) {
		if (nekretnine == null) {
			return null;
		}

		List<NekretninaDTO> dtos = new ArrayList<>();

		for (Nekretnina n : nekretnine) {
			dtos.add(convert(n));
		}

		return dtos;
	}

}
