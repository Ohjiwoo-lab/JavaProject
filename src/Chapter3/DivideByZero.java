/*
 * [예제 3-14] ArithmeticException - 0으로 나누기 예외 발생으로 프로그램이 강제 종료되는 경우
 * 두 정수를 입력받아 나눗셈을 하고 몫을 구하는 프로그램을 작성한다. 사용자가 나누는 수에 0을 입력하면 ArithmeticException 예외가 발생하여 프로그램이 강제 종료된다.
 */

package Chapter3;
import java.util.Scanner;

public class DivideByZero {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int dividend;  //나눠지는 수
        int divisor;  //나누는 수

        System.out.print("나눠지는 수를 입력하시오: ");
        dividend = scanner.nextInt();

        System.out.print("나누는 수를 입력하시오: ");
        divisor = scanner.nextInt();

        System.out.println(dividend + "를 " + divisor + "로 나누면 몫은 " + dividend/divisor + "입니다.");
        //divisor가 0인 경우 예외가 발생, 따로 예외처리를 해주어야 한다.

        scanner.close();
    }
}
