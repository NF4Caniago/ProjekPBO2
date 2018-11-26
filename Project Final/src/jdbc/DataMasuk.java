package jdbc;
 
import java.sql.*;
import javax.swing.JOptionPane;
import Encrypt.controller;
import javax.sound.midi.ControllerEventListener;
public class DataMasuk extends konektivitas {
    Statement statement;
    ResultSet resultset;
    controller cntrl = new controller();
    
    int x;
    private int JalurMasukData(String Nama, String Alamat, String Kelamin, String Beasiswa, String TTL, String Direktori, String Telpon, Double Mtk, Double Ipa, Double Indo, Double Ing, Double NEM){
        if(getkoneksi()==1){
            try{
                statement = koneksi.createStatement();
                statement.executeUpdate("insert into data ( `Nama`, `Alamat`, `Kelamin`, `Beasiswa`, `TTL`, `Photo`, `Telpon`, `Mtk`, `Ipa`, `Indo`, `Ing`, `NEM`) values('"+Nama+"','"+Alamat+"','"+Kelamin+"','"+Beasiswa+"','"+TTL+"','"+Direktori+"','"+Telpon+"','"+Mtk+"','"+Ipa+"','"+Indo+"','"+Ing+"','"+NEM+"')");
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
        String CUser = User, CPW = PW;
        
        CUser = cntrl.encrypt(CUser);
        CPW = cntrl.encrypt(CPW);
        
        if(getkoneksi()==1){
            try{
                statement = koneksi.createStatement();
                statement.executeUpdate("insert into pengguna (`User`, `PW`) values('"+CUser+"','"+CPW+"')");
                x = 1;
                statement.close();
                koneksi.close();
            }catch(SQLException ex){
                System.out.println(""+ex);
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
