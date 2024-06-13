public abstract class Suite{

    protected int premier = 0;
    protected int pas = 0;


    public Suite(int premier, int pas){
        this.premier = premier;
        this.pas = pas;
    }

    public abstract int valeurAuRangN(int n);

    public abstract int sommeAuRangN(int n);
}