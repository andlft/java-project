package Exceptions;

public class NoItems extends Exception implements IBaseException {
    private int exceptionCode;
    private String exceptionMessage;

    public NoItems (String exceptionMessage, int exceptionCode){
        super(exceptionMessage);
        this.exceptionCode = exceptionCode;
        this.exceptionMessage = exceptionMessage;
    }
    @Override
    public int getExceptionCode() {
        return this.exceptionCode;
    }

    @Override
    public String getExceptionMessage() {
        return this.exceptionMessage;
    }
}
