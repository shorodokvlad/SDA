package cutii;
public interface ICutie {
    public static double pretUnitateDeSuprafata = 0.05;
    public static double lnod=20;
    abstract public double getSuprafataTotala();
    abstract public double getLungimePanglica();
    public default double pret(){
        return getSuprafataTotala()*pretUnitateDeSuprafata;
    }
}