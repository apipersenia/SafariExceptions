package processmany;

import java.util.function.Consumer;
import java.util.function.Function;

@FunctionalInterface
interface ExFunction<E, F> {
  F apply(E e) throws Throwable;
}

public class Either<E> {
  private E value;
  private Throwable problem;

  private Either() {
  }

  public static <E> Either<E> success(E value) {
    Either<E> self = new Either();
    self.value = value;
    return self;
  }

  public static <E> Either<E> failure(Throwable problem) {
    Either<E> self = new Either();
    self.problem = problem;
    return self;
  }

  public void ifSuccess(Consumer<E> op) {
    if (problem == null) {
      op.accept(value);
    }
  }

  public void ifFailed(Consumer<Throwable> op) {
    if (problem != null) {
      op.accept(problem);
    }
  }

  public boolean isSuccess() {
    return problem == null;
  }

  public static <E, F> Function<E, Either<F>> wrap(ExFunction<E, F> inFunc) {
    return e -> {
      try {
        return Either.success(inFunc.apply(e));
      } catch (Throwable t) {
        return Either.failure(t);
      }
    };
  }
}
