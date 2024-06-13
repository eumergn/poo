public class SuiteArithm extends Suite{

    public SuiteArithm(int premier, int pas){
        super(premier,pas);
    }

    public int valeurAuRangN(int n){
        return premier + (n-1) * pas;
    }
    
    public int sommeAuRangN(int n){
        return n * (premier + valeurAuRangN(n)) / 2;
    }
}