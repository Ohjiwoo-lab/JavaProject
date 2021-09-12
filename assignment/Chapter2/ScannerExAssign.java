/*
* 과제 2번
* Scanner 클래스를 이용하여 2자리의 정수(10~99 사이)를 입력받고, 십의 자리와 일의 자리가 같은지 판별하여 출력하는 프로그램 작성
*/

package Chapter2;
import java.util.Scanner;

public class ScannerExAssign {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("2자리수 정수 입력(10~99)>>");
        int num = scanner.nextInt();

        int share = num / 10;  //십의 자리
        int mod = num % 10;  //일의 자리

        if(share == mod)
            System.out.println("Yes! 10의 자리와 1의 자리가 같습니다.");
        else
            System.out.println("No. 10의 자리와 1의 자리가 같지 않습니다.");

        scanner.close();
    }
}
