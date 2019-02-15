package processmany;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UseOptional {
  public static void main1(String[] args) {
    Map<String, String> names = new HashMap<>();
    names.put("Fred", "Jones");
    String fName = "FRed";

    String lastName = names.get(fName);
    String shouted = lastName.toUpperCase();
    String greeting = "Dear Mx. " + shouted;
    System.out.println(greeting);
  }
  public static void main(String[] args) {
    Map<String, String> names = new HashMap<>();
    names.put("Fred", "Jones");
    Optional<Map<String, String>> nameOpt = Optional.of(names);
    String fName = "FRed";

    nameOpt
        .map(m -> m.get(fName))
        .map(s -> s.toUpperCase())
        .map(s -> "Dear Mx. " + s)
        .ifPresent(s -> System.out.println(s));
  }
}
