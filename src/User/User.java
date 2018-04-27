package User;

import java.util.ArrayList;
import java.util.Scanner;

import Project.Project;

public class User {

	protected String name;
	protected String login;
	protected String password;
	protected int age;
	protected String email;
	protected int currentBalance = 0;
	protected ArrayList<Project> projects = new ArrayList<>();
	
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
		int age = Integer.parseInt(input.next());
		
		this.age = age;
	}

	
	
	public int getCurrentBalance() {
		return currentBalance;
	}



	public void addCurrentBalance(int currentBalance) {
		this.currentBalance += currentBalance;
	}



	public ArrayList<Project> getProjects() {
		return projects;
	}



	public void addProjects(Project project) {
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
