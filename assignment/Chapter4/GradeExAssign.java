/*
 * [과제 2번] 3과목의 점수를 입력받아 평균을 계산하는 Grade 클래스를 작성한다.
 * Grade 객체를 생성하고 성적의 평균을 출력하는 main함수를 작성한다.
 * Grade 클래스에 int 타입의 math, science, english 필드를 private로 선언하고, 생성자와 세 과목의 평균을 리턴하는 average() 메소드를 작성한다.
 */

package Chapter4;
import java.util.Scanner;

/*
 * 클래스 Grade :
 * 3개의 멤버 변수와 1개의 생성자, 1개의 메소드를 가진다.
 * 멤버 변수는 모두 클래스 Grade 내부에서만 사용되기 때문에 private 접근지정자로 선언하였다.
 */
class Grade {
    private int math;     //수학성적
    private int science;  //과학성적
    private int english;  //영어성적

    //생성자(매개변수로 값 초기화)
    public Grade(int math, int science, int english) {
        this.math = math;
        this.science = science;
        this.english = english;
    }

    //세 과목의 평균을 계산하는 메소드(실행결과가 int여서 평균을 계산한 뒤 int로 형변환하여 리턴한다)
    public int average(){
        return (int)((math + science + english) / 3);
    }
}

public class GradeExAssign {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);  //스캐너 객체 생성

        System.out.print("수학, 과학, 영어 순으로 3개의 점수 입력 >> ");
        int math = scanner.nextInt();  //수학 점수 입력받음
        int science = scanner.nextInt();  //과학 점수 입력받음
        int english = scanner.nextInt();  //영어 점수 입력받음

        Grade me = new Grade(math, science, english);  //Grade 객체 생성(인자로 입력받은 수학, 과학, 영어 성적을 보낸다)
        System.out.println("평균은 " + me.average() + "입니다.");  //Grade 객체 me의 메소드 average를 호출하여 세 과목의 평균을 계산한다.

        scanner.close();
    }
}
