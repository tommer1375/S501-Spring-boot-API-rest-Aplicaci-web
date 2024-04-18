package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n02.controllers;

import io.swagger.v3.oas.annotations.Operation;
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
        @Operation(summary = "Add new Flower",
                description = "This method is used to add a new flower.")
        @PostMapping("/add")
        public ResponseEntity<?> addFlowers(@RequestBody Flowers flowers) {
            FlowersDTO savedFlowers = flowersService.addFlowers(flowers);

            return ResponseEntity.status(HttpStatus.CREATED).body(savedFlowers);
        }
        @Operation(summary = "Update a Flower",
                description = "This method is used to update a flower.")
        @PutMapping("/update")
        public ResponseEntity<?> updateFlowers(@RequestBody Flowers flowers){
            FlowersDTO flowerDTO = flowersService.updateFlowers(flowers);
            return new ResponseEntity<>(flowerDTO, HttpStatus.OK);
        }

        @Operation(summary = "Delete a Flower",
                  description = "This method is used to delete a flower.")
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteFlowers(@PathVariable("id") int id) {
            flowersService.deleteFlowers(id);

            return ResponseEntity.ok("Flower with id " + id + " deleted successfully");
        }
        @Operation(summary = "Get One Flower",
                 description = "This method is used to get one flower.")
        @GetMapping("/getOne/{id}")
        public ResponseEntity<?> getOneFlowers(@PathVariable("id") int id) {
            Flowers searchedFlowers = flowersService.getOneFlowers(id);

            return ResponseEntity.status(HttpStatus.OK).body(searchedFlowers);
        }
        @Operation(summary = "Get All Flowers",
                description = "This method is used to get all flowers.")
        @GetMapping("/getAll")
        public ResponseEntity<?> getAllFlowers() {
            List<FlowersDTO> searchedFlowers = flowersService.getAllFlowers();

            return ResponseEntity.status(HttpStatus.FOUND).body(searchedFlowers);

        }
    }
