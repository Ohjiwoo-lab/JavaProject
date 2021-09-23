/*
 * [예제 4-6] CircleEx 객체 배열 만들기
 * 반지름이 0~4인 CircleEx 객체 5개를 가지는 배열을 생성하고, 배열에 있는 모든 CircleEx 객체의 면적을 출력하는 프로그램을 작성한다.
 */

package Chapter4;

class CircleEx {
    int radius;
    public CircleEx(int radius){
        this.radius = radius;
    }
    public double getArea(){
        return 3.14 * radius * radius;
    }
}

public class CircleArray {
    public static void main(String[] args){
        CircleEx[] c;  //CircleEx 배열에 대한 레퍼런스 변수 선언
        c = new CircleEx[5];  //CircleEx 객체 배열 생성

        for(int i = 0; i < c.length; i++)
            c[i] = new CircleEx(i);  //실제로 CircleEx 객체 생성(radius에 i(0~4)가 저장되면서 생성된다)

        for(int i = 0; i < c.length; i++)
            System.out.print((int)c[i].getArea() + " ");  //객체 배열 c의 인덱스를 변경하면서 각 객체의 getArea()를 호출 -> 각 객체마다 독자적인 getArea()를 가지므로 다 다른 값이 출력된다.
    }
}
