/*
 * [과제 14번] 과목과 점수가 짝을 이루도록 2개의 배열을 작성한다. 과목 이름을 입력받아 해당하는 점수를 출력하는데, 잘못된 과목을 입력하면 '없는 과목입니다'를 출력한다.
 * 만약 '그만'을 입력한다면 프로그램을 종료한다.
 */

package Chapter3;
import java.util.Scanner;

public class ArrayForLoopUtilizeAssign {
    public static void main(String[] args){
        //이 두가지 배열은 과목과 점수가 짝을 이룬다.
        String course[] = {"Java", "C++", "HTML5", "컴퓨터구조", "안드로이드"};  //과목 이름 배열
        int score[] = {95, 88, 76, 62, 55};  //성적 배열

        Scanner scanner = new Scanner(System.in);  //객체 생성

        //무한 반복으로 설정한 뒤, '그만'이 입력되면 빠져나가도록 한다.
        while(true) {
            System.out.print("과목 이름>>");
            String s = scanner.nextLine();  //문자열(과목명)을 입력받는다.

            if(s.equals("그만"))  //그만이 입력되면 while 문을 break를 통해 빠져나간다.
                break;

            int i;
            for(i = 0; i < course.length; i++){  //과목의 개수만큼 실행
                if(course[i].equals(s)) {  //i번째 과목과 입력받은 s가 같다면 i번째 성적을 출력한다.(점수와 과목은 짝을 이루므로)
                    System.out.println(course[i] + "의 점수는 " + score[i] + "입니다.");
                    break;  //출력하면 바로 빠져나간다.
                }
            }

            /*
             * <아이디어>
             * 위의 for 문을 자세히 살펴보자. 과목의 개수만큼 실행이 되어서 i가 0일 때부터 course.length - 1 까지 값을 가진다.
             * 만약 일치하는 과목명이 있다면 점수를 출력한 뒤 바로 break 문을 통해 빠져나간다. 그렇다면 i가 course.length와 같은 값을 가질 때는 언제일까?
             * 가장 마지막에 일치하는 과목이 있다고 가정해보면, i가 course.length - 1 의 값을 가지고 있을 텐데, 점수를 출력하고 바로 빠져나오므로 i는 여전히 course.length - 1이다.
             * 일치하는 과목이 없을 때만이 i가 한번 더 증가되면서 course.length 와 같은 값을 가지게 된다. 이를 통해 일치하는 과목명이 있는지 없는지를 판단하였다.
             */
            if(i == course.length)  //일치하는 과목명이 없다는 뜻이므로 '없는 과목입니다'를 출력한다.
                System.out.println("없는 과목입니다.");
        }
        scanner.close();
    }
}
