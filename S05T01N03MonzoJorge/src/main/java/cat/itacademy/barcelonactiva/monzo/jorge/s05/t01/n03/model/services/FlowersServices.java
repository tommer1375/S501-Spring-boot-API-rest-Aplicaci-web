package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n03.model.services;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n03.model.dto.FlowersDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n03.model.domain.Flowers;

import java.util.*;


public interface FlowersServices {

    FlowersDTO addFlowers(Flowers flowers);

    FlowersDTO updateFlowers(Flowers flowers);

    void deleteFlowers(Integer id);

    Flowers getOneFlowers(Integer id);

    List<FlowersDTO> getAllFlowers();
}