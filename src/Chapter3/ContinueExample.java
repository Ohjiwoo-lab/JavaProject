/*
 * [예제 3-5] continue 문을 이용하여 양수 합 구하기
 * 5개의 정수를 입력받고 그 중 양수들만 합하여 출력하는 프로그램을 작성
 */

package Chapter3;
import java.util.Scanner;

public class ContinueExample {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("정수를 5개 입력하세요.");

        int sum = 0;
        for(int i = 0; i < 5; i++){
            int n = scanner.nextInt();  //정수를 받아옴
            if(n <= 0)  //정수가 0이거나 음수라면
                continue;  //더하지 않고 다음 for문으로 넘어감
            else  //정수가 양수라면
                sum += n;  //sum에 정수를 더한다.
        }
        System.out.println("양수의 합은 " + sum + "입니다.");

        scanner.close();
    }
}
