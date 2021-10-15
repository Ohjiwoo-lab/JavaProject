/*
 * [예제 6-3] Point3 클래스에 equals() 작성
 * Point3 클래스에 두 점의 좌표가 같으면 true를 리턴하는 equals()를 작성한다.
 * == 연산자는 레퍼런스를 비교, 즉 두 레퍼런스가 같은 공간을 공유하고 있어야만 true를 리턴한다.
 * equals 메소드의 경우 레퍼런스의 내용이 같은지를 비교한다. 즉, 다른 공간을 가리키고 있더라도 두 레퍼런스의 내용이 동일하다면 true를 리턴한다.
 */

package Chapter6;

class Point3{
    int x, y;

    // 인자 있는 생성자
    public Point3(int x, int y){
        this.x = x;
        this.y = y;
    }

    // x와 y 가 같으면 true를 리턴하는 메소드
    public boolean equals(Object obj){
        Point3 p = (Point3)obj;
        if(x == p.x && y == p.y)
            return true;
        else
            return false;
    }
}

public class EqualsEx {
    public static void main(String[] args){
        Point3 a = new Point3(2, 3);
        Point3 b = new Point3(2, 3);
        Point3 c = new Point3(3, 4);

        if(a == b)  // false(== 연산자는 "b = a"로 같은 공간을 공유해야지 true를 리턴)
            System.out.println("a == b");
        if(a.equals(b))  // a와 b는 x, y 값이 동일하므로 true
            System.out.println("a is equal to b");
        if(a.equals(c))  // a와 c는 x, y 값이 동일하지 않으므로 false
            System.out.println("a is equal to c");
    }
}
