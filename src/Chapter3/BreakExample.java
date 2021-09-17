/*
 * [예제 3-6] break 문을 이용하여 while 문 벗어나기
 * exit이 입력되면 while 문을 벗어나도록 break 문을 활용하는 프로그램을 작성
 */

package Chapter3;
import java.util.Scanner;

public class BreakExample {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("exit을 입력하면 종료합니다.");
        while(true)  //무한 반복을 하다가 exit을 만나면 빠져나가도록 함
        {
            System.out.print(">>");
            String text = scanner.nextLine();  //nextLine을 통해 공백이 있는 문자열을 받아올 수 있다. next는 공백이 있으면 받아올 수 없다.
            if(text.equals("exit"))  //exit이 입력되면 break 문을 통해 while 문을 빠져나간다.
                break;
        }
        System.out.println("종료합니다....");

        scanner.close();
    }
}
