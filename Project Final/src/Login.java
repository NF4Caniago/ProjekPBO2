
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import jdbc.ProsesLogin;
public class Login extends JFrame {
    JLabel Header = new JLabel(new ImageIcon(getClass().getResource("assets/Header.jpg")));
    JLabel Background = new JLabel(new ImageIcon(getClass().getResource("assets/Background.png")));
    JLabel Side = new JLabel(new ImageIcon(getClass().getResource("assets/Side.png")));
    
    JLabel HeadForm = new JLabel("Login Calon Peserta didik Baru");
    JLabel LUser = new JLabel("Username");
    JLabel LPW = new JLabel("Password");
    JTextField TFUser = new JTextField();
    JPasswordField PFPW = new JPasswordField();
    JPanel Form = new JPanel(new GridLayout(2,2));
    
    JButton Kembali = new JButton("Kembali");
    JButton Login = new JButton("Login");
    
    Connection koneksi;
    Statement statement;
    ResultSet resultset;
    
    public Login(){
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
        
        add(HeadForm);
        HeadForm.setFont(new java.awt.Font("Arial", 1, 14));
        HeadForm.setBounds(180, 140, 300, 20);

        add(Form);
        Form.add(LUser); Form.add(TFUser);
        Form.add(LPW); Form.add(PFPW);
        Form.setBounds(150, 180, 300, 40);
        Form.setOpaque(false);
        add(Login);
        Login.setBounds(370, 230, 80, 20);
        add(Background);
        Background.setBounds(100, 125, 400, 575);
        
        //Tombol
        add(Kembali);
        Kembali.setBounds(10,200,80,20);
        add(Side);
        Side.setBounds(0, 125, 100, 575);
        
        //Aksi
        Kembali.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new MainFrame().setVisible(true);dispose();
            }
        });
        Login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
                if(TFUser.getText().equals("") && PFPW.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Isikan Username dan Password terlebih dahulu!","Gagal Login", JOptionPane.ERROR_MESSAGE);    
                }else if(TFUser.getText().equals("") || PFPW.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Isian belum lengkap!","Gagal Login", JOptionPane.ERROR_MESSAGE);
                    
                // diatas cek nullable textfield
                    
          
                }else{
                    ProsesLogin PL = new ProsesLogin();
                    int [][]hasil = PL.getLogin(TFUser.getText(), PFPW.getText());
                    int id = hasil[0][1]; 
                    if(hasil[0][0] == 2){
                        JOptionPane.showMessageDialog(null, "Selamat datang "+TFUser.getText()+"!", "Login Sukses!", JOptionPane.INFORMATION_MESSAGE);
                        new CabutAdmin(id, TFUser.getText()).setVisible(true); dispose();;
                    }else if(hasil[0][0] == 1){
                        JOptionPane.showMessageDialog(null, "Selamat datang "+TFUser.getText()+"!", "Login Sukses!", JOptionPane.INFORMATION_MESSAGE);
                        new CabutEdit(id, TFUser.getText()).setVisible(true); dispose();;
                    }
                    else if(hasil[0][0]==0){
                        JOptionPane.showMessageDialog(null, "Username Tidak Ditemukan", "Peringatan!", JOptionPane.ERROR_MESSAGE);
                        System.out.println(hasil[0][0]+"user tidak terdeteksi");
                    }else if(hasil[0][0]==-1){
                        JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada sambungan database!", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } 
        });
        
    }
    

}
