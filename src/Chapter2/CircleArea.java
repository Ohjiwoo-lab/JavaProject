/*
* 변수, 리터럴, 상수 활용
* 원의 면적을 구하는 프로그램을 작성한다. final 키워드
*/

package Chapter2;

public class CircleArea {
    public static void main(String[] args){
        final double PI = 3.14;  //상수를 선언할 때는 final 키워드를 사용한다. 그러면 실행 중 값이 변경할 수 없기 때문에 안전하다.

        double radius = 10.0;  //원의 반지름
        double circleArea = radius * radius * PI;  //원의 면적 계산

        System.out.println("원의 면적 = " + circleArea);  //결과 출력
    }
}
