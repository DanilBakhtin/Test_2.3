package Main;

/**
 * Класс исключений для БД
 */
public class DateBaseException extends Exception{

    public DateBaseException() {
    }

    public DateBaseException(String message) {
        super(message);
    }
}
