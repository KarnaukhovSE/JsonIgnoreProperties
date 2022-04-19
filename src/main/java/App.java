import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class App {

  public static List arrayToList(int[] array) {
    for(int i=0; i<array.length; i++) {
      System.out.println(array[i]);
    }
    //System.out.println(array.toString());
    List<Integer> sortedList01 = new ArrayList<Integer>();
    for(int i=0; i<array.length; i++) {
      sortedList01.add(array[i]);
    }
    System.out.println(sortedList01);
    System.out.println(sortedList01.stream().sorted().collect(toList()));
    System.out.println(sortedList01.stream().sorted().collect(toList()).get(sortedList01.get(sortedList01.size()-1)));
    System.out.println(sortedList01.stream().sorted().collect(toList()).get(sortedList01.get(sortedList01.size()-1)));
    //System.out.println(new TreeSet<Integer>(sortedList01.stream().collect(Collectors.toSet())));
    List<Integer> sortedList02 = Arrays.stream(array).boxed().sorted().collect(toList());
    System.out.println(sortedList02);
    //Arrays.stream(numbersArray).map(i -> sortedList02.add(i));
    //List<Integer> sortedList03 = (List<Integer>) Arrays.stream(numbersArray).collect(toList());
    //System.out.println(sortedList02);
    return sortedList02;
  }

  public static void changeIteratedList() {
    //java.util.ConcurrentModificationException
    //CopyOnWriteArrayList
    List<String> stringList = new ArrayList<>();
    stringList.add("one");
    stringList.add("one and a half");
    stringList.add("two");
    stringList.add("two and a half");
    stringList.add("three and a half");

    System.out.println("Before " + stringList);
    Iterator<String> stringIterator = stringList.iterator();
    while (stringIterator.hasNext()) {
      String next = stringIterator.next();
      if (next.equals("two and a half")) {
        stringList.add("three");
      }
    }

    System.out.println("After " + stringList);
  }

  public static void main(String[] args) throws JsonProcessingException {
    System.out.println("App start.");
    ObjectMapper objectMapper = new ObjectMapper();
    String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\", \"weight\": \"1000\"}";
    Car car = objectMapper.readValue(json, Car.class);
    System.out.println("Car: " + car);

    JsonNode jsonNode = objectMapper.valueToTree(car);
    System.out.println("JsonNode: " + jsonNode);
    System.out.println("at: " + jsonNode.at("/typ").asText());

    String json2 = "{\"aaa\": \"bbb\", \"ccc\": {\"ddd\": \"eee\", \"fff\": \"5\"}}";
    JsonNode jsonNode2 = objectMapper.readTree(json2);
    System.out.println("jsonNode2: " + jsonNode2);
    System.out.println("/ccc/fff: " + jsonNode2.at("/ccc/fff").asInt());

//    System.out.println("==============================");
//    int numbersArray[] = {2, 5, 7, 12, 8, 4, 11, 16, 19, 14, 9};
//    System.out.println(arrayToList(numbersArray));

//    System.out.println("==============================");
//    changeIteratedList();

  }
}
