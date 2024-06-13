public class Global {
    public static void main(String[] args) {
        Peage p = new Peage();

        Voiture voiture1 = new Voiture();
        Camion camion1 = new Camion(4, 2.5);
        Camion camion2 = new Camion(2, 7.4);

        p.Vehiculepasse(voiture1);
        p.Vehiculepasse(camion1);
        p.Vehiculepasse(camion2);

        System.out.println("Nombre de vehicule passes:\t\t" + p.getNbreVehicule());
        System.out.println("Total caisse de vehicule passes:\t" + p.getTotalCaisse() + " euros");

    }
    
}
