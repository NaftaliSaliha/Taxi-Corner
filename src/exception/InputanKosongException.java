package exception;

public class InputanKosongException extends Exception{
    public String message(){
        return "Field input tidak boleh kosong!";
    }
}
