/*
 * [과제 6번] 배치관리자 삭제와 임의의 위치에 컴포넌트 붙이기
 * 20개의 10x10 크기의 JLabel 컴포넌트가 프레임 내에 (50, 50) 위치에서 (250, 250) 영역에서 랜덤한 위치에 출력되도록 스윙 프로그램을 작성한다.
 * 프레임의 크기를 300x300으로 하고, JLabel의 배경색은 모두 파란색으로 한다.
 */

package Chapter9;
import java.awt.*;
import javax.swing.*;

public class Homework6 extends JFrame {
    public Homework6() {
        setTitle("Homework6 - Random Labels");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(null);  // 레이아웃은 설정하지 않음
        for(int i=0; i<20; i++){
            JLabel label = new JLabel();
            int x = (int)(Math.random()*200)+50;  // 50~250 사이의 수 선택(x좌표)
            int y = (int)(Math.random()*200)+50;  // 50~250 사이의 수 선택(y좌표)

            label.setLocation(x,y);  // 레이블을 뽑은 랜덤한 위치 (x,y)에 배치
            label.setBackground(Color.BLUE);  // 레이블의 색을 파란색으로 설정
            label.setSize(10,10); // label 크기를 10*10으로 설정
            container.add(label);  // 레이블 추가
            label.setOpaque(true); // 레이블에 배경색이 보이게 함
        }
        setSize(300,300);
    }

    public static void main(String[] args) {
        new Homework6();
    }
}
