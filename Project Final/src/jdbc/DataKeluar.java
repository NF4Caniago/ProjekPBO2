package jdbc;
import java.sql.*;
public class DataKeluar extends DataMasuk {
    private String[][] data = new String[20][3];
    int tp = 0, p = 0 , x = 0 ; 
    
    String[][] data2 = new String[1][13]; // penampung data dari tabel data
    
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
    private String[][] JalurKeluarData(int id){
        if(getkoneksi()==1){
            try{
                
                String SQL = "select * from data where id="+id+";";
                
                statement = koneksi.createStatement();
                resultset = statement.executeQuery(SQL);
                
                    data2[x][0] = resultset.getString("id");
                    data2[x][1] = resultset.getString("nama");
                    data2[x][2] = resultset.getString("alamat");
                    data2[x][3] = resultset.getString("kelamin");
                    data2[x][4] = resultset.getString("beasiswa");
                    data2[x][5] = resultset.getString("ttl");
                    data2[x][6] = resultset.getString("photo");
                    data2[x][7] = resultset.getString("telpon");
                    data2[x][8] = resultset.getString("mtk");
                    data2[x][9] = resultset.getString("ipa");
                    data2[x][10] = resultset.getString("Indo");
                    data2[x][11] = resultset.getString("Ing");
                    data2[x][12] = resultset.getString("nem");
 
                statement.close();
                koneksi.close();
               
                    return data2; 
                 
            }catch(SQLException ex){
                data2[0][0] = "Error";
                System.out.println("salah SQL");
                return data2;
            }
        }else{
            data2[0][0] = "Error";
            return data2;
        } 
    }
    
    
//     private String[][] JalurKeluarData(int id){
//        if(getkoneksi()==1){
//            try{
//                statement = koneksi.createStatement();
//                resultset = statement.executeQuery("select * from data where id='"+id+"'");
//                while(resultset.next()){
//                    data2[x][0] = resultset.getString("Photo");
//                    data2[x][1] = resultset.getString("Kelamin");
//                    data2[x][2] = resultset.getString("Beasiswa");
//                    data2[x][3] = resultset.getString("TTL");
//                    data2[x][4] = resultset.getString("Ipa");
//                    data2[x][5] = resultset.getString("Mtk");
//                    data2[x][6] = resultset.getString("Indo");
//                    data2[x][7] = resultset.getString("Ing");
//                    data2[x][8] = resultset.getString("Telpon");
//                    x++;
//                }
//                statement.close();
//                koneksi.close();
//                if(x==0){
//                    data2[0][0] = "Error";
//                    return data2;
//                }else{
//                    return data2; 
//                }  
//            }catch(SQLException ex){
//                data2[0][0] = "Error";
//                return data2;
//            }
//        }else{
//            data2[0][0] = "Error";
//            return data2;
//        } 
//    }
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
    public String[][] getJalurKeluarData(int id){
        return JalurKeluarData(id);
    }
    public int getTotalPendaftar(){
        return TotalPendaftar();
    }
}
