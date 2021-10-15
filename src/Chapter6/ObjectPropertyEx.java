/*
 * [예제 6-1] Object 클래스로 객체 속성 알아내기
 * 객체 레퍼런스만으로 객체의 클래스명, 해시코드 값, 객체의 문자열을 출력해보는 프로그램을 작성
 * Object 클래스는 java.lang 패키지에 포함되며, 모든 클래스의 슈퍼 클래스이다. java.lang은 자동으로 import된다.
 * 모든 클래스에 강제로 상속되며, 모든 객체가 공통으로 가지는 객체의 속성을 나타내는 메소드를 보유한다.
 */

package Chapter6;

class Point{
    int x, y;

    // 인자 있는 생성자
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class ObjectPropertyEx {
    public static void print(Object obj){  // Point 객체를 Object 클래스로 레퍼런스로 가져옴
        System.out.println(obj.getClass().getName());  // 클래스이름
        System.out.println(obj.hashCode());  // 해시코드 값
        System.out.println(obj.toString());  // 객체를 문자열로 만들어 출력
        System.out.println(obj);  // 객체 출력
    }

    public static void main(String[] args){
        Point p = new Point(2, 3);
        print(p);
    }
}
