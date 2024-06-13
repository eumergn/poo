public class TestAnimal{
    public static void main(String[] args) {
        Animal[] animaux = new Animal[5];
        animaux[0]=new Animal("Truc");;
        animaux[1]=new Animal(null);
        animaux[2]=new Chien("Medor");
        animaux[3]=new Homme(null);
        animaux[4]=new Homme ("Robert") ;
        for (int i=0; i<5; i++) {
            System.out.println(animaux[i].animalString());
        }
    }
}
