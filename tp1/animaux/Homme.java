class Homme extends Mammifiere{

    public Homme(String humanName){
        super(humanName);
    }

    public String animalString(){
        String textHuman = "Je suis un homme.";
        return super.animalString() + textHuman;
    }
}
