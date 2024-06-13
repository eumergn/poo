public class Peage {
    private int nbrVehicule;
    private double totalCaisse;

    public Peage(){
        nbrVehicule = 0;
        totalCaisse = 0.0;
    }

    public void Vehiculepasse(Vehicule v){
        nbrVehicule++;
        totalCaisse += v.calculeTaxe();
    }
    
    public int getNbreVehicule(){
        return nbrVehicule;
    }

    public double getTotalCaisse(){
        return totalCaisse;
    }
}
