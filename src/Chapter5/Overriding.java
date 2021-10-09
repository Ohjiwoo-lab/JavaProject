/*
 * [예제 5-6] 메소드 오버라이딩
 * 게임에서 무기를 표현하는 Weapon 클래스를 만들고 살상능력을 리턴하는 fire() 메소드를 작성하면 다음과 같다. fire()는 1을 리턴한다.
 * 대포를 구현하기 위해 Weapon을 상속받는 Cannon 클래스를 작성하라. Cannon은 살상능력이 10이다. fire() 메소드를 이에 맞게 오버라이딩한다.
 */

package Chapter5;

class Weapon{
    protected int fire(){
        return 1;  // 무기는 기본적으로 한 명만 살상
    }
}

class Cannon extends Weapon{
    @Override  // 오버라이딩을 하고자 코드를 작성하였지만, 철자를 틀리게 작성할 경우 오류를 알려주는 어노테이션
    protected int fire(){  // 메소드 오버라이딩
        return 10;  // 대포는 한 번에 10명을 살상
    }
}

public class Overriding {
    public static void main(String[] args){
        Weapon weapon;
        weapon = new Weapon();  // Weapon 객체 생성
        System.out.println("기본 무기의 살상 능력은 " + weapon.fire() + "입니다.");

        weapon = new Cannon();  // 업캐스팅
        System.out.println("대포의 살상 능력은 " + weapon.fire() + "입니다.");
    }
}
