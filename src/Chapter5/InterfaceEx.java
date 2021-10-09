/*
 * [예제 5-8] 인터페이스 구현
 * PhoneInterface 인터페이스를 구현하고 flash() 메소드를 추가한 SamsungPhone 클래스를 작성한다.
 * 인터페이스는 클래스가 구현해야 할 메소드들이 선언되는 추상형이다.
 */

package Chapter5;

// 인터페이스 선언(틀을 선언)
interface PhoneInterface{
    final int TIMEOUT = 10000;  // 상수 필드 선언
    void sendCall();  // 추상 메소드
    void receiveCall();  // 추상 메소드
    default void printLogo(){  // defalut 메소드
        System.out.println("** Phone **");
    }
}

// 인터페이스를 실제로 구현한 클래스
class SamsungPhone implements PhoneInterface{
    // PhoneInterface의 모든 메소드를 구현해야 한다.
    @Override
    public void sendCall(){
        System.out.println("띠리리리링");
    }

    @Override
    public void receiveCall(){
        System.out.println("전화가 왔습니다.");
    }

    // 추가 메소드 작성
    public void flash(){
        System.out.println("전화기에 불이 켜졌습니다.");
    }
}

public class InterfaceEx {
    public static void main(String[] args){
        SamsungPhone phone = new SamsungPhone();  // SamsumgPhone 객체 생성
        phone.printLogo();
        phone.sendCall();
        phone.receiveCall();
        phone.flash();
    }
}
