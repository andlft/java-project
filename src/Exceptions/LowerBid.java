package Exceptions;

public class LowerBid extends Exception implements IBaseException {
    private int exceptionCode;
    private String exceptionMessage;

    public LowerBid (String exceptionMessage, int exceptionCode){
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
