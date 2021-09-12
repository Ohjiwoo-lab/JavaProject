/*
* 4번 과제
* Scanner 클래스로 정수 3개를 입력받고 3개의 숫자 중 중간 크기의 수를 출력. 평균값을 구하는 것이 아니라 중간값을 구하는 것이다.
*/

package Chapter2;
import java.util.Scanner;

public class MiddleNumAssign {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수 3개 입력>>");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int max, median, min;
        if(a > b){
            if(a > c) {
                max = a;
                if (b > c) {
                    median = b;
                    min = c;
                }
                else {
                    median = c;
                    min = b;
                }
            }
            else {
                max = c;
                median = a;
                min = b;
            }
        }
        else{
            if(b > c) {
                max = b;
                if(a > c){
                    median = a;
                    min = c;
                }
                else{
                    median = c;
                    min = a;
                }
            }
            else {
                max = c;
                median = b;
                min = a;
            }
        }
        System.out.println("중간값은 " + median);
        scanner.close();
    }
}
