
package jdbc;
import java.sql.*;
public class konektivitas {
    public Connection koneksi;
    int x;
    private String url ="jdbc:mysql://localhost/pbo";
    private String user ="root";
    private String pw = "";
    private int koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            koneksi=DriverManager.getConnection(url,user,pw);
            x = 1;
        } catch (SQLException t) {
            x = 0;
        }
        catch(ClassNotFoundException ex){
            x = 0;
        }
        return x;
    }
    public int getkoneksi(){
        return koneksi();
    }
    public static void main(String[]args){
        new konektivitas().getkoneksi();
    }
}
