/*
 * [예제 6-6] 박싱 언박싱 연습하기
 * 박싱은 기본 타입의 값을 Wrapper 객체로 변환
 * 언박싱은 Wrapper 객체에 들어 있는 기본 타입의 값을 빼내는 것이다.
 * JDK 1.5 부터 자동 박싱과 자동 언박싱이 가능하다.
 */

package Chapter6;

public class AutoBoxingUnBoxingEx {
    public static void main(String[] args){
        int n = 10;
        Integer intObject = n;  // auto boxing
        System.out.println("intObject = " + intObject);

        int m = intObject + 10;  // auto unboxing
        System.out.println("m = " + m);
    }
}
