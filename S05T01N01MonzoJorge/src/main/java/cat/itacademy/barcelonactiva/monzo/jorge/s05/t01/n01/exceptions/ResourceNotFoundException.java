package cat.itacademy.barcelonactiva.monzo.jorge.s05.t01.n01.exceptions;


public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException (String message){
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable throwable){
        super(message,throwable);
    }
}