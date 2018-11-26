import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import jdbc.DataMasuk;
public class DaftarUser extends JFrame {
    JLabel Header = new JLabel(new ImageIcon(getClass().getResource("assets/Header.jpg")));
    JLabel Background = new JLabel(new ImageIcon(getClass().getResource("assets/Background.png")));
    JLabel Side = new JLabel(new ImageIcon(getClass().getResource("assets/Side.png")));
    
    JLabel HeadForm = new JLabel("Daftar Calon Peserta didik Baru");
    JLabel LInfo = new JLabel("");
    JLabel LUser = new JLabel("Username");
    JLabel LPW = new JLabel("Password");
    JTextField TFUser = new JTextField();
    JPasswordField PFPW = new JPasswordField();
    JPanel Form = new JPanel(new GridLayout(2,2));
    
    JButton Kembali = new JButton("Kembali");
    JButton Daftar = new JButton("Daftar");
    
    
    Connection koneksi;
    Statement statement;
    ResultSet resultset;
    
    public DaftarUser(){
        //Pengaturan Frame
        setTitle("Pendaftaran Peserta didik Baru");
        setSize(500,700);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        //Background Head x Visi
        add(Header);
        Header.setBounds(0, 0, 500, 125);       
        
        //
        add(HeadForm);
        HeadForm.setFont(new java.awt.Font("Arial", 1, 14));
        HeadForm.setBounds(180, 140, 300, 20);
        add(LInfo);
        LInfo.setBounds(150, 180, 200, 20);
        add(Form);
        Form.add(LUser); Form.add(TFUser);
        Form.add(LPW); Form.add(PFPW);
        Form.setBounds(150, 200, 300, 40);
        Form.setOpaque(false);
        add(Daftar);
        Daftar.setBounds(370, 250, 80, 20);
        add(Background);
        Background.setBounds(100, 125, 400, 575);
        
        
        //Tombol
        add(Kembali);
        Kembali.setBounds(10,200,80,20);
        add(Side);
        Side.setBounds(0, 125, 100, 575);
        
        //Aksi
        Daftar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                if(TFUser.getText().equals("") || PFPW.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Lengkapi Isian Terlebih Dahulu", "Peringatan!", JOptionPane.WARNING_MESSAGE);
                }else{
                    jdbc.ProsesLogin lg = new jdbc.ProsesLogin();
                    int status = lg.getUser(TFUser.getText());
                    if(status == 1){
                        JOptionPane.showMessageDialog(null, "Username sudah ada", "Peringatan!", JOptionPane.WARNING_MESSAGE);
                    }else{
                        daftaruser(); 
                    }
                    
                }
                
            }  
        });
        Kembali.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new MainFrame().setVisible(true);dispose();
            }
        });
        
    }
    
    public void daftaruser(){
        DataMasuk dm = new DataMasuk();
        int hasil = dm.getJalurMasukData(TFUser.getText(), PFPW.getText());
        if(hasil==1){
            JOptionPane.showMessageDialog(null, "Selamat Anda Terdaftar", "Hasil", JOptionPane.INFORMATION_MESSAGE);
            new Daftar().setVisible(true);dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Isi Username atau Password Terlebih dahulu", "Hasil", JOptionPane.ERROR_MESSAGE);
            System.out.println("daftaruser error");
        }
    }
}
