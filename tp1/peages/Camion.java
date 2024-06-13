public class Camion extends Vehicule {
    private int nbrEssieu;
    private double poidsTotal;              // en tonnes


    public Camion (int nbrEssieu,double poidsTotal){
        this.nbrEssieu = nbrEssieu;
        this.poidsTotal = poidsTotal; 
    }

    public int getNbreEssieu(){
        return nbrEssieu;
    }

    public double getPoidsTotal(){
        return poidsTotal;
    }

    public double calculeTaxe(){
        return (7 * nbrEssieu) + (15 * poidsTotal);
    }
}

