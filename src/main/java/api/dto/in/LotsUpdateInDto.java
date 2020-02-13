package api.dto.in;

import java.util.List;

import org.springframework.util.StringUtils;

import api.domain.Lot;
import lombok.Setter;

@Setter
public class LotsUpdateInDto {
	private String name;
	private List<String> nurseries;
	
	public Lot toLot(Lot lot) {
		if(!StringUtils.isEmpty(name))
			lot.setName(name);
		if(!StringUtils.isEmpty(nurseries))
			lot.setNurseries(nurseries);
		
		return lot;
	}
}
