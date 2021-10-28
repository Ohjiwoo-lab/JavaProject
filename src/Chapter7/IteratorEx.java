/*
 * [예제 7-4] Iterator를 이용하여 Vector의 모든 요소를 출력하고 합을 구하는 프로그램
 * 예제 7-1의 코드를 Iterator<Integer>를 이용하여 수정한다.
 */

package Chapter7;
import java.util.*;

public class IteratorEx {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>();  // 정수 값만 다루는 제네릭 벡터 생성
        v.add(5); // 벡터에 5 삽입
        v.add(4); // 벡터에 4 삽입
        v.add(-1); // 벡터에 -1 삽입

        v.add(2, 100); // 4와 -1 사이에 정수 100 삽입

        // Iterator를 이용한 모든 정수 출력하기
        Iterator<Integer> it = v.iterator();  // iterator 생성
        while(it.hasNext()) {
            int n = it.next();  // 다음으로 이동
            System.out.println(n);  // 정수 출력
        }

        // Iterator를 이용하여 모든 정수 더하기
        int sum = 0;
        it = v.iterator(); // Iterator 객체 얻기
        while(it.hasNext()) {  // Iterator를 다음으로 이동해가면서 null이 될때까지 반복
            int n = it.next();  // Iterator가 가리키는 요소를 리턴
            sum += n;  // 정수를 sum에 더함
        }
        System.out.println("벡터에 있는 정수 합 : " + sum);  // 정수의 합 출력
    }
}


