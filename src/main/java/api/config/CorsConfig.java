package api.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {
	@Bean
	CorsWebFilter corsWebFilter() {
	    CorsConfiguration corsConfig = new CorsConfiguration();
	    corsConfig.setAllowedOrigins(Arrays.asList("*"));
	    corsConfig.setMaxAge(8000L);
	    corsConfig.addAllowedMethod("GET");
	    corsConfig.addAllowedMethod("POST");
	    corsConfig.addAllowedMethod("PATCH");
	    corsConfig.addAllowedMethod("DELETE");
	    corsConfig.addAllowedHeader("*");
	    corsConfig.setAllowCredentials(true);
	 
	    UrlBasedCorsConfigurationSource source =
	      new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", corsConfig);
	 
	    return new CorsWebFilter(source);
	}
}