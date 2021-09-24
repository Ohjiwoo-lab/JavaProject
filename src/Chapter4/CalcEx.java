/*
 * [예제 4-11] static 멤버를 가진 Calc 클래스 작성
 * 전역 함수로 작성하고자 하는 abs, max, min의 3개 함수를 static 메소드로 작성하고 호출하는 사례를 작성한다.
 * static으로 설정하면, 클래스에 속해있지만, 전역변수, 전역함수와 같은 역할을 할 수 있다. 따라서 static으로 설정하면 다른 모든 클래스에서 사용가능하다.
 */

package Chapter4;

class Calc {
    public static int abs(int a){
        return (a > 0) ? a : -a;
    }
    public static int max(int a, int b){
        return (a > b) ? a : b;
    }
    public static int min(int a, int b){
        return (a > b) ? b : a;
    }
}

public class CalcEx {
    public static void main(String[] args){
        System.out.println(Calc.abs(-5));  //Calc 클래스로 객체를 따로 생성 안해도 Calc.abs 이렇게 사용가능
        System.out.println(Calc.max(10, 8));
        System.out.println(Calc.min(-3, -8));
    }
}
