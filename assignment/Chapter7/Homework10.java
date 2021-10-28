/*
 * [과제 10번] Vector<Shape>의 벡터를 이용하여 그래픽 편집기를 만들어본다.
 * 추상 클래스 Shape과 Line, Rect, Circle 클래스 코드를 잘 완성하고 이를 활용하여 "삽입", "삭제", "모두 보기", "종료"의 4가지 그래픽 편집 기능을 작성한다.
 * Vector를 이용하면 6장 실습문제 6번보다 훨씬 간단히 프로그램을 작성할 수 있다.
 */

package Chapter7;
import java.util.Scanner;
import java.util.Vector;

// 추상 클래스(슈퍼클래스)
abstract class Shape {
    private Shape next;

    public Shape() {  // 인자 없는 생성자
        next = null;
    }
    public void setNext(Shape obj) {
        next = obj;  //링크 연결
    }
    public Shape getNext() {
        return next;   // 링크 리턴
    }
    public abstract void draw();  // 추상 메소드
}

// 서브 클래스
class Line extends Shape {
    @Override
    public void draw() {  // Shape의 추상클래스를 구현하였다.
        System.out.println("Line");
    }
}

// 서브 클래스
class Rect extends Shape {
    @Override
    public void draw() {  // Shape의 추상클래스를 구현하였다.
        System.out.println("Rect");
    }
}

// 서브 클래스
class Circle extends Shape {
    @Override
    public void draw() {  // Shape의 추상클래스를 구현하였다.
        System.out.println("Circle");
    }
}

public class Homework10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // Scanner 객체 생성
        Vector<Shape> v = new Vector<Shape>();  // Vector 객체 생성
        Shape shape = null;

        System.out.println("그래픽 에디터 beauty을 실행합니다.");
        while(true) {
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4) >> ");
            int select = scanner.nextInt();  // 정수를 입력받음

            switch(select) {  // 입력받은 정수로 메뉴를 선택한다.
                case 1:  // 삽입
                    System.out.print("Line(1), Rect(2), Circle(3) >> ");
                    int choice = scanner.nextInt();  // 정수를 입력받음
                    switch(choice) {  // 입력받은 것으로 어떤 객체를 생성할 지 정한다.
                        case 1:  // Line 객체
                            shape = new Line();
                            break;
                        case 2:  // Rect 객체
                            shape = new Rect();
                            break;
                        case 3:  // Circle 객체
                            shape = new Circle();
                            break;
                    }
                    v.add(shape);  // 생성한 객체를 Vector에 추가한다.
                    break;
                case 2:  // 삭제
                    System.out.print("삭제할 도형의 위치 >> " );
                    int position = scanner.nextInt();  // 정수를 입력받음
                    if(v.size() == 0 || v.size() <= position)  // Vector에 원소가 없거나, 삭제할 도형의 위치가 Vector 최대 원소의 개수를 넘어갈 경우
                        System.out.println("삭제할 수 없습니다.");  // 해당 도형은 삭제할 수 없다.
                    else  // 적절한 위치의 도형을 선택했다면
                        v.remove(position);  // Vector로부터 remove 메소드를 통해 원소를 제거한다.
                    break;
                case 3:  // 모두 보기
                    for(int i = 0; i < v.size(); i++)  // Vector의 크기만큼
                        v.get(i).draw();  // 모든 원소를 가져와서 서브 클래스에서 재정의한 draw 메소드를 호출하여 출력한다.
                    /*
                     * 여기서 draw는 추상클래스 Shape의 서브 클래스 Line, Rect, Circle에서 모두 재정의되었다.
                     * 따라서 Vector에 어떤 객체든 다 올 수 있는데, 해당 객체에 맞는 draw 메소드가 호출될 것이다.
                     * Line 객체라면 Line의 draw 메소드가 호출된다는 것이다.
                     */
                    break;
                case 4:  // 종료
                    System.out.println("beauty을 종료합니다.");
                    scanner.close();  // Scanner 객체를 할당해제한 뒤 종료한다.
                    return;
            }
        }
    }
}