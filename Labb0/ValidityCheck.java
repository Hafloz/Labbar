import java.util.*;

public class ValidityCheck {

	public static boolean isValidSSNR(String number) {
    	int tmp, tmp2 = 0;
    	ArrayList<Integer> samlaTal = new ArrayList<Integer>();
    	
    	for (int i = 0; i < number.length(); i++) {
    		tmp = Character.digit(number.charAt(i), 10);
    		if( (i % 2) == 0) {;//Kollar ifall talet är heltal eller deltal (lol vad heter det nu igen)
    			tmp = tmp * 2;
    			if (tmp < 10) {
    			samlaTal.add(tmp);
    			}else{
   					tmp= tmp % 10;
   					samlaTal.add(tmp);
   					samlaTal.add(1);    				
    			}
    		}else{
				samlaTal.add(tmp);
			}
    	}
    	for (int elem: samlaTal) {
    		tmp2 = tmp2 + elem;
    		}
    	if (tmp2 % 10 == 0 && checkInput(number)) {
    		return true;
    	}else
    		return false;
    }
	//Metod som kollar ifall inputten är rätt
	public static boolean checkInput(String input) {
		if (input.length()> 10 || input.length()< 10) {
			return false;
		}else
			return true;
	}

    public static void userInput(String k) {
        //String personNumber = "91041153";
    	Scanner sc = new Scanner(System.in);
    	String personNumber = sc.nextLine();

        if (isValidSSNR(personNumber)) {
            System.out.println("Giltigt nummer.");
        } else {
            System.out.println("Ej ett giltigt nummer.");
        }
    }
}
