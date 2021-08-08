public class B {
  public static int bouncingBall(double h, double bounce, double window) {
    if (h <= 0 || (bounce <= 0 || bounce >= 1) || window >= h) return -1;
    double count = Math.log(window/h) /Math.log(bounce);
    return count == 1 ? 1 : (int) (Math.floor(count) * 2) + 1;
  }
}