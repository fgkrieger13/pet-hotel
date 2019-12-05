package hello;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import hello.Pet;

@RestController
public class HelloController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/pets")
    public List<Pet> getAllPets() {
        String query = "SELECT * FROM pets";
        List<Pet> pets = jdbcTemplate.query(
            query, new PetRowMapper());
          return pets;
    }
    @RequestMapping("/postPets/{name}/{type}/{color}")
    public int postAllPets(@PathVariable String name, @PathVariable String type, @PathVariable String color){ 
        String query = "INSERT INTO pets (name,breed,color) VALUES ('" + name + "','"+ type + "','"+ color +"')";
        jdbcTemplate.query(query, new PetRowMapper());
        return 200; // SHOULD return OK :(
    }
}
