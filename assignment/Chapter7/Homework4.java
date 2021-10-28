/*
 * [과제 4번] Vector 컬렉션을 이용하여 강수량의 평균을 유지 관리하는 프로그램을 작성한다.
 * 강수량을 입력하면 벡터에 추가하고 현재 입력된 모든 강수량과 평균을 출력한다.
 */

package Chapter7;
import java.util.Vector;
import java.util.Scanner;

public class Homework4 {
    public static void main(String[] args) {
        Vector<Integer> stack = new Vector<Integer>();  // Vector 컬렉션 생성
        Scanner scanner = new Scanner(System.in);   // Scanner 객체 생성

        while(true) {
            System.out.print("강수량 입력 (0 입력시 종료) >> ");
            int num = scanner.nextInt();  // 정수를 입력받음(강수량)

            if(num == 0)  // 0이 입력되면 break를 통해 while문을 빠져나가 종료한다.
                break;

            stack.add(num);  // 0이 아니라면 Vector에 추가한다.

            int average =0;
            for(int i = 0; i < stack.size(); i++) {
                System.out.print(stack.get(i) + " ");  // Vector의 요소를 하나씩 출력
                average += stack.get(i);  // average에 더해나간다.
            }
            System.out.println();

            average /= stack.size();  // 강수량을 모두 더한 것을 개수로 나눔으로써 평균을 구한다.
            System.out.println("현재 평균 " + average);  // 평균을 출력한다.
        }
        scanner.close();
    }
}