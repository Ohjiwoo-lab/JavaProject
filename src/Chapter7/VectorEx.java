/*
 * [예제 7-1] 정수만 다루는 Vector<Integer> 컬렉션 활용
 * 정수만 다루는 벡터를 생성하고, 활용하는 기본 사례를 보인다.
 */

package Chapter7;
import java.util.Vector;

public class VectorEx {
    public static void main(String[] args){
        Vector<Integer> v = new Vector<Integer>();  // 정수 값만 다루는 제네릭 벡터 생성

        v.add(5);  // 벡터에 5 삽입
        v.add(4);  // 벡터에 4 삽입
        v.add(-1);  // 벡터에 -1 삽입

        v.add(2, 100);  // 벡터 중간에 삽입하기. 인덱스 2 즉, 4와 -1 사이에 정수 100 삽입

        System.out.println("벡터 내의 요소 객체 수 : " + v.size());
        System.out.println("벡터의 현재 용량 : " + v.capacity());

        // 벡터의 모든 정수 요소 출력하기
        for(int i = 0; i < v.size(); i++){
            int n = v.get(i);
            System.out.println(n);
        }

        // 벡터 속의 모든 정수 더하기
        int sum = 0;
        for(int i = 0; i < v.size(); i++){
            int n = v.elementAt(i);
            sum += n;
        }
        System.out.println("벡터에 있는 정수 합 : " + sum);
    }
}
