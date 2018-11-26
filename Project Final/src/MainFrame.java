import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import jdbc.*;
public class MainFrame extends JFrame {
    JLabel Header = new JLabel(new ImageIcon(getClass().getResource("assets/Header.jpg")));
    JLabel Visi = new JLabel(new ImageIcon(getClass().getResource("assets/MainFrame.png")));
    JLabel Side = new JLabel(new ImageIcon(getClass().getResource("assets/Side.png")));
    
    JLabel JPeserta = new JLabel("0");
    JLabel InfoJP = new JLabel("Jumlah Pendaftar Saat ini");
    JPanel JP = new JPanel(new FlowLayout());
    JLabel InfoTop = new JLabel("NEM Tertinggi yang diterima");
    JLabel InfoButtom = new JLabel("NEM Terendah yang diterima");
    JPanel InfoP = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel IsiTop =  new JLabel("0");
    JLabel IsiButtom =  new JLabel("0");
    JPanel InfoN = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    
    JButton Login = new JButton("Login");
    JButton Cari = new JButton("Cari");
    JButton Daftar = new JButton("Daftar");
    String JTPeserta="",InfoMax="",InfoMin="";
    String[] Data = new String[20];
    public MainFrame(){
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

        
        //InfoPeserta
        add(JP);
        JP.add(JPeserta);JP.add(InfoJP);
        JP.setBounds(200, 290, 190, 120);
        JP.setOpaque(false);
        JPeserta.setFont(new Font("Arial Black", 1, 56));
        JPeserta.setForeground(Color.white);
        add(InfoP);
        InfoP.add(InfoTop); InfoP.add(InfoButtom);
        InfoJP.setForeground(Color.white);InfoTop.setForeground(Color.white);InfoButtom.setForeground(Color.white);
        InfoP.setBounds(190, 402, 200, 100);
        InfoP.setOpaque(false);
        add(InfoN);
        add(IsiTop); add(IsiButtom);
        IsiTop.setForeground(Color.white);IsiButtom.setForeground(Color.white);
        IsiTop.setLayout(new FlowLayout());
        IsiTop.setBounds(365, 405, 40, 20);
        IsiButtom.setLayout(new FlowLayout());
        IsiButtom.setBounds(365, 426, 40, 20);

        
        //Ambildata
        Posisi p = new Posisi();
        int jumlahPeserta = p.getTotalPendaftar();
        JTPeserta = ""+jumlahPeserta;
        Data = p.getNEMAB();
        if(JTPeserta.equals("-1")){
            JOptionPane.showMessageDialog(null, "Gagal Terhubung dengan DataBase!", "Koneksi Error", JOptionPane.ERROR_MESSAGE);
        }else{
            JPeserta.setText(JTPeserta);
        }
        if(InfoMax.equals("0")||InfoMin.equals("0")){
            JOptionPane.showMessageDialog(null, "Gagal Terhubung dengan DataBase!", "Koneksi Error", JOptionPane.ERROR_MESSAGE);
        }else{
            IsiTop.setText(Data[0]);
            if(jumlahPeserta > 0){
            IsiButtom.setText(Data[jumlahPeserta-1]);
            }
        }
       
        
        add(Visi);
        Visi.setBounds(100, 125, 400, 575);       
        //Tombol
        add(Daftar);add(Login);add(Cari);
        Daftar.setBounds(10,140,80,20);
        Login.setBounds(10,170,80,20);
        Cari.setBounds(10,200,80,20);
        add(Side);
        Side.setBounds(0, 125, 100, 575);
        
        //Aksi
        Daftar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                new DaftarUser().setVisible(true);dispose();
            }  
        });
        Login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new Login().setVisible(true);dispose();
            }
        });
        Cari.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new Cari().setVisible(true);dispose();
            }
        });
    }

    public static void main(String[]args){
        new MainFrame();
    }
}

