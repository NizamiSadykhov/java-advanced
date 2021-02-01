package exeption;

public class MyArraySizeException extends Exception {

    @Override
    public String getMessage() {
        return "Use [4][4] 2d array";
    }
}
