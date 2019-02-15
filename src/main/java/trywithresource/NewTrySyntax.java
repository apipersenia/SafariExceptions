package trywithresource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NewTrySyntax {
  public static void main(String[] args) {
    String name = "data.txt";
    // AutoCloseable
    try (BufferedReader br = Files.newBufferedReader(Paths.get(name));
//     BufferedWriter bw = new BufferedWriter(null);
    ) {
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println("> " + line);
        // throw some important exception, not handled locally...
      }
    } catch (IOException ioe) {
      System.out.println("Broken");
    } // implicit finally - "important exception" will reach caller
  }
}
