package jdbc;
import java.sql.*;
import javax.swing.JOptionPane;
public class UbahData extends konektivitas {
    Statement statement;
    ResultSet resultset;
    int x;
    private int JalurEditData(String Nama, String Alamat, String Kelamin, String Beasiswa, String TTL, String Direktori, String TelponBaru, Double Mtk, Double Ipa, Double Indo, Double Ing, Double Nem, String Telepon, String NamaLama){
        if(getkoneksi()==1){
            try{
                statement = koneksi.createStatement();
                statement.executeUpdate("UPDATE data SET Nama = '"+Nama+"',Alamat = '"+Alamat+"',Kelamin = '"+Kelamin+
                    "',Beasiswa = '"+Beasiswa+"',TTL = '"+TTL+"',Photo = '"+Direktori+"',Telpon = '"+TelponBaru+"',Mtk = '"+Mtk+
                    "',Ipa = '"+Ipa+"',Indo = '"+Indo+"',Ing = '"+Ing+"',NEM = '"+Nem+"' WHERE Nama = '"+NamaLama+"';");
                x = 1;
                statement.close();
                koneksi.close();
            }catch(SQLException ex){
                x = 0;
            }
            return x;
        }else{
            return 0;
        }
    } 
    public int getJalurEditData(String Nama, String Alamat, String Kelamin, String Beasiswa, String TTL, String Direktori,String TelponBaru, Double Mtk, Double Ipa, Double Indo, Double Ing, Double Nem,String Telepon, String NamaLama) {
        return JalurEditData(Nama, Alamat, Kelamin, Beasiswa, TTL, Direktori,TelponBaru,Mtk,Ipa,Indo,Ing,Nem,Telepon, NamaLama);
    }
}
