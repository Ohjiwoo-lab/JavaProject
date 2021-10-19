/*
 * [예제 6-9] StringTokenizer 클래스 메소드 활용
 * "홍길동/장화/홍련/콩쥐/팥쥐" 문자열을 '/'를 구분 문자로 하여 토큰을 분리하여 각 토큰을 출력하는 프로그램을 작성한다.
 * StringTokenizer 클래스는 하나의 문자열을 여러 문자열로 분리할 때 사용하는 클래스이다. String 클래스에서 split() 메소드와 동일한 기능이다.
 */

package Chapter6;
import java.util.StringTokenizer;

public class StringTokenizerEx {
    public static void main(String[] args){
        StringTokenizer st = new StringTokenizer("홍길동/장화/홍련/콩쥐/팥쥐", "/");  // 문자열을 주어진 구분자 /로 토큰화한다.

        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());  // 분리한 토큰을 하나씩 출력
        }
    }
}
