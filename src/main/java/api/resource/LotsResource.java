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

import api.dto.in.LotsCreateInDto;
import api.dto.in.LotsUpdateInDto;
import api.dto.out.LotsDefaultOutDto;
import api.userstories.LotsCreateUs;
import api.userstories.LotsDeleteUs;
import api.userstories.LotsListAllUs;
import api.userstories.LotsListOneUs;
import api.userstories.LotsUpdateUs;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("lots")
public class LotsResource {
	private final LotsCreateUs lotsCreateUs;
	private final LotsDeleteUs lotsDeleteUs;
	private final LotsListAllUs lotsListAllUs;
	private final LotsUpdateUs lotsUpdateUs;
	private final LotsListOneUs lotsListOneUs;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Mono<LotsDefaultOutDto> post(@RequestBody final LotsCreateInDto createInDto){
		return lotsCreateUs
				.execute(createInDto)
				.map(LotsDefaultOutDto::fromLot);
	}
	
	@GetMapping
	public Flux<LotsDefaultOutDto> get(){
		return lotsListAllUs
				.execute()
				.map(LotsDefaultOutDto::fromLot);
	}
	@GetMapping("{id}")
	public Mono<LotsDefaultOutDto> get(@PathVariable final String id){
		return lotsListOneUs
				.execute(id)
				.map(LotsDefaultOutDto::fromLot);
	}
	
	@PatchMapping("{id}")
	public Mono<LotsDefaultOutDto> patch(@PathVariable final String id, @RequestBody final LotsUpdateInDto dto){
		return lotsUpdateUs
				.execute(id, dto)
				.map(LotsDefaultOutDto::fromLot);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public Mono<Void> delete(@PathVariable final String id){
		return lotsDeleteUs.execute(id);
	}
	
	
}
