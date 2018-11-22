package olahdata;
public class Bulan extends Beasiswa {
    private String Bulan="";
    private String Bulan(int x){
        if(x==0){
            Bulan="Januari";
        }else if(x==1){
            Bulan="Februari";
        }else if(x==2){
            Bulan="Maret";
        }else if(x==3){
            Bulan="April";
        }else if(x==4){
            Bulan="Mei";
        }else if(x==5){
            Bulan="Juni";
        }else if(x==6){
            Bulan="Juli";
        }else if(x==7){
            Bulan="Agustus";
        }else if(x==8){
            Bulan="September";
        }else if(x==9){
            Bulan="Oktober";
        }else if(x==10){
            Bulan="November";
        }else if(x==11){
            Bulan="Desember";
        }
        return Bulan;
    }
    public String getBulan(int x){
        return Bulan(x);
    }
}
   
