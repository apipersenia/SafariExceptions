package modemexample;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

class ModemDidNotConnectException extends Exception {
}

class ModemLibrary {
  public static void dialModem(/*phone number*/)
      throws ModemDidNotConnectException {
  }
}

class RetryCCLaterException extends Exception {
  public RetryCCLaterException() {
  }

  public RetryCCLaterException(String message) {
    super(message);
  }

  public RetryCCLaterException(String message, Throwable cause) {
    super(message, cause);
  }

  public RetryCCLaterException(Throwable cause) {
    super(cause);
  }

  public RetryCCLaterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}

class NoMoneyException extends Exception {
}

public class CCPayment {
  private static boolean useNetwork = true;

  public static void authorizePayment(/*CC Number, amount*/)
//    throws ModemDidNotConnectException, IOException {
      throws RetryCCLaterException, NoMoneyException {
    int retriesLeft = 3;
    while (retriesLeft-- > 0) {
      try {
        if (useNetwork) {
          Socket s = new Socket("127.0.0.1", 8080);
        } else {
          ModemLibrary.dialModem();
        }
        // attempt payment
      } catch (ModemDidNotConnectException | IOException ex) {
        if (retriesLeft < 1) throw new RetryCCLaterException(ex);
//      } catch (IOException se) {
//        if (retriesLeft < 1) throw new RetryCCLaterException(se);
      }
    }
  }

  public static void buySomething() {
//      throws ModemDidNotConnectException, IOException {
//      throws RetryCCLaterException, NoMoneyException {
    // check stock, find price
    // get paid
    try {
      authorizePayment();
    } catch (RetryCCLaterException re) {
    } catch (NoMoneyException nme) {
    }
  }
}
