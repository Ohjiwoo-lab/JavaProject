/*
 * [예제 3-3] a-z까지 출력
 * do-while문을 이용하여 'a'부터 'z'까지 출력하는 프로그램
 */

package Chapter3;

public class DoWhileSample {
    public static void main(String[] args){
        char c = 'a';  //초기값 a

        //do while문을 통해 최소 한번은 수행이 되도록 한다.
        do {
            System.out.print(c);  //문자 출력
            c = (char) (c + 1);  //문자가 아스키 코드 값으로 표현되므로, a에서 1을 더하면 b가 된다는 것을 이용한다. 문자에 1을 더해 이를 문자로 변환하는 것을 통해 구현한다.
        } while(c <= 'z');  //z까지 출력하고 반복문을 빠져나온다.
    }
}
