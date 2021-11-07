/*
 * [과제 2번] 컨텐트 팬과 BorderLayout 배치관리자의 활용
 * BorderLayout을 사용하여 컴포넌트 사이의 수평 수직 간격이 각각 5픽셀, 7픽셀이 되도록 스윙 응용프로그램을 작성한다.
 */

package Chapter9;
import javax.swing.*;
import java.awt.*;

public class Homework2 extends JFrame {
    public Homework2() {  // 생성자
        setTitle("Homework2 - BorderLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new BorderLayout(5, 7));  // 레이아웃 설정(수평 간격 5픽셀, 수직 간격 7픽셀로 설정)

        // 버튼 생성
        container.add(new JButton("Center"), BorderLayout.CENTER);
        container.add(new JButton("North"), BorderLayout.NORTH);
        container.add(new JButton("South"), BorderLayout.SOUTH);
        container.add(new JButton("East"), BorderLayout.EAST);
        container.add(new JButton("West"), BorderLayout.WEST);

        setSize(300, 200); // 프레임 크기 300×200 설정
        setVisible(true); // 프레임을 화면에 출력
    }

    public static void main(String[] args) {
        new Homework2();
    }
}