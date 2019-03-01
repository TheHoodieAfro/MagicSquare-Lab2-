package customExceptions;

@SuppressWarnings("serial")
public class NonOddLevelException extends IllegalArgumentException{
	
	private int number;
	private String customMessage;
	
	public NonOddLevelException(int n) {
		
		super("The number is not an odd value");
		number = n;
		customMessage = number +" is not an odd number";
		
	}
	
	@Override
	public String getMessage() {
		
		String msj = super.getMessage() + customMessage;
		return msj;
		
	}
	
	public int getNumber() {
		return number;
	}
	
}
