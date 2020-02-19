package exception;

public class Fix001to100 extends AutoException{
	
	public void fix(int errnum) {
		
		if (errnum==1) {
			System.out.println("File not found");
			
			
		}
		
	}	
	
}