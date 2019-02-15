package sentinel;

import java.io.FileReader;

public class BadIO {
  public static void main(String[] args) throws Throwable {
    FileReader fr = new FileReader("data.txt");
    int character;
    while ((character = fr.read()) != -2) {
      System.out.print((char) character);
    }
  }
}
