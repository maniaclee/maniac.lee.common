package maniac.lee.common.exception;

/**
 * Created by peng on 16/2/28.
 */
public class ManiacException extends RuntimeException {
    private ManiacException(String message) {
        super(message);
    }

    private ManiacException(String message, Throwable cause) {
        super(message, cause);
    }

    public static ManiacException create(String message, Throwable cause) {
        return new ManiacException(message, cause);
    }

    public static ManiacException create(String message) {
        return new ManiacException(message);
    }
}
