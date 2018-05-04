package Project;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

import enums.Status;
import Categories.Category;
import User.User;

public class Project {

	
	private int valueAcquired = 0;
	private String name;
	private Map<User,Integer> contributors = new HashMap<User,Integer>();
	private ArrayList<Ticket> promotios = new ArrayList<>();
	private String description;
	private User userCreator;
	private int goal;
	private Status status;
	private Category category;
	
	Scanner input = new Scanner(System.in);
	
	public Project(ArrayList<Category> categories, User user) {
		
		this.userCreator = user;
		System.out.println("Nome do projeto: ");
		
		this.name = input.nextLine();
		
		System.out.println("Selecione a categoria:");
		int option = 1;
		for(Category category : categories)
			System.out.printf("[%d] %s%n", option++,category.toString());
		
		
		boolean check = false;
		while(!check) {	
			try {
				option = Integer.parseInt(input.nextLine());
				check = true;
			}catch(NumberFormatException e) {
				System.out.println("Entrada invalida, tente novamente:");
			}catch(IndexOutOfBoundsException e){
				System.out.println("Entrada invalida, tente novamente");
			}
		}

		this.category = categories.get(option - 1);
		System.out.println("Descricao:");
		this.description = input.nextLine(); 
		
		System.out.println("Valor necessario para realizar o projeto: ");
		check = false;
		while(!check) {	
			try {
				this.goal = Integer.parseInt(input.nextLine());		
				check = true;
			}catch(NumberFormatException e) {
				System.out.println("Entrada invalida, tente novamente:");
			}
		}
		this.status = Status.EM_CONSTRUCAO;
		
	}
	
	public void lookDetailsProject(User user) throws NumberFormatException{
		System.out.printf("%s%nDescricao: %s%nTickets:%n", this.name,this.description);
		int count = 1;
		for(Ticket ticket : this.promotios)
			System.out.printf("[%d] ---%nValor: %d%n%s%n", count++,ticket.getValue(),ticket.getDescription());
		System.out.printf("[%d] Contribuir sem comprar ticket", count);
		System.out.println("[0] Voltar ao menu principal%nCaso queira contribuir, selecione o ticket, ou volte ao menu principal");
		
		int option = Integer.parseInt(input.nextLine());
		if(option == 0)
			return;
		else if(option == count)
			paymentWithoutTicket(user);
		else
			paymentWithTicket( this.promotios.get(option - 1).getValue() , user);
	}
	public void paymentWithoutTicket(User user) throws NumberFormatException{
		
		System.out.printf("Valor: ");
		int value = Integer.parseInt(input.nextLine());
		System.out.println("Numero do cartao: ");
		int numberCard = Integer.parseInt(input.nextLine());
		System.out.println("Pronto! :)");
		this.contributors.put(user, value);
		
	}
	public void paymentWithTicket(int value,User user){
		
		System.out.println("Numero do cartao: ");
		int numberCard = Integer.parseInt(input.nextLine());
		System.out.println("Pronto! :)");
		this.contributors.put(user, value);
	}

	public void editProject(ArrayList<Category> categories, Project project) throws NumberFormatException{
		
	}
	
	
	public void sendReview(){}
	public Map<User, Integer> getContributors() {
		return contributors;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getValueAcquired() {
		return valueAcquired;
	}

	public void setValueAcquired(int valueAcquired) {
		this.valueAcquired = valueAcquired;
	}

	public ArrayList<Ticket> getPromotios() {
		return promotios;
	}

	public void addPromotios(Ticket ticket) {
		this.promotios.add(ticket);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getuserCreator() {
		return userCreator;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	
	
	
}
