public class C {
  public static int solution(int number) {
    int sum = 0;
    HashMap<Integer, Integer> multMap = new HashMap<>();
    for (int i = 3; i < number; i +=3) {
      multMap.put(i,i);
    }
    for (int i = 5; i < number; i +=5) {
      multMap.put(i,i);
    }
    for (Integer i : multMap.values() ) {
      sum += i;
    }
    return sum;
  }
}