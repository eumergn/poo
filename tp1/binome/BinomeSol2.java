class BinomeSol2 extends Binome{
    private double racine1;
    private double racine2;

    public BinomeSol2(double pa, double pb, double pc, double pdis){
        super(pa,pb,pc,pdis);
    }

    public void calculer_racine(){
        racine1 = ( -b - Math.sqrt(dis) ) / (2*a);
        racine2 = ( -b + Math.sqrt(dis) ) / (2*a);
    }

    public int nb_racine(){
        return 2;
    }

    public double valeur_racine(int i){
        
        if(i!=1 && i!=2){
            System.out.println("Erreur : la racine n'existe pas");
        }
        if(i==1){
            return racine1;
        }
        return racine2;
    }
    

}  