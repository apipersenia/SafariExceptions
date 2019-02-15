package trywithresource;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OldTrySyntax {
  public static void main(String[] args) {
    String name = "data.txt";
    BufferedReader br = null;
    try {
      br = Files.newBufferedReader(Paths.get(name));
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println("> " + line);
        // throw some important exception, not handled locally...
      }
    } catch (IOException ioe) {
      System.out.println("Broken");
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
