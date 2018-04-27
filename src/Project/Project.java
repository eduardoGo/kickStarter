package Project;

import java.util.ArrayList;
import java.util.Scanner;

public class Project {

	
	private int valueAcquired;
	private String name;
	//private ArrayList<User> contributors talvez uma map aqui, que tenha os contribuidores e os valores doados
	private ArrayList<Ticket> promotios = new ArrayList<>();
	private String description;
	private String nameCreator;
	private int goal;
	
	Scanner input = new Scanner(System.in);
	
	public Project(ArrayList<String> categories) throws {
		
		System.out.println("Nome: ");
		this.name = input.next();
		
		System.out.println("Selecione a categoria:");
		int cont = 1;
		for(String category : categories)
			System.out.printf("[%d] %s%n", cont++,category);
		
		int option = Integer.parseInt(input.next());
		this.category = categories.get(cont - 2);
		System.out.println("Descricao:");
		this.description = input.nextLine(); 
		
		System.out.println("Meta a ser atingida: ");
		this.goal = Integer.parseInt(input.next()); //throws
		
	}
	
	public void lookProject(Project project)throws {
		project.toString();
		System.out.printf("[1] Contribuir%n [2] Voltar ao menu anterior%n");
		int option = Integer.parseInt(input.next()); //throws
		if(option == 1)
			contribute(project);
		else
			return;
	}
	public void contribute(Project project){
		
		for(Ticket)
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return " Valor adquirido =" + valueAcquired + ", Nome =" + name
				+ ", Promocoes =" + promotios + ", Descricao =" + description
				+ ", Nome do criador =" + nameCreator + ", Meta =" + goal;
	}
	
	
	
	
}
