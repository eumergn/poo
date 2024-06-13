class Mammifiere extends Animal{

    public Mammifiere (String animalName){
        super(animalName);  
    }

    public String animalString(){
        return super.animalString() + "Je suis un mammifiere. ";
    }
}
