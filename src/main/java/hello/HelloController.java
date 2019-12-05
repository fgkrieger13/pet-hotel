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

    @RequestMapping("/pets")
    public List<Pet> getAllPets() {
        String query = "SELECT * FROM pets";
        List<Pet> pets = jdbcTemplate.query(
            query, new PetRowMapper());
          return pets;
    }
     
    
    
















    
    @RequestMapping("/pet:")
    public List<Pet> deleteAPet() {
        String query = "DELETE FROM pets WHERE id = '7'";
        // String query2 = "DELETE FROM pets WHERE id = '2';";
        List<Pet> pets = jdbcTemplate.query(
            query, new PetRowMapper());
          return pets;
    }
    
}
