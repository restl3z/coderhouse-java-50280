package org.coderhouse.entrega04.controller;

import org.coderhouse.entrega04.model.ClientModel;
import org.coderhouse.entrega04.repository.ClientRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientRepository repo;

    @GetMapping("clients")
    public List<ClientModel> getClients(){
        return repo.findAll();
    }

    @PostMapping("clients")
    public String addUser(@RequestBody ClientModel client){
        repo.save(client);
        return "Client saved";
    }

    @GetMapping("clients/{id}")
    public ClientModel getClientByID(@PathVariable Long id){
        return repo.findById(id).get();
    }

    @GetMapping("clients/{id}/age")
    public int getClientAge(@PathVariable Long id){
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate found_client_birthday = LocalDate.parse(repo.findById(id).get().getBirthday(), df);

        int yearsPassed = LocalDate.now().getYear() - found_client_birthday.getYear();

        if (found_client_birthday.getDayOfYear() < LocalDate.now().getDayOfYear()){
            return yearsPassed;
        } else {
            return yearsPassed - 1;
        }
    }
}
