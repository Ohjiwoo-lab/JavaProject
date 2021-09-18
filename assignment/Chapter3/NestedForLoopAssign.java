/*
 * [과제 4번] Scanner를 이용하여 소문자 알파벳을 하나 입력받고 알파벳을 출력하는 프로그램을 작성한다.
 * 만약 b를 입력받으면
 * ab
 * a
 * 이런식으로 출력하는 프로그램이다.
 */

package Chapter3;
import java.util.Scanner;

public class NestedForLoopAssign {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("소문자 알파벳 하나를 입력하시오>>");

        //Scanner는 문자를 입력받는 기능이 없다. 따라서 문자열을 입력받은 뒤, 이를 문자로 나눠서 사용해야 한다.
        String s = scanner.next();  //문자열로 입력받음
        char c = s.charAt(0);  //문자열의 첫 번째 문자를 가져옴(즉, 입력했던 소문자 알파벳 하나)

        /*
         * <아이디어>
         * 문자는 모두 아스키 코드로 표현가능하다. 이 점을 활용하여 연산을 통해 문자를 표현할 것이다.
         * 초기값은 a로 설정한다. a는 항상 출력되기 때문이다. 반복문을 설정하기 위해 입력한 알파벳에서 init의 차이를 구해야하는데,
         * 만약 알파벳이 e라면 c는 101이고, a는 97이므로 차이는 4이다. 하지만 e는 5번째 알파벳이므로 5가 나와야하기 때문에 차이를 구한 뒤 1을 더해주어 count를 구한다.
         * init은 변하면 안되므로 새로운 줄을 출력할 때마다 start에 대입하여 초기화해준다. 그러면 입력받은 c보다 작거나 같을 때까지 출력을 반복한다.
         * 출력할 때는 알파벳이 a부터 증가해야하기 때문에 start를 1씩 더해준다. 한 줄을 출력하고 나면 그 다음줄로 커서를 바꾼 뒤, c를 1 감소시킨다.
         * 이는 입력받은 것이 e라면 첫번 째 줄에 a부터 e까지 출력한 뒤, 다음 줄은 e에서 1 감소된 d가 되어 a 부터 d까지 출력한다. 이를 계속 반복하는 것이다.
         */
        char init = 'a';  //항상 처음 시작은 a이므로 초기값을 설정해준다.

        int count = c - init + 1;  //입력받은 알파벳과 초기값 a의 차이
        for(int i = 0; i < count; i++){  //차이값 만큼 반복하며 출력한다.
            char start = init;  //start가 a로 초기화
            while(start <= c){  //a부터 c까지 알파벳을 출력한다.
                System.out.print(start);
                start++;
            }
            System.out.println();
            c--;  //다음줄은 알파벳이 한개 적게 출력된다.
        }
        scanner.close();
    }
}
