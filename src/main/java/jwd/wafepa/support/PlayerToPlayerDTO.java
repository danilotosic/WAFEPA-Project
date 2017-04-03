package jwd.wafepa.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Player;
import jwd.wafepa.web.dto.PlayerDTO;

@Component
public class PlayerToPlayerDTO implements Converter<Player, PlayerDTO> {

	private ClubToClubWP toClubWP = new ClubToClubWP();

	@Override
	public PlayerDTO convert(Player player) {
		PlayerDTO dto = new PlayerDTO();

		dto.setPlayerID(player.getPlayerID());
		dto.setFirstname(player.getFirstname());
		dto.setLastname(player.getLastname());
		dto.setClub(toClubWP.convert(player.getClub()));

		return dto;
	}

	public List<PlayerDTO> convert(List<Player> players) {
		List<PlayerDTO> dtos = new ArrayList<>();

		for (Player p : players) {
			dtos.add(convert(p));
		}

		return dtos;
	}

}
