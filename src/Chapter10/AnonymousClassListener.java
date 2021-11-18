/*
 * [예제 10-3] 익명 클래스로 Action 이벤트 리스너 만들기
 * 익명 클래스 내에서 AnonymouusClassListener 클래스의 멤버나 JFrame의 멤버를 호출할 수 있다.
 */

package Chapter10;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AnonymousClassListener extends JFrame {
    // 생성자
    public AnonymousClassListener() {
        setTitle("Action 이벤트 리스너 작성");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JButton btn = new JButton("Action");  // 버튼 생성
        c.add(btn);

        // 익명 클래스로 Action 리스너 작성
        btn.addActionListener(new ActionListener() {
            // 예제 10-2에서 MyActionListener 클래스가 수행하던 코드와 동일
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton)e.getSource();
                if(b.getText().equals("Action"))
                    b.setText("액션");
                else
                    b.setText("Action");
                setTitle(b.getText());
            }
        });

        setSize(350, 150);
        setVisible(true);
    }

    public static void main(String [] args) {
        new AnonymousClassListener();
    }
}
