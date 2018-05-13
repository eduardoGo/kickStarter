package Project;

import java.util.Calendar;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

import enums.Status;
import Categories.Category;
import User.Profile;
public class Project {

	
	private int valueAcquired = 0;
	private String name;
	private Map<Profile,Integer> contributors = new HashMap<Profile,Integer>();
	private ArrayList<Ticket> promotios = new ArrayList<>();
	private String description;
	private Profile userCreator;
	private int goal;
	private Status status;
	private Category category;
	private Calendar expirationDate;
	
	Scanner input = new Scanner(System.in);
	
	public Project(ArrayList<Category> categories, Profile user) throws NumberFormatException,IndexOutOfBoundsException {
		
		this.userCreator = user;
		System.out.println("Nome do projeto: ");
		
		this.name = input.nextLine();
		
		System.out.println("Selecione a categoria:");
		int option = 1;
		for(Category category : categories)
			System.out.printf("[%d] %s%n", option++,category.toString());
		
		
	
		option = Integer.parseInt(input.nextLine());
		this.category = categories.get(option - 1);
		
		System.out.println("Descricao:");
		this.description = input.nextLine(); 
		
		System.out.println("Valor necessario para realizar o projeto: ");
		this.goal = Integer.parseInt(input.nextLine());		
			
		this.status = Status.EM_CONSTRUCAO;
		this.expirationDate = Calendar.getInstance();
		this.expirationDate.add(Calendar.DATE, 184); //+184 dias = 6 meses
	}
	
	public Project(String name, String description, Profile userCreator, int goal, Status status, Category category,
			Calendar expirationDate) {
		this.name = name;
		this.description = description;
		this.userCreator = userCreator;
		this.goal = goal;
		this.status = status;
		this.category = category;
		this.expirationDate = expirationDate;
	}

	public void lookDetailsProject(Profile user) throws NumberFormatException, IndexOutOfBoundsException{
		System.out.printf("%s%nDescricao: %s%nTickets:%n", this.name,this.description);
		int count = 1;
		for(Ticket ticket : this.promotios)
			System.out.printf("[%d] ---%nValor: %d%n%s%n", count++,ticket.getValue(),ticket.getDescription());
		System.out.printf("[%d] Contribuir sem comprar ticket", count);
		System.out.printf("[0] Voltar ao menu principal%nCaso queira contribuir, selecione o ticket, ou volte ao menu principal");
		
		int option = Integer.parseInt(input.nextLine());
		if(option == 0)
			return;
		else { 
			System.out.print("Numero do cartao: ");
			String numberCard = input.nextLine();
			if(option == count) {
				System.out.print("Valor: ");
				int value = Integer.parseInt(input.nextLine());
				payment(user,value,numberCard);
			}
			else 
				payment(user,this.promotios.get(option - 1).getValue(),numberCard);	
		}
	}
	public void payment(Profile user,int value, String numberCard){
		
		if(user != null && numberCard != null && value > 0) {
			System.out.println("Pronto! :)");
			this.contributors.put(user, value);
			this.valueAcquired += value;
		}
		
	}

	
	
	public Calendar getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Calendar expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Map<Profile, Integer> getContributors() {
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

	public Profile getuserCreator() {
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
