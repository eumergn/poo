public class SuiteGeom extends Suite{

    public SuiteGeom(int premier, int pas){
        super(premier,pas);
    }


    public int valeurAuRangN(int n){
        return (int)(premier * Math.pow(pas,n-1));
    }

    public int sommeAuRangN(int n){
        return (int)(premier * (1 - Math.pow(pas,n))/(1-pas));
    }
}
