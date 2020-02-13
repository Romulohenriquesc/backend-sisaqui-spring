package api.resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import api.dto.in.RationsCreateInDto;
import api.dto.out.RationsDefaultOutDto;
import api.userstories.RationsCreateUs;
import api.userstories.RationsDeleteUs;
import api.userstories.RationsListAllUs;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("rations")
public class RationsResource {
	private final RationsCreateUs rationsCreateUs;
	private final RationsDeleteUs rationsDeleteUs;
	private final RationsListAllUs rationsListAllUs;
	
		
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Mono<RationsDefaultOutDto> post(@RequestBody final RationsCreateInDto createInDto){
		return rationsCreateUs
				.execute(createInDto)
				.map(RationsDefaultOutDto::fromRation);
	}
	
	@GetMapping
	public Flux<RationsDefaultOutDto> get(){
		return rationsListAllUs
				.execute()
				.map(RationsDefaultOutDto::fromRation);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public Mono<Void> delete(@PathVariable final String id){
		return rationsDeleteUs.execute(id);
	}
	
}
