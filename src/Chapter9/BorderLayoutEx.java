/*
 * [예제 9-4] BorderLayout 배치관리자를 사용하는 예시
 * BorderLayout 배치관리자를 사용하여 컨텐트 팬에 다음과 같이 5개의 버튼 컴포넌트를 삽입하는 코드를 작성한다.
 */

package Chapter9;
import javax.swing.*;
import java.awt.*;

public class BorderLayoutEx extends JFrame {
    public BorderLayoutEx() {  // 생성자
        setTitle("BorderLayout Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout(30, 20));  // 레이아웃 설정(수평 간격 30, 수직 간격 20으로 설정)

        // 버튼 생성
        c.add(new JButton("Calculate"), BorderLayout.CENTER);
        c.add(new JButton("add"), BorderLayout.NORTH);
        c.add(new JButton("sub"), BorderLayout.SOUTH);
        c.add(new JButton("mul"), BorderLayout.EAST);
        c.add(new JButton("div"), BorderLayout.WEST);

        setSize(300, 200); // 프레임 크기 300×200 설정
        setVisible(true); // 프레임을 화면에 출력
    }

    public static void main(String[] args) {
        new BorderLayoutEx();
    }

}
