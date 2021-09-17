/*
 * [예제 3-2] -1이 입력될 때까지 입력된 수의 평균 구하기
 * while문을 이용하여 정수를 여러 개 입력받고 평균을 출력하는데, -1이 입력되면 입력이 종료되는 프로그램
 */

package Chapter3;
import java.util.Scanner;

public class WhileSample {
    public static void main(String[] args){
        int count = 0;  //입력된 정수의 개수를 저장하는 변수
        int sum = 0;  //입력된 정수들을 더하여 저장하는 변수

        Scanner scanner = new Scanner(System.in);  //scanner 객체 생성, 정수들을 빈칸을 두고 입력함
        System.out.println("정수를 입력하고 마지막에 -1을 입력하세요.");

        int n = scanner.nextInt();  //정수를 읽어옴
        while(n != -1)  //입력된 정수가 -1이 아닌 동안 반복(-1이면 반복문 벗어남)
        {
            sum += n;
            count++;
            n = scanner.nextInt();  //다음 정수 읽어옴
        }

        //만약 count가 초기값인 0이라면 아무런 수가 입력되지 않은 것이므로 '입력된 수가 없다'고 출력
        if(count == 0)
            System.out.println("입력된 수가 없습니다.");
        else{  //입력된 정수가 있다면
            System.out.print("정수의 개수는 " + count + "개이며, ");  //입력된 총 개수 출력
            System.out.println("평균은 " + (double)sum/count + "입니다.");  //입력된 정수를 모두 더한 뒤 전체 개수로 나눠서 평균을 구함
        }

        scanner.close();
    }
}
