/*
 * [예제 10-1] 독립 클래스로 Action 이벤트의 리스너 작성
 * 버튼을 클릭하면 버튼의 레이블 글자가 'Action'에서 '액션'으로 변경되는 프로그램을 작성한다.
 */

package Chapter10;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class MyActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton)e.getSource();  // 버튼 가져오기
        if(b.getText().equals("Action"))  // 텍스트가 'Action'이면 '액션'으로 변경
            b.setText("액션");
        else  // 텍스트가 '액션'이면 'Action'으로 변경
            b.setText("Action");
    }
}

public class IndepClassListener extends JFrame {
    public IndepClassListener() {    // 생성자
        setTitle("Action 이벤트 리스너 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JButton btn = new JButton("Action");  // 버튼 생성
        btn.addActionListener(new MyActionListener()); // Action 리스너 달기
        c.add(btn);
        setSize(350, 150);
        setVisible(true);
    }

    public static void main(String [] args) {
        new IndepClassListener();
    }
}
