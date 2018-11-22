package jdbc;
 
import java.sql.*;
import javax.swing.JOptionPane;
public class DataMasuk extends konektivitas {
    Statement statement;
    ResultSet resultset;
    int x;
    private int JalurMasukData(String Nama, String Alamat, String Kelamin, String Beasiswa, String TTL, String Direktori, String Telpon, Double Mtk, Double Ipa, Double Indo, Double Ing, Double NEM){
        if(getkoneksi()==1){
            try{
                statement = koneksi.createStatement();
                statement.executeUpdate("insert into data values('"+Nama+"','"+Alamat+"','"+Kelamin+"','"+Beasiswa+"','"+TTL+"','"+Direktori+"','"+Telpon+"','"+Mtk+"','"+Ipa+"','"+Indo+"','"+Ing+"','"+NEM+"')");
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
    private int JalurMasukData(String User, String PW){
        if(getkoneksi()==1){
            try{
                statement = koneksi.createStatement();
                statement.executeUpdate("insert into pengguna values('"+User+"','"+PW+"')");
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
    
    public int getJalurMasukData(String Nama, String Alamat, String Kelamin, String Beasiswa, String TTL, String Direktori,String Telpon, Double Mtk,Double Ipa, Double Indo, Double Ing, Double NEM) {
        return JalurMasukData(Nama, Alamat, Kelamin, Beasiswa, TTL, Direktori,Telpon, Mtk, Ipa, Indo, Ing, NEM);
    }
    
    public int getJalurMasukData(String User, String PW){
        return JalurMasukData(User, PW);
    }
}
