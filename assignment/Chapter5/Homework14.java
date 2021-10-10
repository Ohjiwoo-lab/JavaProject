/*
 * [과제 14번]] 다음 main() 메소드와 실행결과를 참고하여, 문제 13의 ShapeInterface 인터페이스를 구현한 클래스 OvalTwelve, RectTwelve를 추가 작성하고 전체 프로그램을 완성하라.
 * 문제 13에서는 ShapeInterface 인터페이스를 원을 그리고, 원의 면적을 리턴하도록 구현한 클래스 Circle이 있었다. 이를 여기서는 CircleTwelve로 구현할 것이다.
 * OvalTwelve는 ShapeInterface 인터페이스를 타원형을 그리고, 타원형의 면적을 리턴하도록 구현한 클래스이며,
 * RectTwelve는 ShapeInterface 인터페이스를 사각형을 그리고, 사각형의 면적을 리턴하도록 구현한 클래스이다.
 * 따라서 하나의 인터페이스를 총 3개의 클래스로 구현할 것이다.
 */

package Chapter5;

interface ShapeInterface{
    final double PI = 3.14;  // 상수
    void draw();  // 도형을 그리는 추상 메소드
    double getArea();  // 도형의 면적을 리턴하는 추상 메소드
    default public void redraw(){  //디폴트 메소드
        System.out.print("--- 다시 그립니다. ");
        draw();
    }
}

// 인터페이스를 원으로 구현한 클래스
class CircleTwelve implements ShapeInterface{
    private int radius;  // 원의 반지름

    // 인자 있는 생성자
    public CircleTwelve(int radius){
        this.radius = radius;  // 반지름 초기화
    }

    // ShapeInterface의 모든 메소드 구현
    @Override
    public void draw(){
        System.out.println("반지름이 " + radius + "인 원입니다.");
    }

    @Override
    public double getArea(){
        return PI * radius * radius;  // 원의 면적
    }
}

// 인터페이스를 타원으로 구현한 클래스
class OvalTwelve implements ShapeInterface{
    private int width, height;  // 타원이 내접하는 사각형의 밑변과 높이

    // 인자 있는 생성자
    public OvalTwelve(int width, int height){
        this.width = width;
        this.height = height;
    }

    // ShapeInterface의 모든 메소드 구현
    @Override
    public void draw(){
        System.out.println(width + "x" + height + "에 내접하는 타원입니다.");
    }

    @Override
    public double getArea(){
        return PI * (double)width * (double)height;  // 타원의 면적
    }
}

// 인터페이스를 사각형으로 구현한 클래스
class RectTwelve implements ShapeInterface{
    private int width, height;  // 사각형의 밑변과 높이

    // 인자 있는 생성자
    public RectTwelve(int width, int height){
        this.width = width;
        this.height = height;
    }

    // ShapeInterface의 모든 메소드 구현
    @Override
    public void draw(){
        System.out.println(width + "x" + height + " 크기의 사각형입니다.");
    }

    @Override
    public double getArea(){
        return (double)width * (double)height;  // 사각형의 면적
    }
}

public class Homework14 {
    public static void main(String[] args){
        ShapeInterface[] list = new ShapeInterface[3];  // ShapeInterface를 상속받는 클래스 객체의 레퍼런스 배열.
                                                        // 인터페이스는 객체 생성이 불가능하지만, 인터페이스 타입의 레퍼런스 변수는 선언가능하므로, ShapeInterface 타입의 레퍼런스 변수를 선언하였다.
        list[0] = new CircleTwelve(10);  // 반지름이 10인 원 객체
        list[1] = new OvalTwelve(20, 30);  // 20x30 사각형에 내접하는 타원
        list[2] = new RectTwelve(10, 40);  // 10x40 크기의 사각형

        for(int i = 0; i < list.length; i++){
            list[i].redraw();
        }
        for(int i = 0; i < list.length; i++){
            System.out.println("면적은 " + list[i].getArea() + "입니다.");
        }
    }
}