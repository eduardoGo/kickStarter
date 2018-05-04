package Project;

import java.util.Scanner;

public class Ticket {

	private String description;
	private int value;
	
	Scanner input = new Scanner(System.in);
	
	public Ticket() {
		
		System.out.println("Valor: ");
		this.value = Integer.parseInt(input.nextLine());
		System.out.println("Descricao: ");
		this.description = input.nextLine();
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	
	
}
