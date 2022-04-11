package chess;

public class CheckInput {

	public static boolean checkCoordinateValidity(String input){

		if(input.length() > 2 || input.length() <= 1){
			return false;
		}
		else {
			if(input.charAt(0) > '8' || input.charAt(0) < '1' || input.charAt(1) > 'h' || input.charAt(1) < 'a'){
				return false;
			}
		}
		return true;
	}
}
