package User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import enums.Status;

import Categories.Category;
import Project.Project;

public class User {

	protected String name;
	protected String login;
	protected String password;
	protected int age;
	protected String email;
	protected ArrayList<Project> projects = new ArrayList<Project>();
	protected ArrayList<Menssage> menssageReceived = new ArrayList<Menssage>();
	
	Scanner input = new Scanner(System.in);
	
	
	
	public User() {
		
		System.out.println("Nome: ");
		this.name = input.nextLine();
		
		System.out.println("Nome de usuario: ");
		this.login = input.next();
		
		System.out.println("Senha: ");
		this.password = input.next();
		
		System.out.println("Email: ");
		this.email = input.next();
		
		System.out.println("Idade: ");
		int age = Integer.parseInt(input.nextLine());
		
		this.age = age;
	}
	
	public User(String name, String login, String password, int age, String email) {
		this.name = name;
		this.login = login;
		this.password = password;
		this.age = age;
		this.email = email;
	}
	
	public void lookMyProjects(ArrayList<Category> categories, User user){
		
		
	}
	
	public void edit() throws NumberFormatException{
		System.out.printf("Selecione o que deseja editar:%n[1] Nome%n[2] Email%n[3] Login%n[4] Senha%n");
		int option = Integer.parseInt(input.nextLine());
		
		switch(option){
		case 1:
			System.out.print("Novo nome: ");
			this.name = input.nextLine();
			break;
		case 2:
			System.out.print("Novo email: ");
			this.email = input.nextLine();
			break;
		case 3:
			System.out.print("Novo login: ");
			this.login = input.nextLine();
			break;
		case 4:
			System.out.print("Nova senha: ");
			this.password = input.nextLine();
			break;
		default:
			break;
		}
		
	}
	

	
	public void addMenssageReceived(Menssage menssageReceived) {
		this.menssageReceived.add(menssageReceived);
	}

	public ArrayList<Menssage> getMenssageReceived() {
		return menssageReceived;
	}

	public ArrayList<Project> getProjects() {
		return projects;
	}



	public void addProject(Project project) {
		this.projects.add(project);
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
