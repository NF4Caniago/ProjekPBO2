
import java.awt.*;
import java.io.*;import java.io.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import jdbc.*;
public class Daftar extends JFrame {
    JLabel Header = new JLabel(new ImageIcon(getClass().getResource("assets/Header.jpg")));
    JLabel Background = new JLabel(new ImageIcon(getClass().getResource("assets/Background.png")));
    JLabel Side = new JLabel(new ImageIcon(getClass().getResource("assets/Side.png")));
    JLabel Photo = new JLabel(new ImageIcon(getClass().getResource("assets/icon-profile.png"))); 
    JLabel Foto = new JLabel("Foto Profil Peserta");
    
    JLabel HeadForm = new JLabel("Input Data Calon Pesertadidik Baru");
    JLabel Aggr1 = new JLabel("Dengan ini saya menyatakan bahwa semua data yang saya");
    JLabel Aggr2 = new JLabel("isikan benar dan dapat dipertanggungjawabkan dimata hukum");
    JPanel Aggr = new JPanel( new FlowLayout());
    JLabel Aggr3 = new JLabel("Saya setuju");
    
    JLabel LNama = new JLabel("Nama");
    JLabel LTempat = new JLabel("Tempat Lahir");
    JLabel LKelamin = new JLabel("Jenis Kelamin");
    JLabel LBulan = new JLabel("Bulan Lahir");
    JLabel LBeasiswa = new JLabel("Beasiswa");
    JLabel LTanggal = new JLabel("Tanggal Lahir");
    JLabel LTelpon = new JLabel("Telepon");
    JLabel LAlamat = new JLabel("Alamat");
    JLabel LTahun = new JLabel("Tahun Lahir");
    JLabel LIPA = new JLabel("Nilai IPA");
    JLabel LMTK = new JLabel("Nilai MTK");
    JLabel LIndo = new JLabel("Nilai B.Indonesia");
    JLabel LIng = new JLabel("Nilai B.Inggris");
    String[] JKelamin = {"Laki Laki", "Perempuan"};
    String[] JBulan = {"Januari", "Februari", "Maret", "April", "Mei", 
        "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
    String[] JBeasiswa = {"Tidak ada", "KIP", "Bidikmisi", "Lainnya"};
    
    JTextField TFNama = new JTextField();
    JTextField TFTempat = new JTextField();
    JComboBox CBKelamin = new JComboBox(JKelamin);
    JComboBox CBBulan = new JComboBox(JBulan);
    JComboBox CBBeasiswa = new JComboBox(JBeasiswa);
    JTextField TFAlamat = new JTextField();
    JTextField TFTahun = new JTextField();
    JTextField TFTanggal = new JTextField();
    JTextField TFTelpon = new JTextField();
    JTextField TFIPA = new JTextField();
    JTextField TFMTK = new JTextField();
    JTextField TFIndo = new JTextField();
    JTextField TFIng = new JTextField();
    
    JPanel Form = new JPanel(new GridLayout(13,2));
    
    JButton Kembali = new JButton("Kembali");
    JButton Upload = new JButton("Upload Foto");
    JButton Simpan = new JButton("Simpan");
    JCheckBox Yes = new JCheckBox();

    Connection koneksi;
    Statement statement;
    ResultSet resultset;
    
    String Direktori = "H:/Temporary/Project/src/assets/icon-profile.png", Nama, Alamat, Username, Password, Kelamin, 
            Gol_Dar, Beasiswa,TTL, Umur, Telepon;
    Double NEM, MTK, IPA, IND, ING;
    JFileChooser FC;
    File FileTerpilih;
    ImageIcon icon;
    String TempK="", TempD="", TempJ="";
    public Daftar(){
        //Pengaturan Frame
        setTitle("Pendaftaran Pesertadidik Baru");
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
        HeadForm.setBounds(180, 140, 260, 20);
        add(Photo); add(Upload); add(Foto);
        Photo.setBounds(170, 180, 100, 130);Foto.setBounds(300, 220, 120, 20);
        Upload.setBounds(300, 250, 100, 20);
        add(Form);
        Form.add(LNama); Form.add(TFNama);
        Form.add(LTempat); Form.add(TFTempat);
        Form.add(LTanggal); Form.add(TFTanggal);
        Form.add(LBulan); Form.add(CBBulan);
        Form.add(LTahun); Form.add(TFTahun);
        Form.add(LKelamin); Form.add(CBKelamin);
        Form.add(LBeasiswa); Form.add(CBBeasiswa);
        Form.add(LAlamat); Form.add(TFAlamat);
        Form.add(LTelpon); Form.add(TFTelpon);
        Form.add(LMTK); Form.add(TFMTK);
        Form.add(LIPA); Form.add(TFIPA);
        Form.add(LIndo); Form.add(TFIndo);
        Form.add(LIng); Form.add(TFIng);
        Form.setBounds(150, 320, 300, 280);
        Form.setOpaque(false);
        add(Aggr);
        Aggr.add(Aggr1);Aggr.add(Aggr2);
        Aggr.setBounds(115, 590, 355, 45);
        Aggr.setOpaque(false);
        add(Aggr3);add(Yes);
        Yes.setBounds(180, 640, 20, 20);
        Yes.setOpaque(false);
        Aggr3.setBounds(210, 640, 80, 20);
        add(Simpan);
        Simpan.setBounds(300, 640, 80, 20);
        add(Background);
        Background.setBounds(100, 125, 400, 575);
        
        //Tombol
        
        add(Side);
        Side.setBounds(0, 125, 100, 575);
        
        //Aksi
        Kembali.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                new MainFrame().setVisible(true);dispose();
            }    
        });
        
        Upload.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                InsertPhoto();
            } 
        });
        Simpan.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                if(TFAlamat.getText().equals("") || TFTelpon.equals("") 
                    || TFNama.getText().equals("") || TFTempat.getText().equals("")
                    || TFTanggal.getText().equals("") || TFTahun.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Lengkapi Isian Terlebih Dahulu", "Error", JOptionPane.WARNING_MESSAGE);
                }else{
                    if(Yes.isSelected()){
                        InsertData();
                    }else{
                        JOptionPane.showMessageDialog(null, "Anda harus setuju dengan ketentuan yang ada!", "Peringatan!", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }            
        });
        
    }
    
    public void InsertData(){
        DataMasuk dm = new DataMasuk();
        olahdata.Nilai odata = new olahdata.Nilai();
        int x = CBKelamin.getSelectedIndex(), y = CBBulan.getSelectedIndex(), z = CBBeasiswa.getSelectedIndex();
        double DATA[][] = odata.setNilai(TFMTK.getText(), TFIPA.getText(), TFIndo.getText(),TFIng.getText());;
        if(DATA[0][0]==-1){
            JOptionPane.showMessageDialog(null, "Isikan Nilai dengan Angka!", "NumberFormat Error!", JOptionPane.ERROR_MESSAGE);
        }else{
            MTK = DATA[0][0];
            IPA = DATA[0][1];
            IND = DATA[0][2];
            ING = DATA[0][3]; 
            Kelamin = odata.getKelamin(x);
            TTL = TFTempat.getText()+", "+TFTanggal.getText()+" "+odata.getBulan(y)+" "+TFTahun.getText();
            Beasiswa = odata.getBeasiswa(z);
            NEM = odata.getNeM();
            int hasil = dm.getJalurMasukData(TFNama.getText(), TFAlamat.getText(),Kelamin, Beasiswa, TTL, Direktori,TFTelpon.getText(), MTK, IPA, IND, ING, NEM);
            if(hasil==1){
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!\nCobalah untuk login", "Hasil", JOptionPane.INFORMATION_MESSAGE);new MainFrame().setVisible(true);dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan", "Hasil", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void InsertPhoto(){
        FC = new JFileChooser();
        int pilihan = FC.showOpenDialog(null);
        if(pilihan == JFileChooser.APPROVE_OPTION){
            Direktori = FC.getSelectedFile().toString();
            Direktori = Direktori.replace("\\", "/");
            icon = new ImageIcon(Direktori);
            Photo.setIcon(icon);
        }
    }

}
