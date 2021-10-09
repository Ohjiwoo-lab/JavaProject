/*
 * [예제 5-9] 인터페이스를 구현하고 동시에 클래스를 상속받는 사례
 * 인터페이스는 스펙을 주어 클래스들이 그 기능을 서로 다르게 구현할 수 있도록 하는 클래스의 규격 선언이며, 클래스의 다형성을 실현하는 도구이다.
 * 인터페이스가 다른 인터페이스를 상속/다중 상속할 수 있고, 클래스는 하나 이상의 인터페이스를 구현할 수 있다. 구현할 때는 implements 키워드를 사용한다.
 */

package Chapter5;

// 인터페이스 선언
interface PhoneInterfaceNine{
    final int TIMEOUT = 10000;  // 상수 필드 선언
    void sendCall();  // 추상 메소드
    void receiveCall();  // 추상 메소드
    default void printLogo(){  // defalut 메소드
        System.out.println("** Phone **");
    }
}

// 추가적인 추상 메소드를 선언한 인터페이스
interface MobilePhoneInterface extends PhoneInterfaceNine{
    void sendSMS();
    void receiveSMS();
}

// 인터페이스 선언
interface MP3Interface{
    public void play();
    public void stop();

}

// 클래스
class PDA{
    public int calculate(int x, int y){
        return x + y;
    }
}

// PDA를 상속받으면서, MobilePhoneInterface와 MP3Interface 인터페이스에 선언된 추상메소드를 모두 구현하는 SmartPhone 클래스
class SmartPhone extends PDA implements MobilePhoneInterface, MP3Interface{
    // MobilePhoneInterface의 추상 메소드 구현
    @Override
    public void sendCall(){
        System.out.println("따르릉따르릉~~");
    }

    @Override
    public void receiveCall(){
        System.out.println("전화 왔어요.");
    }

    @Override
    public void sendSMS(){
        System.out.println("문자갑니다.");
    }

    @Override
    public void receiveSMS(){
        System.out.println("문자왔어요.");
    }

    // MP3Interface의 추상 메소드 구현
    @Override
    public void play(){
        System.out.println("음악 연주합니다.");
    }

    @Override
    public void stop(){
        System.out.println("음악 중단합니다.");
    }

    // 추가로 작성한 메소드
    public void schedule(){
        System.out.println("일정 관리합니다.");
    }
}

public class InterfaceAndInheritanceEx {
    public static void main(String[] args){
        SmartPhone phone = new SmartPhone();  // SmartPhone 객체 생성
        phone.printLogo();
        phone.sendCall();
        phone.play();
        System.out.println("3과 5를 더하면 " + phone.calculate(3, 5) + "입니다.");
        phone.schedule();
    }
}
