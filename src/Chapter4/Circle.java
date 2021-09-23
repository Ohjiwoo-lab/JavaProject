/*
 * [예제 4-1] Circle 클래스의 객체 생성 및 활용
 * 반지름과 이름을 가진 Circle 크래스를 작성하고, Circle 클래스의 객체를 생성한다.
 */

package Chapter4;

public class Circle {
    int radius;  //원의 반지름
    String name;  //원의 이름

    public Circle() {}  //Circle 클래스의 생성자

    //원의 면적을 계산하는 메소드
    public double getArea(){
        return 3.14 * radius * radius;
    }

    //main 함수
    public static void main(String[] args){
        Circle pizza;  //Circle 객체 정의
        pizza = new Circle();  //Circle 객체 생성
        pizza.radius = 10;  //pizza의 반지름을 10으로 설정
        pizza.name = "자바피자";  //pizza의 이름을 '자바피자'로 설정
        double area = pizza.getArea();  //getArea 메소드를 이용하여 pizza의 면적 알아내기
        System.out.println(pizza.name + "의 면적은 " + area);

        Circle donut = new Circle();  //Circle 객체 생성
        donut.radius = 2;  //donut의 반지름을 2로 설정(pizza의 radius와 별개)
        donut.name = "자바도넛";  //donut의 이름을 '자바도넛'으로 설정(pizza의 name과 별개)
        area = donut.getArea();  //getArea 메소드를 이용하여 donut의 면적 알아내기
        System.out.println(donut.name + "의 면적은 " + area);
    }
}
