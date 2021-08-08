public class A {
  public static String backwardsPrime(long start, long end) {
    StringBuilder sb = new StringBuilder();
    for (long i = start; i <= end; i++) {
      if (ehPrimo(i)) {
        StringBuilder reverse = new StringBuilder(String.valueOf(i));
        reverse.reverse();
        if (!String.valueOf(i).equals(reverse.toString())
            && reverse.toString().length() > 1
            && ehPrimo(Long.parseLong(reverse.toString()))) {
          sb.append(i).append(" ");
        }
      }
    }
    return sb.toString().trim();
  }
  public static boolean ehPrimo(long i) {
    boolean primo = true;
    for (int j = 2; j <= i / 2; j++) {
      if (i % j == 0) {
        primo = false;
        break;
      }
    }
    return primo;
  }
}
