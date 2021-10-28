/*
 * [예제 7-10] 스택의 내용을 반대로 만드는 제네릭 메소드 만들기
 * 예제 7-9의 GStack을 이용하여 주어진 스택의 내용을 반대로 만드는 제네릭 메소드 reverse()를 작성한다.
 */

package Chapter7;

public class GenericMethodExample {
    // T가 타입 매개 변수인 제네릭 메소드(스택의 내용을 반대로 만들어주는 메소드)
    public static <T> GStack<T> reverse(GStack<T> a) {
        GStack<T> s = new GStack<T>();
        while (true) {
            T tmp;
            tmp = a.pop(); // 원래 스택에서 요소 하나를 꺼냄
            if (tmp==null) // 스택이 비었음
                break;
            else
                s.push(tmp); // 새 스택에 요소를 삽입
        }
        return s; // 새 스택을 반환
    }

    // 메인 메소드
    public static void main(String[] args) {
        GStack<Double> gs = new GStack<Double>();  // Double 타입의 GStack 생성

        // 5개의 요소를 스택에 push
        for (int i = 0; i < 5; i++) {
            gs.push(new Double(i));
        }

        gs = reverse(gs);  // reverse 메소드로 스택의 요소를 반대로 뒤집음

        // 뒤집은 스택의 요소를 하나씩 빼내면서 출력
        for (int i = 0; i < 5; i++) {
            System.out.println(gs.pop());
        }
    }
}
