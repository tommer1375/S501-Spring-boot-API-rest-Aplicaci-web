package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n02.model.domain.Flowers;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n02.model.dto.FlowersDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n02.model.repository.FlowersRepository;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n02.exceptions.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowersServicesImpl implements FlowersServices {

    @Autowired
    private FlowersRepository flowersRepository;

    @Override
    public FlowersDTO addFlowers(FlowersDTO flowersDTO) {
        try {
            return convertToDTO(flowersRepository.save(flowersDTO));
        } catch (Exception ex) {
            throw new FlowersNotCreated();
        }
    }

    @Override
    public FlowersDTO updateFlowers(Flowers flowers){
        try {
            Optional<Flowers> flowersdb = flowersRepository.findById(flowers.getPk_FlowerID());
            Flowers flowersUpdate = flowersdb.get();
            flowersUpdate.setPk_FlowerID(flowers.getPk_FlowerID());
            flowersUpdate.setFlowerName(flowers.getFlowerName());
            flowersUpdate.setFlowerCountry(flowers.getFlowerCountry());
            return convertToDTO(flowersRepository.save(flowersUpdate));
        }catch (Exception e) {
            throw new FlowerNotFoundException(flowers.getPk_FlowerID());
        }
    }

    @Override
     public FlowersDTO getOneFlowersDTO(Integer flowersID){
         try {
             Optional<Flowers> flowers = flowersRepository.findById(flowersID);
             return convertToDTO(flowers.get());
         }catch (Exception e){
             throw new FlowerNotFoundException(flowersID);
         }
     }

     @Override
     public Flowers getOneFlowers(Integer flowersID){
         try {
             Optional<Flowers> flowers = flowersRepository.findById(flowersID);
             return flowers.get();
         } catch (Exception e){
             throw new FlowerNotFoundException(flowersID);
         }
     }

    @Override
    public void deleteFlowers(Integer flowersID){
        Optional<Flowers> flowers = flowersRepository.findById(flowersID);
        if (flowers.isEmpty()){throw new FlowerNotFoundException(flowersID);}
        flowersRepository.deleteById(flowersID);
    }

    @Override
    public List<FlowersDTO> getAllFlowers() {
        {
            List<Flowers> flowersList = flowersRepository.findAll();
            if (flowersList.isEmpty()) {
                throw new FlowerNotGetAll();
            }
            flowersList.forEach(flower -> {
                if (flower.allNull())
                    throw new FlowerIsNull();
            });
            return flowersList.stream().map(flowers -> convertToDTO(flowers)).collect(Collectors.toList());
        }

    }

    private FlowersDTO convertToDTO (Flowers flowers){
        return new FlowersDTO(flowers.getPk_FlowerID(), flowers.getFlowerName(),flowers.getFlowerCountry());
    }
}

