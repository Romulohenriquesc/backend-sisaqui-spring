package api.dto.in;

import org.springframework.util.StringUtils;

import api.domain.Nursery;
import api.domain.Nursery.Type;
import lombok.Setter;

@Setter
public class NurseriesUpdateInDto {
	private String name;
	private Type type;
	
	public Nursery toNursery(Nursery nursery) {
		if(!StringUtils.isEmpty(name))
			nursery.setName(name);
		
		if(!StringUtils.isEmpty(type))
			nursery.setType(type);

		return nursery;
	}
}