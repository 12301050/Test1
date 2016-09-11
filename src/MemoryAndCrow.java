import java.util.Scanner;
/**
 * Created by Kafukaaa on 16/9/11.
 */
/*本题的要点：能用几个int解决的就不要用int[]*/
public class MemoryAndCrow {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int a, b = 0;
    for (int i = 0; i < n; i++) {
      a = scanner.nextInt();
      if (i > 0){
        System.out.print(a + b + " ");
      }
      b = a;
    }
    System.out.println(b);
  }
}
