package com.projectrentalcar.rentalcar.controller;

import com.projectrentalcar.rentalcar.model.Client;
//import com.projectrentalcar.rentalcar.model.ClientAdress;
//import com.projectrentalcar.rentalcar.repository.ClientAdressRepository;
import com.projectrentalcar.rentalcar.repository.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/client")
@RestController
public class ClientController {

    private final ClientRepository clientRepository;
//    private final ClientAdressRepository clientAdressRepository;


    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client clientSave(@RequestBody @Valid Client client){
        return clientRepository.save(client);
    }

    @GetMapping
    public List<Client> getAll(){
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id){
        return clientRepository
                .findById(id)
                .orElseThrow(( )-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        clientRepository.deleteById(id);
        return new ResponseEntity<String>("Cliente deletado com sucesso", HttpStatus.OK);
    }

    @PutMapping("/atualizar")
    @ResponseBody
    public ResponseEntity<?> updateClient(@RequestBody Client client){
        if (client.getId() == null){
            return new ResponseEntity<String>("id não encontrado", HttpStatus.NOT_FOUND);
        }
        Client newClient = clientRepository.saveAndFlush(client);
        return new ResponseEntity<Client>(newClient, HttpStatus.OK);
    }
}
