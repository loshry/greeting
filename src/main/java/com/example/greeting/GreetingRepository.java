package com.example.greeting;


import com.example.greeting.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
        // Repository
//              |
//          CRUD Repository
//              |
//          JpaRepository
// have access to all CRUD operations inherited

@Repository
public interface GreetingRepository extends JpaRepository<Greeting, String> {
    // have access to built in methods like save() for POST, findAll for GET
    // can also write custom methods (later)
    // Jpa will parse the names of these custom methods to
    // look for "find" "by" to make queries happen
    Greeting findByid(int id);

    Greeting deleteByid(int id);


    // find -- looking for something
            // By -- condition of what is being looked for
            // id -- variable


}
