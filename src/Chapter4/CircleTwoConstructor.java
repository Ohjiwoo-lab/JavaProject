/*
 * [예제 4-3] 두 개의 생성자를 가진 Circle 클래스
 * 예제 4-1에서 코드를 살짝 변경하여, 2개의 생성자를 이용하여 객체를 각각 생성해보고 실행결과를 확인하는 프로그램을 작성한다.
 * 생성자는 객체가 생성될 때 자동으로 호출되어 변수를 초기화하는 역할을 한다.
 */

package Chapter4;

public class CircleTwoConstructor {
    int radius;
    String name;

    //매개 변수 없는 생성자(생성자는 클래스 이름과 동일하다)
    public CircleTwoConstructor(){
        radius = 1;  //반지름을 1로 초기화(디폴트가 1이라고 보면 된다)
        name = "";
    }

    //매개 변수가 있는 생성자(입력받은 매개변수로 반지름과 이름을 초기화한다)
    public CircleTwoConstructor(int r, String n){
        radius = r;
        name = n;
    }

    //면적 계산하는 메소드
    public double getArea(){
        return 3.14 * radius * radius;
    }

    public static void main(String[] args){
        //CircleTwoConstructor 객체를 생성하면서, 반지름을 10, 이름을 '자바피자로' 설정(매개변수 있는 생성자가 호출된다)
        CircleTwoConstructor pizza = new CircleTwoConstructor(10, "자바피자");
        double area = pizza.getArea();
        System.out.println(pizza.name + "의 면적은 " + area + "입니다.");

        //CircleTwoConstructor 객체를 생성하면서, 반지름을 1, 이름을 ' ' 설정(매개변수가 없는 생성자가 호출된다)
        CircleTwoConstructor donut = new CircleTwoConstructor();
        donut.name = "도넛피자";
        area = donut.getArea();
        System.out.println(donut.name + "의 면적은 " + area + "입니다.");
    }
}
