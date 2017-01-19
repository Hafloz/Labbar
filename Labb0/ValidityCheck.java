import java.util.*;

public class ValidityCheck {

	public static boolean isValidSSNR(String number) {
		int tmp, tmp2 = 0;
		ArrayList<Integer> samlaTal = new ArrayList<Integer>();

		for (int i = 0; i < number.length(); i++) {
			tmp = Character.digit(number.charAt(i), 10); //G�r varje tal i forloopen till siffra
			
			if ((i % 2) == 0) { //Kollar ifall talet ska multipliceras eller ej 
				tmp = tmp * 2;
				if (tmp < 10) { 
					samlaTal.add(tmp);
				} else {
					tmp = tmp % 10; /// Modulus 10 ger den sista siffran
					samlaTal.add(tmp);/// Addera det som blir �ver
					samlaTal.add(1);// L�gg till en etta f�r f�rsta siffran
				}
			} else {
				samlaTal.add(tmp);
			}
		}
		for (int elem : samlaTal) {//Forloop som summerar ihop siffrorna fr�n arrayen samlaTal
			tmp2 = tmp2 + elem;
		}
		if (tmp2 % 10 == 0 && checkInput(number)) { //Ifall talet g�r att dela j�mt, samt �r r�tt input blir den true, annars false
			return true;
		} else
			return false;
	}

	// Metod som kollar ifall inputten �r r�tt
	public static boolean checkInput(String input) {
		if (input.length() > 10 || input.length() < 10) {
			return false;
		} else
			return true;
	}

	public static void main(String[] args) {
		System.out.print("L�gg till personnummer: ");
		Scanner sc = new Scanner(System.in);
		String personNumber = sc.nextLine();

		if (isValidSSNR(personNumber)) {
			System.out.println("Giltigt nummer.");
		} else {
			System.out.println("Ej ett giltigt nummer.");
		}
	}
}
