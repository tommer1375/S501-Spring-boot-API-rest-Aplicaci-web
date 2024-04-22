package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n03.model.repository;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebFlowersRepository {

    @Bean
    public WebClient webClient(){
        return WebClient.builder().baseUrl("http://localhost:9001").build();
    }
}