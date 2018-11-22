package olahdata;
public class Beasiswa {
    private String Beasiswa="";
    private String Beasiswa(int x){
        if(x==0){
            Beasiswa="Tidak ada";
        }else if(x==1){
            Beasiswa="KIP";
        }else if(x==2){
            Beasiswa="Bidikmisi";
        }else if(x==3){
            Beasiswa="Lainnya";
        }
        return Beasiswa;
    }
    public String getBeasiswa(int x){
        return Beasiswa(x);
    }
}    
