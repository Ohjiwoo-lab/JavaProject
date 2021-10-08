/*
 * [예제 5-2] 상속 관계에 있는 클래스 간 멤버 접근
 * 클래스 Person을 아래와 같은 멤버 필드를 갖도록 선언하고 클래스 Student는 클래스 Person을 상속받아 각 멤버 필드에 값을 저장한다.
 * 이 예제에서 Person 클래스의 private 필드인 weight는 Student 클래스에서는 접근이 불가능하여 슈퍼 클래스인 Person의 get*, set* 메소드를 통해서만 조작 가능하다.
 * Person의 멤버 필드
 * - private int weight;
 * - int age;
 * - protected int height;
 * - public String name;
 */

package Chapter5;

class Person{
    private int weight;
    int age;
    protected int height;
    public String name;

    public int getWeight(){  // private 멤버 weight을 리턴해주는 메소드
        return weight;
    }

    public void setWeight(int weight){  // private 멤버 weight의 값을 변경하도록 해주는 메소드
        this.weight = weight;
    }
}

class Student extends Person{
    public void set(){
        age = 30;  // 슈퍼 클래스의 디폴트 멤버 접근 가능
        height = 175;  // 슈퍼 클래스의 protected 멤버 접근 가능
        name = "홍길동";  // 슈퍼 클래스의 public 멤버 접근 가능
        setWeight(99);  // 슈퍼 클래스의 private 접근 불가능, 따라서 set* 메소드를 이용하여 간접 접근
    }
}

public class InheritanceEx {
    public static void main(String[] args){
        Student s = new Student();  // Student 객체 생성
        s.set();  // Person의 멤버 필드 값들을 초기화한다.

        System.out.println("멤버 weight의 값: " + s.getWeight());  // weight을 가져올 때도 private 멤버이므로 직접 접근은 불가능. get* 메소드로 간접 접근
        System.out.println("멤버 age의 값: " + s.age);
        System.out.println("멤버 height의 값: " + s.height);
        System.out.println("멤버 name의 값: " + s.name);
    }
}
