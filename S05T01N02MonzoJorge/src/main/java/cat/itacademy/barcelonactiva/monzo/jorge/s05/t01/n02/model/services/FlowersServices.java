package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n02.model.dto.FlowersDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n02.model.domain.Flowers;

import java.util.*;


public interface FlowersServices {

    FlowersDTO addFlowers(FlowersDTO flowersDTO);

    FlowersDTO updateFlowers(Flowers flowers);

    void deleteFlowers(Integer id);

    FlowersDTO getOneFlowersDTO(Integer id);

    Flowers getOneFlowers(Integer id);

    List<FlowersDTO> getAllFlowers();
}