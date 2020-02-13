package api.dto.out;

import api.domain.Ration;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RationsDefaultOutDto {
	private final String id;
	private final String name;
	private final String company;
	private final String code;
	
	public static RationsDefaultOutDto fromRation(final Ration ration) {
		return builder()
				.id(ration.getId())
				.name(ration.getName())
				.company(ration.getCompany())
				.code(ration.getCode())
				.build();
	}
}
