package olahdata;
public class Nilai extends Kelamin {
    private double NEM=0;
    private double MTK, IPA, IND, ING;
    private double[][] DATA = new double[1][4];
    public double[][] setNilai(String MTK, String IPA, String IND, String ING){
        try{
            this.MTK = Double.parseDouble(MTK);
            this.IPA = Double.parseDouble(IPA);
            this.IND = Double.parseDouble(IND);
            this.ING = Double.parseDouble(ING);
            DATA[0][0] = this.MTK;
            DATA[0][1] = this.IPA;
            DATA[0][2] = this.IND;
            DATA[0][3] = this.ING;
            return DATA;
        }catch(NumberFormatException nfe){
            DATA[0][0] = -1;
            return DATA;
        }
    }
    private double NeM(){
        return NEM = MTK+IPA+IND+ING;
    }
    public double getNeM(){
        return NeM();
    }
}
