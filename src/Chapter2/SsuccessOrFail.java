/*
* if문 사용하기
* 시험 점수가 80점 이상이면 합격을 판별하는 프로그램을 작성
*/

package Chapter2;
import java.util.Scanner;

public class SsuccessOrFail {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);  //scanner라는 객체 생성

        System.out.print("점수를 입력하시오: ");
        int score = scanner.nextInt();
        if(score >= 80)
            System.out.println("축하합니다! 합격입니다.");

        scanner.close();
    }
}
