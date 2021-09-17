/*
 * [예제 3-7] 배열에 입력받은 수 중 제일 큰 수 찾기
 * 양수 5개를 입력받아 배열에 저장하고, 제일 큰 수를 출력하는 프로그램을 작성
 */

package Chapter3;
import java.util.Scanner;

public class ArrayAccess {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int intArray[] = new int[5];  //정수 5개를 저장할 수 있는 배열 생성

        int max = 0;  //현재 가장 큰 수
        System.out.println("양수 5개를 입력하세요.");
        for(int i = 0; i < 5; i++){
            intArray[i] = scanner.nextInt();  //입력받은 정수를 배열에 차례대로 저장
            if(intArray[i] > max)  //intArray[i]가 현재 가장 큰 수 max보다 크면
                max = intArray[i];  //intArray[i]를 max로 변경
        }
        System.out.print("가장 큰 수는 " + max + "입니다.");

        scanner.close();
    }
}
