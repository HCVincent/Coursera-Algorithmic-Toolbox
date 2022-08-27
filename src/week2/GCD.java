package week2;

import java.util.*;

public class GCD {
  private static int gcd(int a, int b) {
	  if(a == b) return a;
	  if(a == 1 || b == 1) return 1;
	  int result_gcd = 1;
	  while (result_gcd != a) {
		  if(a > b) a -= b;
		  else if(b > a) b -= a;
		  else result_gcd = a;
	  }
	  return result_gcd;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd(a, b));
  }
}
