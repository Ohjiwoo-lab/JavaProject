/*
 * [과제 12번] 텍스트로 입출력하는 간단한 그래픽 편집기를 만들어보자.
 * 본문 5.6절과 5.7절에서 사례로 든 추상 클래스 ShapeAssign와 LineAssign, RectAssign, CircleAssign 클래스 코드를 잘 완성하고 이를 활용하여 아래 시행 예시처럼
 * "삽입", "삭제", "모두 보기", "종료"의 4가지 그래픽 편집 기능을 가진 클래스 GraphicEditor을 작성하라.
 */

package Chapter5;
import java.util.Scanner;
import java.lang.System;

// 추상 메소드를 1개 가지는 Shape 추상 클래스
abstract class ShapeAssign{
    private ShapeAssign next;

    // 인자 없는 생성자
    public ShapeAssign(){
        next = null;
    }

    // 다음 노드로 연결하는 메소드
    public void setNext(ShapeAssign obj){
        next = obj;
    }

    // 다음 노드를 리턴해주는 메소드
    public ShapeAssign getNext(){
        return next;
    }

    // 추상 메소드
    public abstract void draw();
}

// 라인 서브 클래스
class LineAssign extends ShapeAssign{
    private String name = "Line";

    @Override
    public void draw(){
        System.out.println(name);
    }
}

// 사각형 서브 클래스
class RectAssign extends ShapeAssign{
    private String name = "Rect";

    @Override
    public void draw(){
        System.out.println(name);
    }
}

// 원 서브 클래스
class CircleAssign extends ShapeAssign{
    private String name = "Circle";

    @Override
    public void draw(){
        System.out.println(name);
    }
}

// 편집 기능을 가진 클래스
class GraphicEditor{
    private ShapeAssign head, tail;  // 노드를 가리크는 포인터로, 삽입과 삭제, 보여주기 기능에 사용된다.
    private Scanner scanner;

    // 인자 없는 생성자
    public GraphicEditor() {
        head = null;   // 시작 노드를 가리키는 레퍼런스
        tail = null;   // 끝 노드를 가리키는 레퍼런스
        scanner = new Scanner(System.in);  // 입력 받기 위한 Scanner 객체 생성
    }

    // 노드 삽입
    public void insert() {
        ShapeAssign shape = null;

        System.out.print("Line(1), Rect(2), Circle(3) >> ");
        int primitive = scanner.nextInt();  // 어떤 노드를 삽입할 지 입력받는다.

        switch (primitive){
            case 1:
                shape = new LineAssign();  // 라인
                break;
            case 2:
                shape = new RectAssign();  // 사각형
                break;
            case 3:
                shape = new CircleAssign();  // 원
                break;
            default:
                System.out.println("다시 입력해주세요.");  // 잘못된 번호를 입력
                break;
        }
        if(head == null) { // head가 아무것도 가리키지 않으면(노드가 하나도 없으면)
            head = shape;  // head랑 tail이 새로운 노드를 가리키게 함
            tail = shape;
        }
        else {  // 만약 가리키는 노드가 하나 이상 존재하면
            tail.setNext(shape);  // 끝 노드에 새로운 노드를 연결하고,
            tail = shape;  // 끝 노드는 새로 만들어진 노드를 가리키게 함
        }
    }

    // 노드 삭제
    public void delete(){
        ShapeAssign cur = head;  // 현재 노드를 가리키는 포인터
        ShapeAssign tmp = head;  // 임시로 저장하는 데 사용되는 포인터

        System.out.print("삭제할 도형의 위치 >> ");
        int num = scanner.nextInt();  // 삭제할 도형을 입력받음

        int i;
        if(num == 1) {  // 첫번째 노드를 삭제하는 경우
            if(head == tail) {  // 노드가 한 개일 경우
                head = null;  // 그 한 개의 노드를 삭제해주면 된다.
                tail = null;
                return;
            }
            else {  // 노드가 두개 이상인 경우
                head = head.getNext();  // head(처음 노드를 가리크는 포인터)를 하나 뒤로 옮김으로써 처음 노드를 삭제한다.
                return;
            }
        }

        // 원소의 개수보다 큰 값을 입력한 경우 예외 처리
        for(i = 1; i < num; i++) {
            tmp = cur;  // 현재 노드를 저장 후 (즉, 이전 노드)
            cur = cur.getNext();  // 다음 노드로 이동
            if(cur == null) {  // 노드 수가 입력 값보다 적을 때 삭제할 수 없다고 출력함
                System.out.println("삭제할 수 없습니다.");
                return;
            }
        }
        if(i == num) {  // 끝 노드를 가리킬때
            tmp.setNext(cur.getNext());  // 현재의 다음 노드를 가져와서 tmp의 다음노드로 설정
            tail = tmp;  // tmp가 끝 노드가 됨
        }
        else  // 끝노드가 아니라면 이전노드가 다음 노드를 가리킴 (즉, 현재 노드 삭제)
            tmp.setNext(cur.getNext());
    }

    // 노드 전체 보기
    public void view(){
        ShapeAssign s = head;  // 처음 노드
        while(s != null) {
            s.draw();  // 각 노드를 출력한 뒤
            s = s.getNext();  // 다음 노드로 이동
        }
    }
}

public class Homework12 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("그래픽 에디터 beauty을 실행합니다.");

        GraphicEditor graphic = new GraphicEditor();  // GraphicEditor 객체 생성

        while(true) {
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4) >> ");
            int num = scanner.nextInt();  // 정수를 입력받음

            switch (num) {
                case 1:
                    graphic.insert();  // 원소 삽입
                    break;
                case 2:
                    graphic.delete();  // 원소 삭제
                    break;
                case 3:
                    graphic.view();  // 원소 모두 보기
                    break;
                case 4:  // 4를 입력받으면 종료
                    System.out.println("beauty을 종료합니다.");
                    System.exit(0);
            }
        }
    }
}
