package jdbc;
import java.sql.*;
import javax.swing.JOptionPane;
public class HapusData extends konektivitas {
    Statement statement;
    ResultSet resultset;
    int x;
    private int HapusData(String Nama, String NISN){
        if(getkoneksi()==1){
            try{
                statement = koneksi.createStatement();
                statement.execute("DELETE FROM data WHERE Nama = '"+Nama+"'");
                statement.execute("DELETE FROM pengguna WHERE User = '"+NISN+"'");
                statement.close();
                koneksi.close();
                x=1;
            }catch(SQLException ex){
                x= 0;
            }
                return x;
        }else{
            return 0;
        }
    }
    
    public int getHaputData(String Nama, String NISN){
        return HapusData(Nama, NISN);
    }
}
