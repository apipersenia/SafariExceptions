package processmany;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;

public class UseEither {
  public static Either<List<String>> read(String path) {
    try {
      return Either.success(Files.readAllLines(Paths.get(path)));
    } catch (Throwable t) {
      return Either.failure(t);
    }
  }
  public static void main2(String[] args) {
//    BufferedReader br = Files.newBufferedReader(Paths.get("data.txt"));
    Either<List<String>> ebr = read("xxdata.txt");

    ebr.ifSuccess(br -> br.forEach(l -> System.out.println(l)));

    ebr.ifFailed(t -> System.out.println("Problem! " + t.getMessage()));
  }
  public static void main(String[] args) {
    Function<String ,Either<List<String>>> funct =
        Either.wrap(n -> Files.readAllLines(Paths.get(n)));
    
    Either<List<String>> ebr = funct.apply("data.txt");

    ebr.ifSuccess(br -> br.forEach(l -> System.out.println(l)));

    ebr.ifFailed(t -> System.out.println("Problem! " + t.getMessage()));
  }
}
