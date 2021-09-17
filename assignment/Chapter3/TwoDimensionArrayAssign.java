/*
 * [과제 2번] 다음의 2차원 배열 n을 출력하는 프로그램을 작성
 * int n[][] = {{1}, {1, 2, 3}, {1}, {1, 2, 3, 4}, {1, 2}};
 */

package Chapter3;

public class TwoDimensionArrayAssign {
    public static void main(String[] args){
        //n은 각 행의 열의 개수가 다른 비정방형 비열이다. 따라서 for 문을 설정할 때 주의를 기울여야 한다.
        int n[][] = {
                {1},
                {1, 2, 3},
                {1},
                {1, 2, 3, 4},
                {1, 2}
        };

        /*
         * <아이디어>
         * 예제 3-11에서 유사한 문제가 존재하였는데, 행은 i로 n의 전체 개수 5번을 수행한다.
         * 열은 j로, i가 0일 때 n[0]의 개수 1번 수행, i가 1일 때 n[1]의 개수 3번 수행, ..., i가 4일 때 n[4]의 개수 2번 수행한다.
         * 이런 식으로 n의 각 행마다 다르게 반복문을 설정해줘야 한다.
         */
        for(int i = 0; i < n.length; i++) {  //행
            for (int j = 0; j < n[i].length; j++)  //열
                System.out.print(n[i][j] + " ");
            System.out.println();  //각 행마다 줄을 나눈다.
        }
    }
}
