/*
 * [과제 2번] 중심을 나타내는 정수 x, y와 반지름 radius 필드를 가지는 Circle 클래스를 작성한다.
 * 생성자는 3개의 인자(x, y, radius)를 받아 해당 필드를 초기화하고, equals() 메소드는 두 개의 Circle 객체의 중심이 같으면 같은 것으로 판별하도록 한다.
 */

package Chapter6;

class Circle{
    int x, y;
    int radius;

    // 인자 있는 생성자
    public Circle(int x, int y, int radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    // 객체를 출력해주는 메소드
    @Override
    public String toString(){
        return "Circle(" + x + "," + y + ") 반지름" + radius;
    }

    // 두 Circle 객체의 중심이 같은지 판별하는 메소드
    public boolean equals(Object obj){
        Circle c = (Circle)obj;  // Object 객체를 Circle 객체로 형변환
        if(this.x == c.x && this.y == c.y)  // 중심 좌표가 같은 지 비교
            return true;
        else
            return false;
    }
}

public class Homework2 {
    public static void main(String[] args) {
        Circle a = new Circle(2, 3, 5);  // 중심 (2, 3)에 반지름 5인 원
        Circle b = new Circle(2, 3, 30);  // 중심 (2, 3)에 반지름 30인 원

        System.out.println("원 a: " + a);  // 자동으로 a.toString()으로 바뀐다. 객체 a가 출력된다.
        System.out.println("원 b: " + b);  // 자동으로 b.toString()으로 바뀐다. 객체 a가 출력된다.

        if(a.equals(b))
            System.out.println("같은 원");
        else
            System.out.println("서로 다른 원");
    }
}
