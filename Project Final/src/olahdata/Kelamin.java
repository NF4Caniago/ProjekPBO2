package olahdata;
public class Kelamin extends Bulan{
    private String Kelamin="";
    private String Kelamin(int x){
        if(x==0){
            Kelamin="Laki - Laki";
        }else if(x==1){
            Kelamin="Perempuan";
        }
        return Kelamin;
    }
    public String getKelamin(int x){
        return Kelamin(x);
    }
}
