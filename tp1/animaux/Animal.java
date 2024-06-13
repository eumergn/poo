public class Animal{
    private String animalName;

    public Animal(String animalName){
        this.animalName = animalName;
    }

    public String animalString(){
        String textAnimal = "Je suis un animal";
        if(animalName == null){
            return textAnimal + ". ";
        }
        else{
            String fullName = textAnimal + " de nom " + animalName + ". ";
            return fullName; 
        }
    }
}
