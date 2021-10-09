/*
 * [예제 5-3] super()를 활용한 ColorPoint 작성
 * super()를 이용하여 ColorPointThree 클래스의 생성자에서 슈퍼 클래스 PointThree 의 생성자를 호출하는 프로그램을 작성한다.
 */

package Chapter5;

class PointThree{
    private int x, y;  // 한 점을 구성하는 x, y 좌표

    // 인자 없는 생성자
    public PointThree(){
        this.x = this.y = 0;
    }

    // 인자 있는 생성자
    public PointThree(int x, int y){
        this.x = x;
        this.y = y;
    }

    // 점의 좌표 출력
    public void showPoint(){
        System.out.println("(" + x + ", " + y + ")");
    }
}

class ColorPointThree extends PointThree{
    private String color;  // 점의 색

    // 인자 있는 생성자
    public ColorPointThree(int x, int y, String color){
        super(x, y);  // 만약 서브 클래스에서 생성자를 선택하지 않으면 자동으로 슈퍼클래스의 인자없는 생성자가 호출된다. 여기서는 super()를 이용해 슈퍼클래스의 인자 있는 생성자를 호출하도록 명시하였다.
        this.color = color;
    }

    // 컬러 점의 좌표 출력
    public void showColorPoint(){
        System.out.print(color);
        showPoint();  // 슈퍼 클래스의 showPoint() 메소드 호출
    }
}

public class SuperEx {
    public static void main(String[] args){
        ColorPointThree cp = new ColorPointThree(5, 6, "blue");
        cp.showColorPoint();
    }
}
