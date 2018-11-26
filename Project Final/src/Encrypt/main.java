package Encrypt;

import javax.swing.*;
import java.awt.*;

public class main {
    public static void main(String[] args) {
        new controller(new gui());
    }

    static class gui extends JFrame{
        JTextArea text = new JTextArea(5,12);
        JButton dec = new JButton("Decrypt");
        JButton enc = new JButton("Encrypt");
        JScrollPane scrollPane = new JScrollPane(text);
        gui(){
            super("SECRET");
            setComponent();
            //setBg();
        }

        void setComponent(){
            scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            text.setLineWrap(true);
            text.setWrapStyleWord(true);
            text.setBounds(683 - 150, 384 - 150, 300, 300);
            add(text);

            add(scrollPane);

            dec.setBounds(683 - 150, 384 + 150, 150, 50);
            add(dec);

            enc.setBounds(683 , 384+ 150, 150, 50);
            add(enc);
        }

//        void setBg(){
//            ImageIcon image = new ImageIcon(getClass().getResource("image/bg.jpg"));
//            JLabel imagelabel = new JLabel(image);
//            imagelabel.setBounds(0,0, 1366, 768);
//            add(imagelabel);
//        }

    }
}
