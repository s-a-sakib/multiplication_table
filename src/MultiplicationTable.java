import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.RED;

public class MultiplicationTable extends JFrame {
    private Container c;
    private JLabel imgLabel , textLabel;
    private JTextArea ta;
    private JTextField tf;
    private JButton clearButton;
    private ImageIcon img;
    private Font f;
    private Cursor cursor;

    MultiplicationTable(){
        f = new Font("Tahoma",Font.BOLD + Font.ITALIC,20);
        cursor = new Cursor(Cursor.HAND_CURSOR);
        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.PINK);

        img = new ImageIcon(getClass().getResource("kids playing.png"));
        imgLabel = new JLabel(img);
        imgLabel.setBounds(5,0,img.getIconWidth(),img.getIconHeight());
        c.add(imgLabel);

        textLabel = new JLabel("Enter any number :");
        textLabel.setBounds(20,190,250,50);
        textLabel.setFont(f);
        textLabel.setForeground(Color.magenta);
        c.add(textLabel);

        tf = new JTextField();
        tf.setBounds(255,190,90,50);
        tf.setBackground(Color.green);
        tf.setHorizontalAlignment(JTextField.CENTER);
        c.add(tf);

        clearButton = new JButton("clear");
        clearButton.setBounds(255,260,90,50);
        clearButton.setBackground(Color.green);
        clearButton.setCursor(cursor);
        //clearButton.setFont(f);
        c.add(clearButton);

        ta = new JTextArea();
        ta.setBounds(10,320,340,340);
        ta.setBackground(Color.green);
        ta.setFont(f);
        ta.setForeground(Color.black);
        c.add(ta);

        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = tf.getText();
                if(value.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please input a number");
                }else {
                    ta.setText("");
                    int num = Integer.parseInt(tf.getText());
                    for (int i = 1; i <= 10; i++) {
                        int result = num * i;

                        String r = String.valueOf(result);
                        String n = String.valueOf(num);
                        String incr = String.valueOf(i);

                        ta.append(n + " X " + incr + " = " + r + "\n");
                    }
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ta.setText("");
                tf.setText("");
            }
        });


    }

    public static void main(String[] args) {
        MultiplicationTable frame = new MultiplicationTable();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
        frame.setBounds(30,20,360,700);
        frame.setTitle("Multiplication Table");
    }
}
