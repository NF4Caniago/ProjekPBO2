package jdbc;
import java.sql.SQLException;

public class Posisi extends DataKeluar {
    private String[][] data = new String[20][3];
    int ps = 0, p = 0 , x = 0, i = 0 ; String[][] data2 = new String[20][9];
    String[] data3 = new String[20];
    private String[][] JalurKeluarTabelFIX(){
        if(getkoneksi()==1){
            try{
                statement = koneksi.createStatement();
                resultset = statement.executeQuery("select * from data order by NEM desc");
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
    private String[][] JalurKeluarDataFIX(){
        if(getkoneksi()==1){
            try{
                statement = koneksi.createStatement();
                resultset = statement.executeQuery("select * from data order by NEM desc");
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
    private int PosisiFIX(String Nama){
        if(getkoneksi()==1){
            try{
                statement = koneksi.createStatement();
                resultset = statement.executeQuery("select * from data order by NEM desc");
                while(resultset.next()){
                    if(Nama.equals(resultset.getString("Nama"))){
                        ps=i;
                    }
                    i++;
                }
                statement.close();
                koneksi.close();
                return ps; 
            }catch(SQLException ex){
                return 0;
            }
        }else{
            return 0;
        }
    }
    private String[] NEMAB(){
        if(getkoneksi()==1){
            try{
                statement = koneksi.createStatement();
                resultset = statement.executeQuery("select * from data order by NEM desc");
                while(resultset.next()){
                    data3[i] = resultset.getString("NEM");
                    i++;
                }
                statement.close();
                koneksi.close();
                return data3; 
            }catch(SQLException ex){
                data3[0]="0";
                return data3;
            }
        }else{
            data3[0]="0";
            return data3;
        }
    }
    public String[][] getJalurKeluarTabelFIX(){
        return JalurKeluarTabelFIX();
    }
    public String[][] getJalurKeluarDataFIX(){
        return JalurKeluarDataFIX();
    }
    public int getPosisi(String Nama){
        return PosisiFIX(Nama);
    }
    public String[] getNEMAB(){
        return NEMAB();
    }
}
