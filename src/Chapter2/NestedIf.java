/*
* 중첩 if-else문 사례
* 점수와 학년을 입력 받아 60점 이상이면 합격, 미만이면 불합격을 출력하는 프로그램. 단, 4학년의 경우 70점 이상이어야 합격이다.
*/

package Chapter2;
import java.util.Scanner;

public class NestedIf {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("점수를 입력하세요(0~100): ");
        int score = scanner.nextInt();

        System.out.print("학년을 입력하세요(1~4): ");
        int year = scanner.nextInt();

        if(score >= 60){
            if(year != 4)
                System.out.println("합격!");  //성적이 60점 이상인데, 4학년이 아니면 합격
            else if(score >= 70)
                System.out.println("합격!");  //성적이 60점 이상인데, 4학년이면, 다시 70점 이상인지 검사하여 70점 이상이면 합격
            else
                System.out.println("불합격!");  //4학년인데 70점 이상이 아니므로 불합격
        }
        else
            System.out.println("불합격!");  //만약 60점을 못 넘는다면 학년에 상관없이 불합격

        scanner.close();
    }
}
