package processmany;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MagicBucket implements Iterable<String> {
  private Iterable<String> self;
  public MagicBucket(Iterable<String> contents) {
    self = contents;
  }

//  public void forEvery(Consumer<String> op) {
//    for (String s : self) {
//      op.accept(s);
//    }
//  }

  public MagicBucket map(Function<String, String> op) {
    List<String> out = new ArrayList<>();
    for (String s : self) {
      out.add(op.apply(s));
    }
    return new MagicBucket(out);

  }

  public MagicBucket filter(Predicate<String> pred) {
    List<String> out = new ArrayList<>();
    for (String s : self) {
      if (pred.test(s)) {
        out.add(s);
      }
    }
    return new MagicBucket(out);
  }

  public static void main(String[] args) {
    MagicBucket names = new MagicBucket(Arrays.asList("Fred", "Jim", "Sheila"));
    // lose short names, make all upper case

//    for (String s : names) {
//      if (s.length() > 3) {
//        System.out.println(s.toUpperCase());
//      }
//    }

    names = new MagicBucket(Arrays.asList());
    names
        .filter(s -> s.length() > 3)
        .map(s -> s.toUpperCase())
        .forEach(s -> System.out.println(s));
  }

  @Override
  public Iterator<String> iterator() {
    return self.iterator();
  }
}
