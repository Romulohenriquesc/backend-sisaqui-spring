package api.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Document
@Getter
@Setter
@Accessors(chain = true)
public class Ration {
	
	@Id
	private String id;
	private String name;
	private String company;
	private String code;
	
	
	public static Ration newRation() {
		return new Ration();
	}
}
