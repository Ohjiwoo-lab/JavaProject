/*
 * [예제 3-17] 입력오류 시 발생하는 예외(InputMismatchException)
 * 3개의 정수를 입력받아 합을 구하는 프로그램을 작성한다. 사용자가 정수가 아닌 문자를 입력할 때 발생하는 InputMismatchException 예외를 처리하여 다시 입력받도록 한다.
 */

package Chapter3;
import java.util.Scanner;
import java.util.InputMismatchException;  //InputMismatchException 예외처리를 위해선 import 해야함

public class InputException {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("정수 3개를 입력하세요.");
        int sum = 0, n = 0;
        for(int i = 0; i < 3; i++){
            System.out.print((i+1) + ">>");
            try{
                n = scanner.nextInt();  //정수 받아옴. 사용자가 정수가 아닌 문자를 입력하면 InputMismatchException 예외 발생
            }
            catch(InputMismatchException e){
                System.out.println("정수가 아닙니다. 다시 입력하세요!");
                scanner.next();  //입력 스트림에 있는 정수가 아닌 토큰을 버린다.
                i--;  //인덱스가 증가하지 않도록 미리 감소
                continue;  //다음 루프를 계속 돈다.
            }
            sum += n;  //정수를 더하기
        }
        System.out.println("합은 " + sum + "입니다.");
        scanner.close();
    }
}
