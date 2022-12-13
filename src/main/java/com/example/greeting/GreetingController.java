package com.example.greeting;
import com.example.greeting.model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static java.lang.Integer.parseInt;

@RestController
@CrossOrigin(origins  =  "http://localhost:3000")
public class GreetingController {
    private ArrayList<Greeting> greetings = new ArrayList<>();

    //dependency injection
        //avoids needs to make new instance
    @Autowired
    GreetingRepository repository;

    @GetMapping("/greeting/{id}")
    public ResponseEntity <Optional<Greeting>> getGreetingById(@PathVariable String id)
    {
        // what made up my response
        // status code
        // body -- actual greeting
        // headers -- additional info re: request and response
        // vs. return.repository.findById(id); - does not allow to configure headers and body
        // below better for readability
        return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id));
//                .filter(greeting -> greeting.getId() == parseInt(id))
//                .findFirst()
//                .orElse(null);
    }


    @GetMapping("/greetings")
    public ResponseEntity<List<Greeting>> getAllGreetings() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @GetMapping("/random")
    public ResponseEntity<Greeting> getRandomGreeting() {
        // .count to find number of entries in repository
        ResponseEntity<List<Greeting>> allGreetings = getAllGreetings();
        //  same as making allGreetings = repository.findAll() -- if use this instead, would not
        // need the get body
        Random r = new Random();
        // int index = 1 + r.nextInt((int) (repository.count()));
        // return repository.findByid(index);
        Greeting randomGreeting = allGreetings.getBody().get(r.nextInt(allGreetings.getBody().size()));

        return ResponseEntity.status(HttpStatus.OK).body(randomGreeting);
    }

    @PostMapping("/greetings")
    public ResponseEntity <String> createGreeting(@RequestBody Greeting greeting) throws Exception {
        // set the greetings id based on the greetings list
        // set the created by
//        greeting.setId(greetings.size() + 1);
//        greeting.setCreatedBy("Ollie");
//        greeting.setDateCreated(new Timestamp(System.currentTimeMillis()));
        try {
            repository.save(greeting);

            return ResponseEntity.status(HttpStatus.CREATED).body("Greeting added" + greeting.getGreeting());
        } catch (Exception e) {
            throw new Exception(e.getMessage());

        }
    }
    // UPDATE route
    @PutMapping("/greetings/{id}")
    public String updateFullGreeting(@PathVariable int id, @RequestBody Greeting newGreeting){
        Greeting updatedGreeting = repository.findByid(id);
        updatedGreeting.setGreeting(newGreeting.getGreeting());
        updatedGreeting.setCreatedBy(newGreeting.getCreatedBy());
        updatedGreeting.setOriginCountry(newGreeting.getGreeting());
        return "Greeting with id: " + id + "changed to" + newGreeting;
    }

    // DELETE route
    @Transactional
    @DeleteMapping("/greetings/{id}")
    public String deleteGreeting(@PathVariable int id) {
//        greetings.remove(greetings.get(id));
        repository.delete(repository.findByid(id));
        return "Greeting with id: " + id + " deleted.";
    }
}
