/*
 * [예제 5-7] 추상 클래스의 구현 연습
 * 추상 클래스 calculator를 상속받은 GoodCalc 클래스를 구현한다.
 * 추상 클래스에는 항상 abstract 키워드가 붙으며, 추상 메소드를 가질 수도 있고 가지지 않을 수도 있다.
 */

package Chapter5;

// 추상 메소드를 3개 가지는 추상 클래스
abstract class Calculator{
    public abstract int add(int a, int b);
    public abstract int subtract(int a, int b);
    public abstract double average(int[] a);
}

public class GoodCalc extends Calculator {
    @Override
    public int add(int a, int b){  // 추상 메소드 오버라이드
        return a + b;
    }

    @Override
    public int subtract(int a, int b){  // 추상 메소드 오버라이드
        return a - b;
    }

    @Override
    public double average(int[] a){  // 추상 메소드 오버라이드
        double sum = 0;
        for(int i = 0; i < a.length; i++){
            sum += a[i];
        }
        return sum / a.length;
    }

    public static void main(String[] args){
        GoodCalc c = new GoodCalc();
        System.out.println(c.add(2, 3));
        System.out.println(c.subtract(2, 3));
        System.out.println(c.average(new int[] {2, 3, 4}));
    }
}
