package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n03.model.services;


import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n03.model.domain.Flowers;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n03.model.dto.FlowersDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n03.exceptions.*;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n03.model.repository.WebFlowersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class FlowersServiceImpl implements  FlowersServices{

    @Autowired
    private WebClient webClient;

    @Override
    public FlowersDTO addFlowers(Flowers flowers) {
        try {
            return webClient.post()
                    .uri("/flowers/add")
                    .bodyValue(flowers)
                    .retrieve()
                    .bodyToMono(FlowersDTO.class)
                    .block();
        }catch (Exception e) {
            throw new FlowerNotCreated();
        }
    }

    @Override
    public FlowersDTO updateFlowers(Flowers flowers) {
        try {
            return webClient.put()
                    .uri("/flowers/update")
                    .bodyValue(flowers)
                    .retrieve()
                    .bodyToMono(FlowersDTO.class)
                    .block();
        }catch (Exception e){
            throw new FlowerNotFoundException(flowers.getPk_FlowerID());
        }
    }

    @Override
    public void deleteFlowers(Integer flowerID) {
        try {
            webClient.delete()
                    .uri("/flowers/delete/{id}", flowerID)
                    .retrieve()
                    .toBodilessEntity()
                    .block();
        }catch (Exception e){
            throw new FlowerNotFoundException(flowerID);
        }
    }

    @Override
    public Flowers getOneFlowers(Integer flowerID) {
        try {
            return webClient.get()
                    .uri("/flowers/getOne/{id}", flowerID)
                    .retrieve()
                    .bodyToMono(Flowers.class)
                    .block();
        } catch (Exception e){
            throw new FlowerNotFoundException(flowerID);
        }
    }

    @Override
    public List<FlowersDTO> getAllFlowers() {
        try {
            return webClient.get()
                    .uri("/flowers/getAll")
                    .retrieve()
                    .bodyToFlux(FlowersDTO.class)
                    .collectList().block();
        }catch (Exception e){
            throw new FlowerNotGetAll();
        }
    }
}