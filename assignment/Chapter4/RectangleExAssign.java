/*
 * [과제 4번] 다음의 멤버를 가지고 직사각형을 표현하는 RectangleEx 클래스를 작성한다.
 *   - int 타입의 x, y , width, height 필드 : 사각형을 구성하는 점과 크기 정보
 *   - x, y, width, height 값을 매개변수로 받아 필드를 초기화하는 생성자
 *   - int square() : 사각형 넓이 리턴
 *   - void show() : 사각형의 좌표와 넓이를 화면에 출력
 *   - boolean contains(RectangleEx r) : 매개변수로 받은 r이 현 사각형 안에 있으면 true 리턴
 *   - main() 메소드의 코드와 실행 결과는 다음과 같다.
 */

package Chapter4;

class RectangleEx {
    private int x;  //사각형의 시작 x 좌표
    private int y;  //사각형의 시작 y 좌표
    private int width;  //사각형의 너비
    private int height;  //사각형의 높이

    //매개변수로 필드를 초기화하는 생성자
   public RectangleEx(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    //사각형 넓이를 리턴하는 메소드
    public int square(){
       return width * height;  //너비 * 높이 -> 면적
    }

    //사각형의 좌표와 넓이를 화면에 출력하는 메소드
    public void show(){
       System.out.println("(" + x + "," + y + ")" + "에서 크기가 " + width + "x" + height + "인 사각형");
    }

    /*
     * 매개변수로 받은 r이 현 사각형 안에 있으면 true 리턴하는 메소드
     *
     * 메인 아이디어:
     * 사각형이 사각형을 포함한다는 것은 2개의 점을 주의깊게 보면 된다.
     * 만약 t가 r을 포함하는 지를 확인하고 싶다고 해보자. 그러면 객체의 private 한 멤버변수는 t의 것이며, r은 (r.멤버변수) 이런식으로 표기해야 한다.
     * t의 내부에 r이 있으려면, t의 왼쪽 아래의 점의 좌표가 r의 왼쪽 아래의 점의 좌표보다 항상 작거나 같아야한다.
     * 즉 x(t의 왼쪽 아래의 점 x좌표)와 y(t의 왼쪽 아래의 점 y좌표)가 각각 r.x(r의 왼쪽 아래의 점 x좌표)와 r.y(r의 왼쪽 아래의 점 y좌표)보다 작거나 같아야한다.
     * 그리고 t의 오른쪽 위의 점의 좌표가 r의 오른쪽 위의 점의 좌표보다 언제나 크거나 같아야한다.
     * 즉 x + width(t의 오른쪽 위 점의 x좌표)와 y + height(t의 오른쪽 위 점의 y좌표)가 각각 r.x + r.width(r의 오른쪽 위 점 x좌표)와 r.y + r.height(r의 오른쪽 위 점 y좌표보다 크거나 같아야한다.
     *
     * 이 두 가지 점만 조건을 만족하면 언제나 r은 t에 포함된다. 이를 이용하여 contains 메소드의 if 조건문을 구성하였다.
     */
    public boolean contains(RectangleEx r){
        if((x <= r.x && y <= r.y) && (((x + width) >= (r.x + r.width)) && ((y + height) >= (r.y + r.height))))
            return true;
        else
            return false;
    }
}

public class RectangleExAssign {
    public static void main(String[] args){
        RectangleEx r = new RectangleEx(2, 2, 8, 7);  //첫 번째 사각형 r
        RectangleEx s = new RectangleEx(5, 6, 6, 6);  //두 번째 사각형 s
        RectangleEx t = new RectangleEx(1, 1, 10, 10);  //세 번째 사각형 t

        r.show();  //show 메소드를 이용해 r의 좌표와 크기를 출력

        System.out.println("s의 면적은 " + s.square() + "입니다.");  //square 메소드를 이용해 s의 면적을 출력
        if(t.contains(r))  //t에 r이 포함되어있는지 검사(포함되어있으면 true를 리턴하여 아래 문장 출력)
            System.out.println("t는 r을 포함합니다.");
        if(t.contains(s))  //t에 s가 포함되어있는지 검사(포함되어있으면 true를 리턴하여 아래 문장 출력)
            System.out.println("t는 s를 포함합니다.");
    }
}
