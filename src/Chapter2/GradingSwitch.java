/*
* switch 문으로 학점 매기기
* 입력받은 성적에 대해 90점 이상은 A, 80점 이상 90점 미만은 B, 70점 이상 80점 미만은 C, 60점 이상 70점 미만은 D, 나머지는 F를 주는 프로그램을 switch문으로 구현
*/

package Chapter2;
import java.util.Scanner;

public class GradingSwitch {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        char grade;
        System.out.print("점수를 입력하세요(0~100): ");
        int score = scanner.nextInt();

        switch(score/10){
            case 10: //100점
            case 9: //90점 이상 100점 미만
                grade = 'A';
                break;
            case 8:  //80점 이상 90점 미만
                grade = 'B';
                break;
            case 7:  //70점 이상 80점 미만
                grade = 'C';
                break;
            case 6:  //60점 이상 70점 미만
                grade = 'D';
                break;
            default:  //60점 미만
                grade = 'F';
        }
        System.out.println("학점은 " + grade + "입니다.");
        scanner.close();
    }
}
