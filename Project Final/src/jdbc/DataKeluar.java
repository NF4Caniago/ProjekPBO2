package jdbc;
import java.sql.*;
public class DataKeluar extends DataMasuk {
    private String[][] data = new String[20][3];
    int tp = 0, p = 0 , x = 0 ; String[][] data2 = new String[20][9];
    private String[][] JalurKeluarTabel(){
        if(getkoneksi()==1){
            try{
                statement = koneksi.createStatement();
                resultset = statement.executeQuery("select * from data");
                while(resultset.next()){
                    data[p][0] = resultset.getString("Nama");
                    data[p][2] = resultset.getString("Alamat");
                    data[p][1] = resultset.getString("NEM");
                    p++;
                }
                statement.close();
                koneksi.close();
                return data; 
            }catch(SQLException ex){
                return data;
            }
        }else{
            return data;
        }
    }
    private String[][] JalurKeluarData(){
        if(getkoneksi()==1){
            try{
                statement = koneksi.createStatement();
                resultset = statement.executeQuery("select * from data");
                while(resultset.next()){
                    data2[x][0] = resultset.getString("Photo");
                    data2[x][1] = resultset.getString("Kelamin");
                    data2[x][2] = resultset.getString("Beasiswa");
                    data2[x][3] = resultset.getString("TTL");
                    data2[x][4] = resultset.getString("Ipa");
                    data2[x][5] = resultset.getString("Mtk");
                    data2[x][6] = resultset.getString("Indo");
                    data2[x][7] = resultset.getString("Ing");
                    data2[x][8] = resultset.getString("Telpon");
                    x++;
                }
                statement.close();
                koneksi.close();
                if(x==0){
                    data2[0][0] = "Error";
                    return data2;
                }else{
                    return data2; 
                }  
            }catch(SQLException ex){
                data2[0][0] = "Error";
                return data2;
            }
        }else{
            data2[0][0] = "Error";
            return data2;
        } 
    }
    private int TotalPendaftar(){
        if(getkoneksi()==1){
            try{
                statement = koneksi.createStatement();
                resultset = statement.executeQuery("select * from data");
                while(resultset.next()){
                    tp++;
                }
                statement.close();
                koneksi.close();
                return tp; 
            }catch(SQLException ex){
                return -1;
            }
        }else{
            return -1;
        }
    }
    public String[][] getJalurKeluarTabel(){
        return JalurKeluarTabel();
    }
    public String[][] getJalurKeluarData(){
        return JalurKeluarData();
    }
    public int getTotalPendaftar(){
        return TotalPendaftar();
    }
}
