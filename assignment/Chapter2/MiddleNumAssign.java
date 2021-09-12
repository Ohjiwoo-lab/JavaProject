/*
* 4번 과제
* Scanner 클래스로 정수 3개를 입력받고 3개의 숫자 중 중간 크기의 수를 출력. 평균값을 구하는 것이 아니라 중간값을 구하는 것이다.
*/

package Chapter2;
import java.util.Scanner;

public class MiddleNumAssign {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수 3개 입력>>");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int median;
        if(((a > b) && (c > a)) || ((b > a) && (a > c)))
            median = a;
        else if(((b > a) && (c > b)) || ((a > b) && (b > c)))
            median = b;
        else
            median = c;

        System.out.println("중간값은 " + median);
        scanner.close();
    }
}
