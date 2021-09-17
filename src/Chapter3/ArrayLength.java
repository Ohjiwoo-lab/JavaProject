/*
 * [예제 3-8] 배열 원소의 평균 구하기
 * 배열의 length 필드를 이용하여 배열 크기만큼 정수를 입력받고 평균을 구하는 프로그램을 작성
 */

package Chapter3;
import java.util.Scanner;

public class ArrayLength {
    public static void main(String[] args){
        int intArray[] = new int[5];  //배열의 선언과 생성
        int sum = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print(intArray.length + "개의 정수를 입력하세요>>");

        for(int i = 0; i < intArray.length; i++){
            intArray[i] = scanner.nextInt();  //입력받은 정수 저장
        }

        for(int i = 0; i < intArray.length; i++){
            sum += intArray[i];  //배열에 저장된 정수값들을 더해나감
        }
        System.out.print("평균은 " + (double)sum/intArray.length + "입니다.");  //sum을 배열의 크기로 나눠서 평균을 구함.

        scanner.close();
    }
}
