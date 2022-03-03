import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = Car.CarBuilder.class)
public class Car {

  private String col;
  private String typ;

  Car(String col, String typ) {
    this.col = col;
    this.typ = typ;
  }

  public static CarBuilder builder() {
    return new CarBuilder();
  }

  public String getCol() {
    return col;
  }

  public String getTyp() {
    return typ;
  }

  @Override
  public String toString() {
    return "Car{" +
        "col='" + col + '\'' +
        ", typ='" + typ + '\'' +
        '}';
  }

  @JsonPOJOBuilder(withPrefix = "")
  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class CarBuilder {
    private String colorValue;
    private String typeValue;

    public CarBuilder() {
    }

    public CarBuilder color(String color) {
      this.colorValue = color;
      return this;
    }

    public CarBuilder type(String type) {
      this.typeValue = type;
      return this;
    }

    public Car build() {
      return new Car(colorValue, typeValue);
    }

    @Override
    public String toString() {
      return "CarBuilder{" +
          "colorValue='" + colorValue + '\'' +
          ", typeValue='" + typeValue + '\'' +
          '}';
    }
  }
}


/*
@JsonDeserialize(builder=<Class_name>)
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonPOJOBuilder(withPrefix="")
 */