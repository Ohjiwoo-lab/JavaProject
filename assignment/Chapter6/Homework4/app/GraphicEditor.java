/*
 * [과제 4번] Shape 클래스는 base 패키지에, Circle 클래스는 derived 패키지에, GraphicEditor 클래스는 app 패키지에 분리 작성한다.
 * 이 GraphicEditor 클래스에 main 메소드가 있다.
 */

package Chapter6.Homework4.app;
import Chapter6.Homework4.base.Shape;  // base 패키지의 Shape 클래스 import
import Chapter6.Homework4.derived.Circle;  // derived 패키지의 Circle 클래스 import

public class GraphicEditor {
    public static void main(String[] args){
        Shape shape = new Circle();  // Circle 객체를 만들어서 슈퍼 클래스인 Shape 객체로 변환
        shape.draw();  // shape 객체의 draw를 호출
        /*
         * shape 객체의 draw를 호출했지만, 객체를 생성할 때 Circle로 해주었기 때문에 "Shape"가 아닌 "Circle" 문자열이 출력된다.
         * 즉, 슈퍼 클래스인 Shape의 draw가 아니라 서브 클래스 Circle에서 재정의된 draw가 호출된다.
         */
    }
}
