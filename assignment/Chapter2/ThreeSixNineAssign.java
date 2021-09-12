/*
* 6번 과제(369게임을 간단하게 작성)
* 1~99까지의 정수를 입력받고 정수에 3, 6, 9 중 하나가 있는 경우는 "박수짝"을 출력하고, 두 개 있는 경우는 “박수짝짝”을 출력하는 프로그램을 작성.
* 예를 들면 키보드로 입력된 수가 13인 경우 “박수짝”을, 36인 경우 “박수짝짝”을 출력하면 된다.
*/

package Chapter2;
import java.util.Scanner;

public class ThreeSixNineAssign {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("1~99 사이의 정수를 입력하시오>>");
        int num = scanner.nextInt();
        int share = num / 10;  //두 자리 정수에서 십의 자리
        int mod = num % 10;  //두 자리 정수에서 일의 자리

        int count = 0;
        if((share == 3) || (share == 6) || (share == 9))  //십의 자리가 3, 6, 9 중 하나인 경우
            count++;
        if((mod == 3) || (mod == 6) || (mod == 9))  //일의 자리가 3, 6, 9 중 하나인 경우
            count++;

        if(count == 1)  //count가 1이라면 count++ 연산이 1번 수행된 것이므로, 십의 자리 또는 일의 자리 중 하나가 3, 6, 9에 해당된다는 것.
            System.out.println("박수짝");
        else if(count == 2)  //count가 2라면 count++ 연산이 2번 수행된 것이므로, 십의 자리와 일의 자리 모두 3, 6, 9에 해당된다는 것.
            System.out.println("박수짝짝");
        else  //count가 0이라면 아무런 count++ 연산이 수행되지 않은 것이므로, 십의 자리와 일의 자리 모두 3, 6, 9에 해당되지 않는다.
            System.out.println("3, 6, 9 중 아무 숫자도 포함하지 않습니다.");

        scanner.close();
    }
}
