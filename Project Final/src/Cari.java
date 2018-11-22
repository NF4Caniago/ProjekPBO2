

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import jdbc.*;
public class Cari extends JFrame {
    JLabel Header = new JLabel(new ImageIcon(getClass().getResource("assets/Header.jpg")));
    JLabel Background = new JLabel(new ImageIcon(getClass().getResource("assets/Background.png")));
    JLabel Side = new JLabel(new ImageIcon(getClass().getResource("assets/Side.png")));
    JLabel Photo = new JLabel(new ImageIcon(getClass().getResource("assets/icon-profile.png"))); 
    
    JLabel HeadForm = new JLabel("Data Calon Pesertadidik Baru");
    
    JLabel LNISN = new JLabel("NISN");
    JLabel LNama = new JLabel("Nama");
    JLabel LKelamin = new JLabel("Jenis Kelamin");
    JLabel LIPA = new JLabel("Nilai IPA");
    JLabel LMTK = new JLabel("Nilai MTK");
    JLabel LIndo = new JLabel("Nilai B.Indonesia");
    JLabel LIng = new JLabel("Nilai B.Inggris");
    JLabel LAlamat = new JLabel("Alamat");
    JLabel LTelepon = new JLabel("No.Telepon");
    JLabel LBeasiswa = new JLabel("Beasiswa");
    JLabel LTTL = new JLabel("Tempat, Tanggal Lahir");
    
    JTextField TFNISN = new JTextField();
    JTextField TFNama = new JTextField();
    JTextField TFKelamin = new JTextField();
    JTextField TFIPA = new JTextField();
    JTextField TFMTK = new JTextField();
    JTextField TFIndo = new JTextField();
    JTextField TFIng = new JTextField();
    JTextField TFAlamat = new JTextField();
    JTextField TFTelepon = new JTextField();
    JTextField TFBeasiswa = new JTextField();
    JTextField TFTTL = new JTextField();
    
    JPanel Form = new JPanel(new GridLayout(10,2));
   
    JButton Kembali = new JButton("Kembali");

    JTable tabel;
    JScrollPane scrollpane;
    String[][]data = new String[20][4];
    String[][]data2 = new String[20][9];
    int p = 0;
    String TempD="";
    String Link="";
    String[] kolom = {"Nama", "NEM", "Alamat"};
    Connection koneksi;
    Statement statement;
    ResultSet resultset;
    Image icon;
    public Cari(){
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
        //Form
        add(HeadForm);
        HeadForm.setFont(new java.awt.Font("Arial", 1, 14));
        HeadForm.setBounds(200, 140, 260, 20);
        add(Photo);
        Photo.setBounds(110, 180, 100, 130);
        add(Form);
        Form.add(LNama); Form.add(TFNama);
        Form.add(LKelamin); Form.add(TFKelamin);
        Form.add(LIPA); Form.add(TFIPA);
        Form.add(LMTK); Form.add(TFMTK);
        Form.add(LIndo); Form.add(TFIndo);
        Form.add(LIng); Form.add(TFIng);
        Form.add(LBeasiswa); Form.add(TFBeasiswa);
        Form.add(LTTL); Form.add(TFTTL);
        Form.add(LAlamat); Form.add(TFAlamat);
        Form.add(LTelepon); Form.add(TFTelepon);
        
        TFNISN.setEditable(false);
        TFNama.setEditable(false);
        TFKelamin.setEditable(false);
        TFAlamat.setEditable(false);
        TFBeasiswa.setEditable(false);
        TFTTL.setEditable(false);
        TFIPA.setEditable(false);
        TFMTK.setEditable(false);
        TFIndo.setEditable(false);
        TFIng.setEditable(false);
        TFTelepon.setEditable(false);
        Form.setBounds(220, 170, 270, 180);
        Form.setOpaque(false);
        Posisi p = new Posisi();
        DataKeluar o = new DataKeluar();
        data = p.getJalurKeluarTabelFIX();
        data2 = p.getJalurKeluarDataFIX();
        tabel = new JTable(data,kolom);
        if(data2[0][0].equals("Error")){
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan sambungan DataBase!", "Koneksi Error", JOptionPane.ERROR_MESSAGE);
        }else{
            scrollpane = new JScrollPane(tabel);
            tabel.addMouseListener(new java.awt.event.MouseAdapter(){
                public void mouseClicked(MouseEvent evt) {
                    int baris = tabel.getSelectedRow();
                    TFNama.setText((String)tabel.getValueAt(baris, 0));
                    TFAlamat.setText((String)tabel.getValueAt(baris, 2));
                    TFKelamin.setText(data2[baris][1]);
                    TFBeasiswa.setText(data2[baris][2]);
                    TFTTL.setText(data2[baris][3]);
                    ImageIcon icon = new ImageIcon(data2[baris][0]);
                    Photo.setIcon(icon);
                    TFIPA.setText(data2[baris][4]);
                    TFMTK.setText(data2[baris][5]);
                    TFIndo.setText(data2[baris][6]);
                    TFIng.setText(data2[baris][7]);
                    TFTelepon.setText(data2[baris][8]);
                }
            });
            tabel.setDefaultRenderer(Object.class, new redblock());
            add(scrollpane);
            scrollpane.setBounds(120, 400, 340, 200);
        }
        add(Background);
        Background.setBounds(100, 125, 400, 575);
    
        
        
        //Tombol
        add(Kembali);
        Kembali.setBounds(10,200,80,20);
        add(Side);
        Side.setBounds(0, 125, 100, 575);
        
        //Aksi
        Kembali.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                new MainFrame().setVisible(true);dispose();
            }    
        });
        

    }
//    public static void main(String[]args){
//        new Cari();
//    }
}
