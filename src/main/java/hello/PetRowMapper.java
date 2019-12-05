package hello;

import hello.Pet;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PetRowMapper implements RowMapper<Pet> {
  @Override
  public Pet mapRow(ResultSet rs, int rowNum) throws SQLException {
      Pet pet = new Pet();

      pet.setId(rs.getInt("id"));
      pet.setName(rs.getString("name"));
      pet.setType(rs.getString("type"));
      //book.setPublished(rs.getString("published"));

      return pet;
  }
}