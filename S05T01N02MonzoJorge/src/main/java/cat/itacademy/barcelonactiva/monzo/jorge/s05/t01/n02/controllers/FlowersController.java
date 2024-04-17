package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n02.model.dto.FlowersDTO;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n02.model.domain.Flowers;
import cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n02.model.services.FlowersServices;

import java.util.*;

    @RestController
    @RequestMapping("/flowers")
    public class FlowersController {

        @Autowired
        FlowersServices flowersService;


        @PostMapping("/add")
        public ResponseEntity<?> addFlowers(@RequestBody Flowers flowers) {
            FlowersDTO savedFlowers = flowersService.addFlowers(flowers);

            return ResponseEntity.status(HttpStatus.CREATED).body(savedFlowers);
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<?> updateFlowers(@PathVariable("id") int id, @RequestBody Flowers flowers) {
            FlowersDTO modifiedFlowers = flowersService.updateFlowers(flowers);

            return ResponseEntity.status(HttpStatus.OK).body(modifiedFlowers);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteFlowers(@PathVariable("id") int id) {
            flowersService.deleteFlowers(id);

            return ResponseEntity.ok("Flower with id " + id + " deleted successfully");
        }

        @GetMapping("/getOne/{id}")
        public ResponseEntity<?> getOneFlowers(@PathVariable("id") int id) {
            Flowers searchedFlowers = flowersService.getOneFlowers(id);

            return ResponseEntity.status(HttpStatus.OK).body(searchedFlowers);
        }

        @GetMapping("/getAll")
        public ResponseEntity<?> getAllFlowers() {
            List<FlowersDTO> searchedFlowers = flowersService.getAllFlowers();

            return ResponseEntity.status(HttpStatus.FOUND).body(searchedFlowers);

        }
    }
