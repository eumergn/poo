class BinomeSol1 extends Binome{
    private double racine1;
    
    public BinomeSol1(double pa, double pb, double pc, double pdis){
        super(pa,pb,pc,pdis);
    }
    public void calculer_racine(){
        racine1 = (-b)/(2*a);
    }
    public int nb_racine(){
        return 1;
    }
    public double valeur_racine(int i){
        if (i!=1){
            System.out.println("Erreur!!! " + i);
        }
        return racine1;

    }
} 