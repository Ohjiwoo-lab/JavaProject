/*
 * [과제 4번] Converter 클래스를 상속받아 Km를 mie(마일)로 변환하는 Km2Mile 클래스를 작성하라.
 * km 단위로 숫자를 입력받아 이를 mile로 변환하여 출력해주는 프로그램이다.
 */

package Chapter5;
import java.util.Scanner;

// 단위를 변환하는 추상 클래스 Converter
abstract class Converter{
    // 추상 메소드
    abstract protected double convert(double src);
    abstract protected String getSrcString();
    abstract protected String getDestString();

    // 비율을 나타내는 멤버 변수
    protected double ratio;

    // 메소드
    public void run(){
        Scanner scanner = new Scanner(System.in);  // Scanner 객체 생성
        System.out.println(getSrcString() + "을 " + getDestString() + "로 바꿉니다.");
        System.out.print(getSrcString() + "을 입력하세요>> ");

        double val = scanner.nextDouble();  // 실수값을 하나 입력받음(km 단위의 값)
        double res = convert(val);  // km 단위의 값을 mile 단위로 변환
        System.out.println("변환 결과: " + res + getDestString() + "입니다.");
        scanner.close();
    }
}

// Converter 클래스를 상속받는 Km2Mile 클래스
class Km2Mile extends Converter{
    public Km2Mile(double ratio){
        this.ratio = ratio;
    }

    // Converter 클래스의 추상 메소드를 구현한다.
    @Override
    protected double convert(double src){
        return src / ratio;
        // ratio에 mile과 km의 비율을 저장해두었다. 1마일은 1.6km이므로 객체를 생성할 때 1.6을 생성자로 보내어, ratio에 1.6을 저장해둔다.
        // 여기서 km를 mile로 변환해야하므로, km로 입력된 값을 비율 1.6으로 나눠주어 mile로 변환할 수 있다. 따라서 변환된 mile 값을 리턴한다.
    }

    @Override
    protected String getSrcString(){
        return "Km";  // 바꾸기 위한 값은 Km 단위
    }

    @Override
    protected String getDestString(){
        return "mile";  // 바꾼 후 값은 mile 단위
    }
}

public class Homework4 {
    public static void main(String[] args){
        Km2Mile toMile = new Km2Mile(1.6);  // 1마일에 1.6이므로 비율을 1.6으로 설정
        toMile.run();  // Km2Mile 클래스의 슈퍼 클래스인 Converter 클래스의 메소드 run()이 호출된다.
    }
}
