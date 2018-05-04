package Categories;

import java.util.ArrayList;
import java.util.Scanner;

import enums.Status;

import Project.Project;
import User.User;

public class Category {
	
	private ArrayList<Project> projects = new ArrayList<Project>();

	Scanner input = new Scanner(System.in);
	
	public ArrayList<Project> getProjects() {
		return projects;
	}

	public void addProjects(Project project) {
		this.projects.add(project);
	}
	
	public void lookProjects(User user) {
		int option = 1;
		for(Project project : this.projects)
			if(project.getStatus() == Status.EM_DIVULGACAO){
				System.out.printf("[%d] - %s%nDecricao: %s%n----%n", option++,
						project.getName(),project.getDescription());
			}
		System.out.println("[0] Voltar ao menu principal%n"
				+ "Para ver mais detalhes selecione o projeto, ou volte ao menu principal");
		boolean check = false;
		while(!check) {
			try {
				option = Integer.parseInt(input.nextLine());
				check = true;
			}catch(NumberFormatException e) {
				System.out.println("Entrada invalida, tente novamente");
			}
		}
		if(option == 0)
			return;
		this.projects.get(option - 1).lookDetailsProject(user);
		
	}
	

}
