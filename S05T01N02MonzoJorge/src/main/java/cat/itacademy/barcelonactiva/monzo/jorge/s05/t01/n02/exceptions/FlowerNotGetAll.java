package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n02.exceptions;

public class FlowerNotGetAll extends RuntimeException{

    public FlowerNotGetAll(){
       super("The flowersdb is empty");
    }

}
