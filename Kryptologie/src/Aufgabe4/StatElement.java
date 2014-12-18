package Aufgabe4;

public class StatElement {
	public char letter;
	public double percentage;

	StatElement(char letter, double percentage) {
		this.letter = letter;
		this.percentage = percentage;
	}

	public String toString() {
		return String.format("%c: %.2f %%", letter, percentage);
	}
}
