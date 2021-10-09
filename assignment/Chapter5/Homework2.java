/*
 * [과제 2번] 다음 main() 메소드와 실행 결과를 참고하여 문제 1의 colorTV를 상속받는 IPTV 클래스를 작성하라.
 * 문제 1번에서는 TV 클래스가 있고, 이 TV 클래스를 상속받는 ColorTV 클래스가 있다.
 * 1번에서 구현한 ColorTV 클래스를 상속받는 IPTV 클래스를 작성하는 문제이다.
 */

package Chapter5;

// ColorTV의 슈퍼 클래스
class TV{
    private int size;

    // 인자 있는 생성자
    public TV(int size){
        this.size = size;
    }

    // private인 size 멤버변수에 접근할 수 있도록 해주는 메소드
    protected int getSize(){
        return size;
    }
}

// TV를 상속받는 ColorTV 클래스, IPTV의 슈퍼 클래스
class ColorTV extends TV{
    private int color;

    // 인자 있는 생성자
    public ColorTV(int size, int color){
        super(size);  // 슈퍼 클래스의 인자 있는 생성자를 호출하기 위한 super() 사용
        this.color = color;
    }

    // 추가적인 메소드
    public void printProperty(){
        System.out.println(getSize() + "인치 " + color + "컬러");
    }

    // private인 color 멤버변수에 접근할 수 있도록 해주는 메소드
    protected int getColor(){
        return color;
    }
}

//ColorTV를 상속받는 IPTV 클래스
class IPTV extends ColorTV{
    private String address;

    // 인자 있는 생성자
    public IPTV(String address, int size, int color){
        super(size, color);  // 슈퍼 클래스의 인자 있는 생성자를 호출하기 위한 super() 사용
        this.address = address;
    }

    @Override
    public void printProperty(){  // 오버라이딩된 메소드
        System.out.println("나의 IPTV는 " + address + " 주소의 " + getSize() + "인치 " + getColor() + "컬러");
    }
}

public class Homework2 {
    public static void main(String[] args){
        // 과제 2번을 수행하기 위한 문제 1번 코드
        ColorTV myTV = new ColorTV(32, 1024);
        myTV.printProperty();

        // 과제 2번 코드
        IPTV iptv = new IPTV("192.1.1.2", 32, 2048);
        iptv.printProperty();  // ColorTV의 printProperty() 메소드가 아니라 IPTV의 printProperty() 메소드가 호출된다(오버라이딩 되었기 때문이다)
    }
}
