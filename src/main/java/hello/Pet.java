package hello;

public class Pet {

  private int id;
  private String name;
  private String type;

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

 

  public Pet() {}

  public Pet(int id, String name, String type) {
    this.id = id;
    this.name = name;
    this.type = type;

  }
  
  
}