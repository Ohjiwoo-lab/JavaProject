/*
 * [예제 6-2] Point2 클래스에 toString() 작성
 * Point2 클래스에 Point2 객체를 문자열로 리턴하는 toString() 메소드를 작성한다.
 * Object 클래스에 toString()이 구현되어있는데, 따라서 객체를 출력하면 자동으로 toString() 메소드를 호출한다.
 * 따라서 개발자는 Object의 toString()을 오버라이딩하여 자신만의 메소드를 작성할 필요가 있다.
 */

package Chapter6;

class Point2{
    int x, y;

    // 인자 있는 생성자
    public Point2(int x, int y){
        this.x = x;
        this.y = y;
    }

    // Point2 객체를 문자열로 리턴하는 메소드(Object의 toString()을 오버라이딩함)
    public String toString(){
        return "Point(" + x + "," + y+ ")";
    }
}

public class ToStringEx {
    public static void main(String[] args){
        Point2 p = new Point2(2, 3);
        System.out.println(p.toString());
        System.out.println(p);  // p는 p.toString()으로 자동 변환
        System.out.println(p + "입니다.");  // p.toString() + 입니다 로 자동변환
    }
}
