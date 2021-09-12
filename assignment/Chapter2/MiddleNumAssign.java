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
        /*
        * 메인 아이디어:
        * 값이 3개밖에 되지 않으므로 가능한 모든 경우의 수를 찾아보았다.
        * a가 중간값이 되는 경우는 2가지 뿐이다. b > a > c와 c > a > b. 따라서 이를 이용하여 if 문의 조건을 구성하였다.
        * b가 중간값이 되는 경우도 2가지 뿐이다. a > b > c와 c > b > a. 따라서 이를 이용하여 마찬가지로 if 문의 조건을 구성하였다.
        * c가 중간값이 되는 경우는 a와 b가 중간값이 되는 경우를 제외한 나머지이다. 예외는 없다. 따라서 else 문에 배치하였다.
        */
        if(((a > b) && (c > a)) || ((b > a) && (a > c)))  //a가 중간값이 되는 경우
            median = a;
        else if(((b > a) && (c > b)) || ((a > b) && (b > c)))  //b가 중간값이 되는 경우
            median = b;
        else  //c가 중간값이 되는 경우(a와 b가 중간값인 경우를 제외한 나머지)
            median = c;

        System.out.println("중간값은 " + median);
        scanner.close();
    }
}
