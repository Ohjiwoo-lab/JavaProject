/*
* /와 % 산술 연산
* 초 단위의 정수를 입력받고, 몇 시간, 몇 분, 몇 초인지 출력하는 프로그램
*/

package Chapter2;
import java.util.Scanner;

public class ArithmeticOperator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);  //객체 생성

        System.out.print("정수를 입력하세요: ");
        int time = scanner.nextInt();  //정수를 받아옴
        int second = time % 60;  //시간을 60으로 나눈 나머지는 초를 뜻함
        int minute = (time / 60) % 60;  //시간을 60으로 나누면 초를 제외한 시간이 남는데, 다시 60으로 나눈 뒤 나머지가 분을 뜻함
        int hour = (time / 60) / 60;  //시간을 60으로 나눈 뒤 초를 제외한 시간에서 60으로 나누면 시간이 도출

        System.out.print(time + "초는 ");
        System.out.print(hour + "시간 ");
        System.out.print(minute + "분, ");
        System.out.println(second + "초입니다.");

        scanner.close();  //객체 소멸
    }
}
