/*
 * [예제 3-15] 0으로 나눌 때 발생하는 ArithmeticException 예외 처리
 * try-catch 블록을 이용하여 예제 3-14를 수정하여, 정수를 0으로 나누는 경우에 "0으로 나눌 수 없습니다!"를 출력하고 다시 입력받는 프로그램을 작성
 */

package Chapter3;
import java.util.Scanner;

public class DivideByZeroHandling {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while(true) {
            int dividend;  //나눠지는 수
            int divisor;  //나누는 수

            System.out.print("나눠지는 수를 입력하시오: ");
            dividend = scanner.nextInt();

            System.out.print("나누는 수를 입력하시오: ");
            divisor = scanner.nextInt();

            /*
             * try-catch-finally 문으로 예외 처리를 하는데, finally 문은 생략가능하다. 예외가 발생하지 않으면 try 실행 후, finally 문을 실행하는데,
             * 예외가 발생한다면 try는 실행되지 않고, catch 문이 실행된 후 finally 문이 실행된다.
             */
            try{
                System.out.println(dividend + "를 " + divisor + "로 나누면 몫은 " + dividend / divisor + "입니다.");
                break;  //정상적인 나누기 완료 후 while 문 벗어나기
            }
            catch(ArithmeticException e){  //ArithmeticException 예외 처리 코드
                System.out.println("0으로 나눌 수 없습니다! 다시 입력하세요.");  //break 문을 설정하지 않아서, 계속 다시 입력할 수 있도록 한다.
            }
        }
        scanner.close();
    }
}
