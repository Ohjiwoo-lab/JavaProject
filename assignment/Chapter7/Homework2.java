/*
 * [과제 2번] Scanner 클래스를 사용하여 6개 학점('A', 'B', 'C', 'D', 'F')을 문자로 입력받아 ArrayList에 저장하고,
 * ArrayList를 검색하여 학점을 점수(A = 4.0, B = 3.0, C = 2.0, D = 1.0, F = 0.0)로 변환하여 평균을 출력하는 프로그램을 작성한다.
 */

package Chapter7;
import java.util.ArrayList;
import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {
        ArrayList<Character> stack = new ArrayList<Character>();  // 가변 크기 배열을 구현한 클래스인 ArrayList 객체를 생성
        Scanner scanner = new Scanner(System.in);  // Scanner 객체 생성

        System.out.print("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F) >> ");
        for (int i = 0; i < 6; i++) {
            String score = scanner.next();  // 학점을 입력받음
            char c = score.charAt(0);  // 입력받은 문자열을 문자로 변환
            stack.add(c);  // ArrayList에 추가
        }

        int sum = 0;
        for (int i = 0; i < stack.size(); i++) {
            char c = stack.get(i);  // ArrayList로부터 원소를 가져와서
            switch (c) {   // 학점이 무엇이냐에 따라 sum에 값을 달리 더함
                case 'A':  // 학점이 A인 경우
                    sum += 4;
                    break;
                case 'B':  // 학점이 B인 경우
                    sum += 3;
                    break;
                case 'C':  // 학점이 C인 경우
                    sum += 2;
                    break;
                case 'D':  // 학점이 D인 경우
                    sum += 1;
                    break;
                case 'F':  // 학점이 F인 경우
                    sum += 0;
                    break;
            }
        }

        double average = (double) sum / stack.size();  // ArrayList의 size란 원소의 총 개수이므로 sum을 개수로 나눠서 평균을 규한다.
        System.out.println(average);  // 평균을 출력한다.
        scanner.close();
    }
}