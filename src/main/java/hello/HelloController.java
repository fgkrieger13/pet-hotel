package hello;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    // GET route
    @RequestMapping("/pets")
    public List<Pet> getAllPets() {
        String query = "SELECT * FROM pets";
        List<Pet> pets = jdbcTemplate.query(query, new PetRowMapper());
          return pets;
    }
    @RequestMapping("/postPets/{name}/{breed}/{color}")
    public List<Pet> postAllPets(@PathVariable String name, @PathVariable String breed, @PathVariable String color){ 
        String query = "INSERT INTO pets (name, breed, color) VALUES ('" + name + "','"+ breed + "','"+ color +"') RETURNING *";
        List<Pet> pets = jdbcTemplate.query(query, new PetRowMapper());
        return pets; // SHOULD return OK :(

    // PUT route
    @RequestMapping("putPets")
    public void putAllPets(){
        String query = "UPDATE pets SET name='Barney' WHERE id=2";
        jdbcTemplate.query(query, new PetRowMapper());
    }
}
