package api.resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import api.dto.in.NurseriesCreateInDto;
import api.dto.in.NurseriesUpdateInDto;
import api.dto.out.NurseriesDefaultOutDto;
import api.userstories.NurseriesCreateUs;
import api.userstories.NurseriesDeleteUs;
import api.userstories.NurseriesDetailsUs;
import api.userstories.NurseriesListAllUs;
import api.userstories.NurseriesUpdateUs;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("nurseries")
public class NurseriesResource {
	
	private final NurseriesCreateUs nurseriesCreateUs;
	private final NurseriesListAllUs nurseriesListAllUs;
	private final NurseriesDeleteUs nurseriesDeleteUs;
	private final NurseriesDetailsUs nurseriesDetailsUs;
	private final NurseriesUpdateUs nurseriesUpdateUs;
	
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Mono<NurseriesDefaultOutDto> post(@RequestBody final NurseriesCreateInDto createInDto){
		return nurseriesCreateUs
				.execute(createInDto)
				.map(NurseriesDefaultOutDto::fromNursery);
	}
	
	
	@GetMapping
	public Flux<NurseriesDefaultOutDto> get(){
		return nurseriesListAllUs
				.execute()
				.map(NurseriesDefaultOutDto::fromNursery);
	}
	
	@GetMapping("{id}")
	public Mono<NurseriesDefaultOutDto> getOneNursery(@PathVariable final String id){
		return nurseriesDetailsUs
				.execute(id)
				.map(NurseriesDefaultOutDto::fromNursery);
	}
	
	@PatchMapping("{id}")
	public Mono<NurseriesDefaultOutDto> patch(@PathVariable final String id, @RequestBody final NurseriesUpdateInDto dto){
		return nurseriesUpdateUs
				.execute(id, dto)
				.map(NurseriesDefaultOutDto::fromNursery);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public Mono<Void> delete(@PathVariable final String id){
		return nurseriesDeleteUs.execute(id);
	}
}
