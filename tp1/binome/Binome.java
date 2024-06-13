    public class Binome {
    // Donnees:
    protected double a,b,c,dis;
    public static void main(String arg[]){
        Binome[] b = new Binome[3];
        int i,j;
        b[0] = creation(1,2,1);         // sol 1
        b[1] = creation(0.5,3,1);       // sol 2
        b[2] = creation(2,1,2);         // 0 sol

        for (i=0 ;i<3; i++){
            b[i].calculer_racine();
            System.out.println("equation # "+i+" a "+b[i].nb_racine()+" racine(s).");

            for(j=1;j<=b[i].nb_racine();j++){
                System.out.println("Racine # "+j+" = "+b[i].valeur_racine(j));
            }
        }
    }

    // Methodes
    public Binome(double pa,double pb,double pc,double pdis)
    { 
        a = pa;
        b = pb;
        c = pc;
        dis = pdis; 
    }
    
    public static Binome creation(double pa,double pb,double pc)
    {
        double delta;
        delta = pb * pb - 4.0 * pa * pc;
        if (delta < 0.0) {
            return new BinomeSol0(pa,pb,pc,delta);
        } 
        else if (delta == 0.0) {
            return new BinomeSol1(pa,pb,pc,delta);
        } 
        else {
            return new BinomeSol2(pa,pb,pc,delta);
        }
    }
    public void calculer_racine(){ 
        System.out.println("Erreur si ici !");
    }
    public int nb_racine(){
        System.out.println("Erreur si ici !");
        return 0;
    }
    public double valeur_racine(int i){
        System.out.println("Erreur si ici !");
        return 0.0;
    }
}