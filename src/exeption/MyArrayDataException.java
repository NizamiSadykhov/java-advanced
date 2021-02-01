package exeption;

public class MyArrayDataException extends Exception{

    private int y;
    private int x;

   public MyArrayDataException(int y, int x) {
       this.y = y;
       this.x = x;
   }

   @Override
   public String getMessage() {
       return String.format("Unknown value in [%d][%d]", y, x);
   }


}
