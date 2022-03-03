import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
  public static void main(String[] args) throws JsonProcessingException {
    System.out.println("App start.");
    ObjectMapper objectMapper = new ObjectMapper();
    String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\", \"weight\": \"1000\"}";
    Car car = objectMapper.readValue(json, Car.class);
    System.out.println("Car: " + car);
  }
}

//, "weight": "1000"