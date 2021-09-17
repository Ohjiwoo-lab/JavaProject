/*
 * [예제 3-9] for-each 문 활용
 * for-each 문은 배열이나 나열의 각 원소를 순차적으로 접근하는 데 유용한 for 문이다.
 */

package Chapter3;

public class ForEachEx {
    enum Week {월, 화, 수, 목, 금, 토, 일}  //클래스 ForEachEx에 정의

     public static void main(String[] args){
        int[] n = {1, 2, 3, 4, 5};
        String[] names = {"사과", "배", "바나나", "체리", "딸기", "포도"};

        int sum = 0;

        //아래 for-each 문에서 k는 n[0], n[1], n[2], n[3], n[4]로 반복이 일어난다.
         for(int k : n){
             System.out.print(k + " ");  //k값을 출력
             sum += k;
         }
         System.out.println("합은 " + sum + "입니다.");

         //아래 for-each 문에서 s는 names[0], ..., names[5]로 반복이 일어난다.
         for(String s : names){
             System.out.print(s + " ");  //s값 출력
         }
         System.out.println();

         //아래 for-each 문에서 day는 Week의 요소(월, 화, 수, 목, 금, 토, 일)로 반복이 일어난다.
         for(Week day : Week.values()){
             System.out.print(day + "요일 ");
         }
         System.out.println();
     }
}
