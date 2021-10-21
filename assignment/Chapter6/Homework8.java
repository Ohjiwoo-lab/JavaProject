/*
 * [8번 과제] 문자열을 입력받아 한 글자씩 회전시켜 모두 출력하는 프로그램을 작성한다.
 * String 클래스와 substring() 메소드를 활용하여 프로그램을 작성해보자.
 */

package Chapter6;
import java.util.Scanner;

public class Homework8 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);  // Scanner 객체 생성

        System.out.println("문자열을 입력하세요. 빈칸이 있어도 되고 영어 한글 모두 됩니다.");
        String myString = scanner.nextLine();  // 공백을 포함한 문자열을 입력받는다.

        for(int i = 0; i < myString.length(); i++){  // 입력받은 문자열의 길이만큼 반복해주면서 원래 문자열로 되돌아올때까지 회전한다.
            char firstChar = myString.charAt(0);  // 첫 번째 문자를 저장해둔다.
            String subString = myString.substring(1);  // 첫 번째 문자를 제외한 나머지 서브 문자열을 저장한다.
            myString = subString + firstChar;  // 서브 문자열에 첫 번째 문자열을 + 연산자로 연결해준다.
            System.out.println(myString);
        }
    }
}
