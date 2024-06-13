class Chien extends Mammifiere {
    private String race;
    public Chien(String race){
        super(race);
        this.race = race;
    }

    public String animalString(){
        String textChien = "Je suis un chien.";
        if(race == null){
            return null;
        }
        else{
            return super.animalString() + textChien;
        }
    }

}
