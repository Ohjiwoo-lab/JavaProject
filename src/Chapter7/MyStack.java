/*
 * [예제 7-9] 제네릭 스택 만들기
 * 자료구조 중 하나인 스택을 제네릭 클래스로 작성하고, String과 Integer형 스택을 사용하는 예를 보인다.
 */

package Chapter7;

// 스택의 제네릭 클래스
class GStack<T> {
    int tos;
    Object [] stck;

    // 인자 없는 생성자
    public GStack() {
        tos = 0;
        stck = new Object [10];
    }

    // 스택에 요소를 집어넣는 메소드
    public void push(T item) {
        if(tos == 10)  // 스택이 가득 찬 경우 요소를 넣지 않음
            return;
        stck[tos] = item;  // top에 요소를 넣고
        tos++;  // top을 1 증가시킴
    }

    // 스택에서 요소를 빼내는 메소드
    public T pop() {
        if(tos == 0)  // 스택에 요소가 없으면 빼내지 않음
            return null;
        tos--;  // top을 1 감소시킴으로써 요소를 빼냄
        return (T)stck[tos];
    }
}

public class MyStack {
    public static void main(String[] args) {
        GStack<String> stringStack = new GStack<String>();  // String을 저장하는 제네릭 클래스 객체 생성

        // 스택에 요소 삽입
        stringStack.push("seoul");
        stringStack.push("busan");
        stringStack.push("LA");

        // 스택에서 요소를 빼내서 출력
        for(int n = 0; n < 3; n++)
            System.out.println(stringStack.pop());

        GStack<Integer> intStack = new GStack<Integer>();  // Integer를 저장하는 제네릭 클래스 객체 생성

        // 스택에 요소 삽입
        intStack.push(1);
        intStack.push(3);
        intStack.push(5);

        // 스택에서 요소를 빼내서 출력
        for(int n = 0; n < 3; n++)
            System.out.println(intStack.pop());
    }
}
