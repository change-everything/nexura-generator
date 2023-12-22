package cn.nexura.maker.meta;

/**
 * @author PeiYP
 * @since 2023年12月22日 15:35
 */
public class MetaException extends RuntimeException{

    public MetaException(String message) {
        super(message);
    }

    public MetaException(String message, Throwable cause) {
        super(message, cause);
    }
}
