package Categories;

import java.util.ArrayList;
import java.util.Scanner;

import Project.Project;

public class Category {
	
	private ArrayList<Project> projects = new ArrayList<Project>();
	
	Scanner input = new Scanner(System.in);
	
	public void lookProjects(){
		int cont = 1;
		int option;
		
		for(Project project : projects){
			System.out.printf("[%d] %s%n", cont++,project.getName()); 
		}
		System.out.println("Selecione o projeto caso queira ver mais detalhes ou volte ao menu anterior");
		System.out.printf("[%d] Voltar ao menu anterior", cont);
		
		option = Integer.parseInt(input.next());
		if(option == projects.size())
			return;
		else if(option > projects.size() || option < 0){
			System.out.println("Opcao invalida, voltando ao menu anterior...");
			return;
		}else{
			projects.get(option - 2).lookProject(projects.get(option - 2));
		}
	}
	

}
