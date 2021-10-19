package Chapter6.Homework4.derived;
import Chapter6.Homework4.base.Shape;  // base 패키지의 Shape 클래스 import(상속받아야하기 때문)

// 서브 클래스
public class Circle extends Shape {
    @Override
    public void draw(){
        System.out.println("Circle");
    }
}
