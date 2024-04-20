package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n03.exceptions;

public class FlowerNotCreated extends RuntimeException{
    public FlowerNotCreated (){
        super("Can't create a new flower at BBDD, check the information you send");
    }
}