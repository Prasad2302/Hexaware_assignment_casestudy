package exceptions;

public class OverDraftLimitExceededException extends Exception{
	public OverDraftLimitExceededException(String message) {
        super(message);
    }
}
