package hello;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
        List<Pet> pets = jdbcTemplate.query(
            query, new PetRowMapper());
          return pets;
    }

    // POST route
    @RequestMapping("postPets")
    public void postAllPets(){
        String query = "INSERT INTO pets (name,breed,color) VALUES ('Chelsea','dog','black')";
        jdbcTemplate.query(query, new PetRowMapper());
    }

    // PUT route
    @RequestMapping("putPets")
    public void putAllPets(){
        String query = "UPDATE pets SET name='Barney' WHERE id=2";
        jdbcTemplate.query(query, new PetRowMapper());
    }
}
