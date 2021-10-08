/*
 * [예제 5-1] 클래스 상속 만들기 - Point와 ColorPoint 클래스
 * (x, y)의 한 점을 표현하는 Point 클래스와 이를 상속받아 색을 가진 점을 표현하는 ColorPoint 클래스를 만들고 활용해보자.
 * 상속을 받을 때에는 extends 키워드를 사용한다.
 */

package Chapter5;

class Point{
    private int x, y;   // 한 점을 구성하는 x, y좌표

    public void set(int x, int y){
        this.x = x;
        this.y = y;
    }
    // 점의 좌표 출력
    public void showPoint(){
        System.out.println("(" + x + ", " + y + ")");
    }
}

// Point를 상속받은 ColorPoint 선언(extends 키워드)
class ColorPoint extends Point{
    private String color;  // 점의 색

    public void setColor(String color){
        this.color = color;
    }
    // 컬러 점의 좌표 출력
    public void showColorPoint(){
        System.out.print(color);
        showPoint();  // 부모 클래스인 Point 클래스의 showPoint() 호출
    }
}

public class ColorPointEx {
    public static void main(String[] args){
        Point p = new Point();  // Point 객체 생성
        p.set(1, 2);  // Point 클래스의 set() 함수 호출
        p.showPoint();  // Point 클래스의 showPoint() 함수 호출

        ColorPoint cp = new ColorPoint();  // ColorPoint 객체 생성
        cp.set(3, 4);  // ColorPoint 객체로 Point 클래스의 set() 함수 호출
        cp.setColor("red");  // ColorPoint 클래스의 setColor() 호출
        cp.showColorPoint();  // ColorPoint 클래스의 showColorPoint() 호출
    }
}
