package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n03.exceptions;


public class FlowerNotFoundException extends RuntimeException {

    public FlowerNotFoundException(Integer id) {
        super("Flower not found with ID: "+id);
    }
}