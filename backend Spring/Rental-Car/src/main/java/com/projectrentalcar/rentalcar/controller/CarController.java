package com.projectrentalcar.rentalcar.controller;


import com.projectrentalcar.rentalcar.model.Car;
import com.projectrentalcar.rentalcar.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/car")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping
    public List<Car> getAllCar(){
        return carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id){
        return carRepository
                .findById(id)
                .orElseThrow(( )-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car saveCar(@RequestBody @Valid Car car){
        return carRepository.save(car);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        Optional<Car> findCar = carRepository.findById(id);
        if (!findCar.isPresent()){
            return new ResponseEntity<String>("Id não encontrado", HttpStatus.NOT_FOUND);
        }
        carRepository.deleteById(id);
        return new ResponseEntity<String>("Carro deletado com sucesso", HttpStatus.OK);
    }

    @PutMapping("/atualizar")
    @ResponseBody
    public ResponseEntity<?> updateCar(@RequestBody Car car){
        if (car.getId() == null){
            return new ResponseEntity<String>("id não encontrado", HttpStatus.NOT_FOUND);
        }
        Car newCar = carRepository.saveAndFlush(car);
        return new ResponseEntity<Car>(newCar, HttpStatus.OK);
    }
}
