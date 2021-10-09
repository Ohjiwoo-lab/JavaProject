/*
 * [과제 8번] PointAssign2 클래스를 상속받아 양수의 공간에서만 점을 나타내는 PositivePoint 클래스를 작성하라.
 * PointAssign2 클래스는 Homework6에서의 PointAssign 클래스와 완전히 동일하다. 2차원 상의 한 점을 표현하기 위한 클래스이며, 클래스 이름을 같게 할 수 없어, 2를 붙여서 사용하였다.
 * PointAssign2 클래스의 move()를 PositivePoint 클래스에서 오버라이딩하여 재작성하고 적절히 super.move()를 호출해야한다.
 * PositivePoint의 2개의 생성자에서도 적절히 super() 생성자와 super.move()를 호출해야 한다.
 * 만약 음수의 공간으로 점을 이동하려고 하면, 이동되지 않고, 객체를 생성할 때 좌표값을 아예 음수로 전달한다면 디폴트로 (0, 0)으로 설정되도록 해야한다.
 */

package Chapter5;

// 슈퍼 클래스
class PointAssign2{
    private int x, y;

    // 인자 있는 생성자
    public PointAssign2(int x, int y){
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

// 서브 메소드
class PositivePoint extends PointAssign2{
    // 인자 없는 생성자
    public PositivePoint(){
        super(0, 0);  // 아무런 좌표값을 설정하지 않으면 (0, 0)으로 초기화
    }

    // 인자 있는 생성자
    public PositivePoint(int x, int y){
        super(x, y);
        if(x < 0 || y < 0){
            super.move(0, 0);  // 만약 음수의 공간을 입력받는다면, 슈퍼 클래스의 move 메소드를 이용하여 (0, 0)으로 이동해준다.
        }
    }

    // 음수의 공간에서는 이동이 되지 않도록 슈퍼 클래스의 move() 메소드를 재작성함
    @Override
    protected void move(int x, int y){
        if(x < 0 || y < 0){
            return;  // 음수공간을 입력받는다면, 아무일도 하지 않는다. 기존 좌표를 유지한다.
        }
        else{
            super.move(x, y);  // 음수의 공간을 입력받지 않은 경우에만, 슈퍼 클래스의 move() 메소드로 좌표를 이동해준다.
        }
    }

    // 추가적인 메소드
    public String toString(){
        return "(" + getX() + ", " + getY() + ")의 점";
    }
}

public class Homework8 {
    public static void main(String[] args){
        PositivePoint p = new PositivePoint();  // (0, 0) 좌표
        p.move(10, 10);  // (10, 10) 으로 이동
        System.out.println(p.toString() + "입니다.");  // (10, 10) 좌표의 점

        p.move(-5, -5);  // 객체 p는 음수 공간으로 이동하지 않는다. (-5, -5)는 음수공간이므로 이동하지 않고, p의 좌표는 그대로 (10, 10)이다.
        System.out.println(p.toString() + "입니다.");

        PositivePoint p2 = new PositivePoint(-10, -10);  // (-10, -10)은 음수공간이므로 p2는 (0, 0)의 좌표로 생성된다.
        System.out.println(p2.toString() + "입니다.");
    }
}
