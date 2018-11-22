package jdbc;
import java.sql.*;
public class LoginUser extends konektivitas {
    Statement statement;
    ResultSet resultset;
    int[][] x = new int [1][2];
    int i = 0,p;
    boolean ada= false; // cek adanya user
    String[][] data = new String[50][2];
    private int[][] Login(String User, String PW){
       if(getkoneksi()==1){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                koneksi = DriverManager.getConnection("jdbc:mysql://localhost/pbo", "root", "");
                statement = koneksi.createStatement();
                resultset = statement.executeQuery("select * from pengguna");
                while(resultset.next()){
                    data[i][0]= resultset.getString("User");
                    data[i][1]=resultset.getString("PW");
                    i++;
                }
                
//                if((User.equals(resultset.getString("User"))&& PW.equals(resultset.getString("PW")))){
                
                for(int i=0; i<this.i; i++){
                    if(data[i][0].equals(User) && data[i][1].equals(PW)){
                        x[0][0]=1;
                        x[0][1]=i;
                        
                        if(data[i][0].equals("admin") && data[i][1].equals("admin")){
                            x[0][0] = 2;          
                    }
                    }
                  
                }
                
                
                
                if( (x[0][0]!= 1) && (x[0][0] != 2)){
                    x[0][0] = 0;
                    return x;
                }
                statement.close();
                koneksi.close();
            }catch(SQLException ex){
                x[0][0] = -1;
                return x;
            } catch(ClassNotFoundException ex){
                x[0][0] = -1;
                return x;
            }
            return x;
        }else{
            x[0][0] = 0;
            return x;
        }
    }
    
    private int Cek_User(String User){
         if(getkoneksi()==1){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                koneksi = DriverManager.getConnection("jdbc:mysql://localhost/pbo", "root", "");
                statement = koneksi.createStatement();
                resultset = statement.executeQuery("select * from pengguna");
                while(resultset.next()){
                    if((User.equals(resultset.getString("User")))){
                        p=1;
                    }
                }
                if(p!=1){
                    p = 0;
                }
                statement.close();
                koneksi.close();
            }catch(SQLException ex){
                return 0;
            } catch(ClassNotFoundException ex){
                return 0;
            }
            return p;
        }else{
             return 0;
        }
    }
    
    public int[][] getLogin(String User, String PW){
        return Login(User, PW);
    }
    
    public int getUser(String User){
        return Cek_User(User);
    }
   
}
