package com.example.greeting;

//import com.example.greeting.model.Greeting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



@SpringBootApplication
//@ComponentScan({"com.example.greeting.model"})

public class GreetingApplication {
//	private ArrayList<Greeting> greetings = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(GreetingApplication.class, args);
	}

	// extra to the controller
//	@GetMapping("/welcome")
//	public String sayHi() {
//		return "Welcome to the server side!!";
//	}

	// GET route
//	@GetMapping("/greetings/{id}")
//	public String getGreetingById(@PathVariable int id) {
//		return greetings.get(id);
//	}

	// INDEX route (GET ALL)
//	@GetMapping("/greetings")
//	public List<String> getGreetings() {
//		return greetings;
//	}

	// CREATE route
//	@PostMapping("/greetings")
//	public String createGreeting(@RequestBody Greeting greeting) {
//		// set greetings id based on the greetings list
//
//		greeting.setId( greetings.size()+1);
//		// set created by
//		greeting.setCreatedBy("Ollie");
//		// set the created at timestamp
//		greeting.setDateCreated(new Timestamp(System.currentTimeMillis()));
//		greetings.add(greeting);
//		return "Greeting added + " + greeting;
//	}

	// CHALLENGE (extra to the controller)
//	@GetMapping("/random")
//	public String getRandomGreeting() {
//		// example
//		// could be shortened
//		Random r = new Random();
//		String randomGreeting = greetings.get(r.nextInt(greetings.size()));
//
//		return randomGreeting;
//	}

	// UPDATE route
//	@PutMapping("/greetings/{id}")
//	public String updateGreeting(@PathVariable int id, @RequestBody Greeting greeting) {
//		// change the greeting with the new info
//		// set the greeting back into the list
//		greetings.set(id, greeting);
//		return "Greeting" + greeting.getId() + greeting.getCreatedBy() + greeting.getDateCreated();
//	}
//
//	// DELETE route
//	@DeleteMapping("/greetings/{id}")
//	public String deleteGreeting(@PathVariable int id) {
//		greetings.remove(greetings.stream().filter(greeting -> greeting.getId() == id).findFirst().get());
//		return "Greeting with id: " + id + " deleted.";
//	}

}