/*
* 비트 논리 연산(&, |, ^, ~)과 비트 시프트 연산(<<, >>) 사용하기
*/

package Chapter2;

public class BitOperator {
    public static void main(String[] args){
        short a = (short)0x55ff;
        short b = (short)0x00ff;

        //비트 논리 연산
        System.out.println("[비트 연산 결과]");
        System.out.printf("%04x\n", (short)(a & b));  //비트 and 연산
        System.out.printf("%04x\n", (short)(a | b));  //비트 or 연산
        System.out.printf("%04x\n", (short)(a ^ b));  //비트 xor 연산
        System.out.printf("%04x\n", (short)(~a));  //비트 not 연산

        byte c = 20;  //0x14
        byte d = -8;  //0xf8

        //비트 시프트 연산
        System.out.println("[시프트 연산 결과]");
        System.out.println(c << 2);  //c를 2비트 왼쪽 시프트 연산
        System.out.println(c >> 2);  //c를 2비트 오른쪽 시프트 연산, 빈 곳에는 0 삽입(부호 코드가 양수라 0)
        System.out.println(d >> 2);  //d를 2비트 오른쪽 시프트 연산, 빈 곳에는 1 삽입(부호 코드가 음수라 1)
        System.out.printf("%x\n", (d >>> 2));  //d를 2비트 오른쪽 시프트 연산, 빈 곳에는 0 삽입(부호코드는 1이지만, >>>를 통해 0을 삽입
    }
}
