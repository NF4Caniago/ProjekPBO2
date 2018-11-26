package Encrypt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class controller implements ActionListener{
    main.gui gui;

    controller(main.gui gui){
        this.gui = gui;
        setSetting();
    }

    public controller() {
    
    }
    
    

    void setSetting(){
        setCenter();
        buttonListener();
        setTextAreaSetting();
        gui.setSize(1366, 768);
        gui.setLayout(null);
        gui.setDefaultCloseOperation(3);
        gui.setVisible(true);
    }

    void setTextAreaSetting(){
        Font font = gui.text.getFont();
        float size = font.getSize() + 10.0f;
        gui.text.setFont( font.deriveFont(size) );
    }
    void buttonListener(){
        gui.dec.addActionListener(this);
        gui.enc.addActionListener(this);
    }

    void setCenter(){
        // Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        int w = gui.getSize().width;
        int h = gui.getSize().height;
        int x = (dim.width-w)/2;
        int y = (dim.height-h)/2;

        // Move the window
        gui.setLocation(x - 683, y - 384);
    }

    int keyGen(){
        Random rand = new Random();
        return abs(rand.nextInt()) % 94 + 32;
    }

    void encrypt(){
        char[] text = gui.text.getText().toCharArray();
        int key = keyGen();
        for(int i = 0; i < text.length; i++){
            text[i] = (char)( (int) (text[i] + pow(key + i ,2)) % 94 + 32);
        }

        String enkripsi = new StringBuilder(new String(text)).reverse().toString();

        gui.text.setText("");
        gui.text.setText(enkripsi + (char) key + (char) keyGen());
    }
    
    
    public String encrypt(String kiriman){
        char[] text = kiriman.toCharArray();
        int key = keyGen();
        for(int i = 0; i < text.length; i++){
            text[i] = (char)( (int) (text[i] + pow(key + i ,2)) % 94 + 32);
        }

        String enkripsi = new StringBuilder(new String(text)).reverse().toString();
        
        String hEncryp="";
        hEncryp = enkripsi + (char) key + (char) keyGen();

        return hEncryp;
    }

    void decrypt(){
        char[] text = gui.text.getText().toCharArray();
        char[] temp = gui.text.getText().toCharArray();
        int key = text[text.length - 2];

        for(int i = 0; i < text.length - 2; i++){
            text[i] = temp[text.length - 3 - i];
        }

        for(int i = 0; i < text.length - 2; i++){
            int j = 31;
            char t = 0;

            do{
                j++;
                if((j >= 32 && j <=126)){
                    t = (char) ((int) (j + pow(key + i, 2)) % 94 + 32);
                }
            } while(!(t == text[i]));
            text[i] = (char) j ;
        }

        gui.text.setText("");

        for(int i = 0; i < text.length - 2; i++) gui.text.setText(gui.text.getText() + text[i]);
    }
    
    public String decrypt(String kiriman){
        char[] text = kiriman.toCharArray();
        char[] temp = kiriman.toCharArray();
        int key = text[text.length - 2];
        
        for(int i = 0; i < text.length - 2; i++){
            text[i] = temp[text.length - 3 - i];
        }

        for(int i = 0; i < text.length - 2; i++){
            int j = 31;
            char t = 0;

            do{
                j++;
                if((j >= 32 && j <=126)){
                    t = (char) ((int) (j + pow(key + i, 2)) % 94 + 32);
                }
            } while(!(t == text[i]));
            text[i] = (char) j ;
        }

        String hDecrypt="";

        for(int i = 0; i < text.length - 2; i++){ 
            hDecrypt = hDecrypt + text[i];
        }
        return hDecrypt;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
           if(ae.getSource() == gui.enc){
               encrypt();
           }
           
           if(ae.getSource() == gui.dec){
               decrypt();
           }
    
    }
}
