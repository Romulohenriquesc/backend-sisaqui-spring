package api.dto.in;

import java.util.List;

import api.domain.Lot;
import lombok.Setter;

@Setter
public class LotsCreateInDto {
	private List<String> nurseries;
	private String name;
	
	public Lot toLot() {
		System.out.println(nurseries);
		return Lot
				.newLot()
				.setName(name)
				.setNurseries(nurseries);
	}

}
