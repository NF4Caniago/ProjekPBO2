


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.*;
import javax.swing.*;
import jdbc.*;
import olahdata.Beasiswa;
import olahdata.Bulan;
import olahdata.Kelamin;
import olahdata.Nilai;

public class CabutEdit extends JFrame {
    JLabel Header = new JLabel(new ImageIcon(getClass().getResource("assets/Header.jpg")));
    JLabel Background = new JLabel(new ImageIcon(getClass().getResource("assets/Background.png")));
    JLabel Side = new JLabel(new ImageIcon(getClass().getResource("assets/Side.png")));
    JLabel Photo = new JLabel(new ImageIcon(getClass().getResource("assets/icon-profile.png"))); 
    
    JLabel HeadForm = new JLabel("Data Calon Peserta didik Baru");
    
    JLabel LNISN = new JLabel("Username");
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
    JLabel Keterangan = new JLabel("Posisi Anda Masih Aman");
    
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
    
    JPanel Form = new JPanel(new GridLayout(11,2));
    
    JButton Edit = new JButton("Edit");
    JButton Kembali = new JButton("Keluar");
    JButton Simpan = new JButton("Simpan");
    JButton Upload = new JButton("Upload Foto");
    
    String[][]data = new String[20][4];
    String[][]data2 = new String[20][9];
    String[][]data3 = new String[20][3];
    int p = 0;
    String TempD="";
    String Link="";
    
    
    JTable tabel;
    JScrollPane scrollpane;
    String[] kolom = {"Nama", "NEM", "Alamat"};
    Connection koneksi;
    Statement statement;
    ResultSet resultset;
    Image icon;
    String Direktori,Kelamin,Beasiswa,TTL, Telepon, Telep, NamaLama;
    Double NEM, MTK, IPA, IND, ING;
    JFileChooser FC;
    File FileTerpilih;
    ImageIcon Icon;
    int baris, status = 0;
    public CabutEdit(int b, String N){
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
        add(Photo);add(Upload);
        Photo.setBounds(110, 180, 100, 130);
        Upload.setBounds(110, 330, 100, 20);
        add(Form);
        Form.add(LNISN); Form.add(TFNISN);
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

        Form.setBounds(220, 170, 270, 180);
        Form.setOpaque(false);
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
        Posisi p = new Posisi();
        data = p.getJalurKeluarTabel();
        data2 = p.getJalurKeluarData();
        
        Load();
        scrollpane = new JScrollPane(tabel);
        if(data2[0][0].equals("Error")){
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan sambungan DataBase!", "Koneksi Error", JOptionPane.ERROR_MESSAGE);
        }
                baris=b;
                TFNISN.setText(N);
                TFNama.setText(data[baris][0]);
                TFAlamat.setText(data[baris][2]);
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
                try{ NEM= Double.parseDouble(data[baris][1]);}
                catch(Exception e){}
                int zona = p.getPosisi(TFNama.getText());
                if(zona > 9 && baris<=14){
                    Keterangan.setText("Posisi anda kurang aman!! Siap siap cabut data!");
                }else if(zona>14){
                    Keterangan.setText("Anda berada pada zona merah! Segera cabut data!");
                    Keterangan.setForeground(Color.decode("#D80000"));
                }
               
            
        //Tombol
        add(Kembali);add(Edit);
        add(Simpan);add(Upload);add(Keterangan);
        Keterangan.setLayout(new FlowLayout());
        Keterangan.setBounds(130,380,300,20);
        Edit.setBounds(120,420,80,20);
        Simpan.setBounds(320,420,80,20);
        Kembali.setBounds(10,140,80,20);
        tabel.setDefaultRenderer(Object.class, new redblock());
        add(scrollpane);
        scrollpane.setBounds(120, 450, 340, 200);
        add(Side);
        Side.setBounds(0, 125, 100, 575);
         add(Background);
        Background.setBounds(100, 125, 400, 575);
        
        //Aksi
        Kembali.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                new MainFrame().setVisible(true);dispose();
            }    
        });
        Edit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                TFNama.setEditable(true);
                TFKelamin.setEditable(true);
                TFAlamat.setEditable(true);
                TFBeasiswa.setEditable(true);
                TFTTL.setEditable(true);
                TFTelepon.setEditable(true);
                NamaLama = TFNama.getText();
                status = 1;
            }    
        });
        
        Simpan.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                EditData();
                status=0;
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
                Load();
                new CabutEdit(baris,TFNISN.getText()).setVisible(true);dispose();
            }    
        });
        Upload.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if(status==1){
                    InsertPhoto();
                }else{
                    
                }
            } 
        });

    }
    
    public void EditData(){
        UbahData u = new UbahData();
        Kelamin = TFKelamin.getText();
        TTL = TFTTL.getText();
        Beasiswa = TFBeasiswa.getText();
        olahdata.Nilai odata = new olahdata.Nilai();
        double DATA[][] = odata.setNilai(TFMTK.getText(), TFIPA.getText(), TFIndo.getText(),TFIng.getText());;
        MTK = DATA[0][0]; IPA = DATA[0][1]; IND = DATA[0][2]; ING = DATA[0][3]; 
        int hasil = u.getJalurEditData(TFNama.getText(), TFAlamat.getText(),Kelamin, Beasiswa, TTL, Direktori,TFTelepon.getText(), MTK, IPA, IND, ING, NEM,Telepon, NamaLama);
        if(hasil==1){
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan", "Hasil", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void InsertPhoto(){
        FC = new JFileChooser();
        int pilihan = FC.showOpenDialog(null);
        if(pilihan == JFileChooser.APPROVE_OPTION){
            Direktori = FC.getSelectedFile().toString();
            Direktori = Direktori.replace("\\", "/");
            Icon = new ImageIcon(Direktori);
            Photo.setIcon(Icon);
        }
    }
    
    public void Load(){
        Posisi p = new Posisi();
        data3 = p.getJalurKeluarTabelFIX();
        tabel = new JTable(data3,kolom);
    }
    
    public void Delete(){
        HapusData HD =  new HapusData();
        int hasil = HD.getHaputData(TFNama.getText(), TFNISN.getText());
        if(hasil==1){
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus", "Hasil", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
