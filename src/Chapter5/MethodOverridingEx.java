/*
 * [예제 5-5] 메소드 오버라이딩으로 다형성 실현
 * 슈퍼 클래스의 메소드를 서브 클래스에서 재정의한다. 따라서 슈퍼클래스의 메소드를 호출하더라도 동적 바인딩에 의해 서브 클래스의 오버 라이딩된 메소드가 호출된다.
 * 슈퍼 클래스에 선언된 메소드를 각 서브 클래스들이 자신만의 내용을 새롭게 구현 가능하다.
 * 오버라이딩은 실행 시간에 다형성을 실현할 수 있고, 오버로딩은 컴파일 타임에 다형성을 실현할 수 있다.(하나의 인터페이스에 서로 다른 내용 구현)
 */

package Chapter5;

// 슈퍼 클래스
class Shape{
    public Shape next;

    // 인자없는 생성자
    public Shape(){
        next = null;
    }

    public void draw(){
        System.out.println("Shape");
    }
}

class Line extends Shape{
    @Override
    public void draw(){  // 메소드 오버라이딩
        System.out.println("Line");
    }
}

class Rect extends Shape{
    @Override
    public void draw(){   // 메소드 오버라이딩
        System.out.println("Rect");
    }
}

class Circle extends Shape{
    @Override
    public void draw(){  // 메소드 오버라이딩
        System.out.println("Circle");
    }
}

public class MethodOverridingEx {
    static void paint(Shape p){
        p.draw();  // p가 가리키는 객체 내에 오버라이딩된 draw() 호출, 동적바인딩으로 실현된다.
    }

    public static void main(String[] args){
        Line line = new Line();
        paint(line);  // Shape로 업캐스팅되지만, Shape의 draw가 아닌 오버라이딩된 line의 draw가 호출된다.
        paint(new Shape());  // Shape의 draw 호출
        paint(new Line());  // Line의 draw 호출
        paint(new Rect());  // Rect의 draw 호출
        paint(new Circle());  // Circle의 draw 호출
    }
}
