/*
 * [과제 10번] 4X4의 2차원 배열을 만들고 이곳에 1에서 10까지 범위의 정수를 10개만 랜덤하게 생성하여 임의의 위치에 삽입하는 프로그램
 * 동일한 정수가 있어도 되며, 10개를 채우고 나머지 6개의 숫자는 모두 0으로 채운다. 만들어진 2차원 배열을 화면에 출력한다.
 */

package Chapter3;
import java.util.Random;

public class TwoDimensionRandomArrayAssign {
    public static void main(String[] args){
        int intArray[][] = new int[4][4];  //4x4 배열 생성, 생성할 때 따로 값을 지정해주지 않았으므로 자동으로 0으로 초기화된다.

        Random random = new Random();

        /*
         * <아이디어>
         * intArray 배열을 생성할 때 이미 모든 값들이 0으로 채워진다. 따라서 10개의 랜덤한 정수를 삽입하기만 하면 나머지는 자동으로 0으로 채워지는 것이다.
         * 먼저, 정수와 intArray의 행, 열에 해당하는 정수를 각각 뽑는다. 중복은 있어도 되므로 따로 조건을 추가하지는 않는다.
         * 다만, 행과 열은 중복이 있으면 안된다. 왜냐하면 이미 정수를 삽입한 자리에 또 다른 정수가 들어갈 수도 있기 때문이다. 이를 위해 0이 들어있는 곳에만 정수를 삽입한다.
         * 0이 들어있는 곳이라는 것은, 초기화가 진행되고 정수가 한번도 삽입되지 않은 곳이기 때문이다. 정수는 1부터 10까지의 범위이므로 정수가 한번 삽입되면 0일 수가 없다.
         * 이를 통해 중복을 없애고, 만약 0이 아닌 다른 값이 들어있다면 중복이므로 i를 1 감소시켜 다시 삽입할 정수를 뽑게 된다.
         */
        for(int i = 0; i < 10; i++) {
            int num = random.nextInt(10) + 1;  //1부터 10까지의 수 중 랜덤하게 정수를 뽑는다.
            int index = random.nextInt(4);  //0부터 3 중 랜덤하게 뽑는데, 이는 intArray의 행 번호이다.
            int column = random.nextInt(4);  //0부터 3 중 랜덤하게 뽑는데, 이는 intArray의 열 번호이다.

            if(intArray[index][column] == 0)  //값이 0인 경우에만(한번도 정수가 삽입되지 않은 경우)
                intArray[index][column] = num;  //랜덤하게 뽑은 정수를 랜덤하게 뽑은 행과 열 번호에 삽입한다.
            else  //이미 정수가 삽입된 경우
                i--;  //다시 정수를 뽑아 삽입한다.
        }

        //배열 출력
        for(int i = 0; i < intArray.length; i++){
            for(int j = 0; j < intArray[i].length; j++) {
                System.out.print(intArray[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
