/*
* 비교 연산자(>, <, !=, ==)와 논리 연산자(&&, ||) 사용하기
*/

package Chapter2;

public class LogicalOperator {
    public static void main(String[] args){
        //비교 연산
        System.out.println('a' > 'b');  //문자 b가 더 크므로 false
        System.out.println(3 >= 2);  //3이 2보다 크므로 true
        System.out.println(-1 < 0);  //-1이 0보다 작으므로 true
        System.out.println(3.45 <= 2);  //3.45가 2보다 크므로 false
        System.out.println(3 == 2);  //3은 2와 같지 않으므로 false
        System.out.println(3 != 2);  //3은 2와 같지 않으므로 true
        System.out.println(!(3 != 2));  //3은 2와 같지 않으므로 true인데, 이를 반대로 뒤집으므로 false

        //비교 연산과 논리 연산 복합
        System.out.println((3 > 2) && (3 > 4));  //3이 2보다 크므로 true와 3은 4보다 작으므로 false의 and 연산이므로 false
        System.out.println((3 != 2) || (-1 > 0));  //3은 2와 같지 않으므로 true와 -1은 0보다 작으므로 false의 or 연산이므로 true
    }
}
