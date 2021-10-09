/*
 * [과제 6번] PointAssign 클래스를 상속받아 색을 가진 점을 나타내는 ColorPointAssign 클래스를 작성하라.
 * PointAssign 클래스는 2차원 상의 한 점을 표현하는 클래스이다.
 */

package Chapter5;

// 슈퍼 클래스
class PointAssign{
    private int x, y;

    // 인자 있는 생성자
    public PointAssign(int x, int y){
        this.x = x;
        this.y = y;
    }

    // private 멤버 변수 x에 접근할 수 있도록 하는 메소드
    public int getX(){
        return x;
    }

    // private 멤버 변수 y에 접근할 수 있도록 하는 메소드
    public int getY(){
        return y;
    }

    // 전달받은 값들로 좌표값을 변경하는 메소드
    protected void move(int x, int y){
        this.x = x;
        this.y = y;
    }
}

// 서브 클래스
class ColorPointAssign extends PointAssign{
    private String color = "BLACK";  // 색을 나타내는 멤버 변수, 디폴트는 black이다.

    // 인자 없는 생성자
    public ColorPointAssign(){
        super(0, 0);
        /*
        * 아이디어:
        * 슈퍼 클래스에는 인자 없는 생성자가 없기 때문에 인자있는 생성자를 호출하면서 (0, 0)으로 초기화를 진행한다.
        * ColorPointAssign 객체를 생성할 때 인자없이 생성하게 되면, 자동으로 슈퍼 클래스도 인자 없는 생성자가 호출된다.
        * 하지만 슈퍼 클래스에는 인자 없는 생성자가 없어서 오류가 발생한다.
        * 이를 슈퍼 클래스에 인자 없는 생성자를 추가하는 방법 대신 인자 있는 생성자를 활용하는 방법을 택하였다.
        */
    }

    // 인자 있는 생성자
    public ColorPointAssign(int x, int y){
        super(x, y);  // 슈퍼 클래스의 인자 있는 생성자를 호출하면서 x, y를 초기화한다.
    }

    // x와 y 값을 변경하기 위한 메소드
    public void setXY(int x, int y){
        move(x, y);  // 슈퍼클래스의 move() 메소드로 x,y 값을 변경한다.
    }

    // 색을 설정하는 메소드
    public void setColor(String color){
        this.color = color;  // 이 메소드로 색을 변경해주지 않으면, 기본적으로 black으로 설정된다.
    }

    public String toString(){
        return color + "색의 (" + getX() + ", " + getY() + ")의 점";
    }
}

public class Homework6 {
    public static void main(String[] args){
        ColorPointAssign zeroPoint = new ColorPointAssign();  // (0, 0) 위치의 BLACK 색 점
        System.out.println(zeroPoint.toString() + "입니다.");

        ColorPointAssign cp = new ColorPointAssign(10, 10);  // (10, 10) 위치의 BLACK 색 점
        cp.setXY(5, 5);  // (5, 5)로 위치 변경
        cp.setColor("RED");  // RED로 색 변경
        System.out.println(cp.toString() + "입니다.");  // (5, 5) 위치의 RED 색 점으로 변경된 값이 출력된다.
    }
}
