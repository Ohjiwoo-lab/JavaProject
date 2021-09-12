/*
* 다중 if-else로 학점 매기기
* 다중 if-else문을 이용하여 입력받은 성적에 대해 학점을 부여하는 프로그램을 작성
*/

package Chapter2;
import java.util.Scanner;

public class Grading {
    public static void main(String[] args){
        char grade;
        Scanner scanner = new Scanner(System.in);  //scanner 객체 생성

        System.out.print("점수를 입력하세요(0~100): ");
        int score = scanner.nextInt();  //점수 읽기
        if(score >= 90)
            grade = 'A';  //90점 이상
        else if(score >= 80)
            grade = 'B';  //80점 이상 90점 미만
        else if(score >= 70)
            grade = 'C';  //70점 이상 80점 미만
        else if(score >= 60)
            grade = 'D';  //60점 이상 70점 미만
        else
            grade = 'F';  //60점 미만

        System.out.println("학점은 " + grade + "입니다.");

        scanner.close();
    }
}
