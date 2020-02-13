package api.dto.in;

import api.domain.Nursery;
import api.domain.Nursery.Type;
import lombok.Setter;

@Setter
public class NurseriesCreateInDto {
	private String name;
	private Type type;
	
	public Nursery toNursery() {
		return Nursery
				.newNursery()
				.setName(name)
				.setType(type);
	}
}