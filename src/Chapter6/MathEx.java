/*
 * [예제 6-10] Math 클래스 메소드 활용
 * Math 클래스는 산술 연산 메소드를 제공해주는 클래스이다. 모든 메소드는 static 타입이라서 클래스 이름으로 바로 호출해야한다.
 */

package Chapter6;

public class MathEx {
    public static void main(String[] args){
        System.out.println(Math.PI);  // 원주율 상수 출력

        double a = 3.4;
        System.out.println(Math.ceil(a));  // ceil 올림
        System.out.println(Math.floor(a));  // floor 내림

        System.out.println(Math.sqrt(9));  // 9의 제곱근
        System.out.println(Math.exp(2));  // e의 2승
        System.out.println(Math.round(3.14));  // 3.14를 반올림

        // [1, 45] 사이의 정수형 난수 5개 발생
        System.out.print("이번주 행운의 번호는 ");
        for(int i = 0; i < 5; i++){
            System.out.print((int)(Math.random() * 45 + 1) + " ");
        }
    }
}
