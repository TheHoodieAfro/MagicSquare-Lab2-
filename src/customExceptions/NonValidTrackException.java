package customExceptions;

@SuppressWarnings("serial")
public class NonValidTrackException extends Exception{
	
	private String track;
	private String customMessage;
	
	public NonValidTrackException(String t) {
		
		super("The inserted track is not avaliable");
		
		track = t;
		
		customMessage = track +" is does not exists between the supported tracks";
		
	}
	
	@Override
	public String getMessage() {
		
		String msj = super.getMessage() + customMessage;
		
		return msj;
		
	}
	
	public String getTrack() {
		
		return track;
		
	}
	
}
