import java.util.Scanner;
/**
 * Created by Kafukaaa on 16/9/9.
 */
public class PersistentBookcase {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int k = scanner.nextInt();
    int[][][] book = new  int[k+1][n][m];
    int[] sum = new int[k+1];

    for (int j = 0; j < n; j++) {
      for (int l = 0; l < m; l++) {
        book[0][j][l] = 0;
      }
    }

    sum[0] = 0;
    for (int i = 1; i <= k; i++) {
      int a = scanner.nextInt();
      for (int j = 0; j < n; j++) {
        for (int l = 0; l < m; l++) {
          book[i][j][l] = book[i-1][j][l];
        }
      }
      int flag = 0;
      if (a == 1){
        int b = scanner.nextInt() - 1;
        int c = scanner.nextInt() - 1;
        if (book[i][b][c] == 0){
          book[i][b][c] = 1;
          flag = 1;
        }
        sum[i] = sum[i-1] + flag;
      }else if (a == 2){
        int b = scanner.nextInt() -1;
        int c = scanner.nextInt() -1;
        if (book[i][b][c] == 1){
          book[i][b][c] = 0;
          flag = -1;
        }
        sum[i] = sum[i-1] + flag;
      }else if (a == 3){
        int b = scanner.nextInt() - 1;
        for (int j = 0; j < m; j++) {
          if (book[i][b][j] == 0) {
            book[i][b][j] = 1;
            flag = flag + 1;
          } else {
            book[i][b][j] = 0;
            flag = flag - 1;
          }
        }
        sum[i] = sum[i-1] + flag;
      }else if (a == 4) {
        int b = scanner.nextInt();
        if (b == 0){
          sum[i] = 0;
          for (int j = 0; j < n; j++) {
            for (int l = 0; l < m; l++) {
              book[i][j][l] = 0;
            }
          }
        }else {
          sum[i] = sum[b];
          for (int j = 0; j < n; j++) {
            for (int l = 0; l < m; l++) {
              book[i][j][l] = book[b][j][l];
            }
          }
        }
      }
    }

    for (int i = 1; i <= k; i++) {
      System.out.println(sum[i]);
    }
  }
}
