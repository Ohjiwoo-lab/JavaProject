/*
 * [예제 9-6] 배치관리자가 없는 컨테이너에 컴포넌트를 절대 위치와 크기로 지정하는 프로그램
 * 원하는 위치에 원하는 크기로 컴포넌트를 마음대로 배치할 수 있다.
 */

package Chapter9;
import javax.swing.*;
import java.awt.*;

public class NullContainerEx extends JFrame {
    public NullContainerEx() {  // 생성자
        setTitle("Null Container Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(null);  // 레이아웃이 null 값(아무런 레이아웃을 설정하지 않는다.)

        // 레이블 생성 후 위치와 크기 지정
        JLabel la = new JLabel("Hello, Press Buttons!");
        la.setLocation(130, 50);
        la.setSize(200, 20);
        c.add(la);  // 컨테이너에 추가

        for(int i=1; i<=9; i++) {
            // 버튼 생성 후 위치와 크기 지정
            JButton b = new JButton(Integer.toString(i));
            b.setLocation(i*15, i*15);
            b.setSize(50, 20);
            c.add(b);  // 버튼을 컨텐트팬에 부착
        }
        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new NullContainerEx();
    }
}
