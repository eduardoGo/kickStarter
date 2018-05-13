package User;

import java.util.ArrayList;
import java.util.Scanner;

import Project.Project;

public abstract class Profile{

	protected String name;
	protected String login;
	protected String password;
	protected int age;
	protected String email;
	protected ArrayList<Project> projects = new ArrayList<Project>();
	protected ArrayList<Menssage> menssageReceived = new ArrayList<Menssage>();
	
	Scanner input = new Scanner(System.in);
	



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
			System.out.println("Opcao invalida");
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
