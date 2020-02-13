package api.dto.in;

import api.domain.Ration;
import lombok.Setter;

@Setter
public class RationsCreateInDto {
	private String name;
	private String company;
	private String code;
	
	public Ration toRation() {
		return Ration
				.newRation()
				.setName(name)
				.setCompany(company)
				.setCode(code);
	}
}
