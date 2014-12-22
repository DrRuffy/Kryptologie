package Aufgabe4;

public class StatElement {
	public char letter;
	public double percentage;

	/**
	 * StatElementObjekt in dem der Buchstabe und dessen prozentuale H�ufugkeit
	 * gespeichet wird
	 * 
	 * @param letter
	 * @param percentage
	 */
	StatElement(char letter, double percentage) {
		this.letter = letter;
		this.percentage = percentage;
	}

	// ------------------------------------------------------------------------
	/**
	 * toString Methode
	 */
	public String toString() {
		return String.format("%c: %.2f %%", letter, percentage);
	}
}
