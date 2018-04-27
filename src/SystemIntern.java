import java.util.ArrayList;
import java.util.Scanner;

import Categories.Category;
import Project.Project;
import User.User;


public class SystemIntern {
	
	Scanner input = new Scanner(System.in);
	private ArrayList<User> users = new ArrayList<>();
	//private ArrayList<String> categories = new ArrayList<>();
	private ArrayList<Category> categories = new ArrayList<Category>();
	
	public void start(){
		
		while(true){
			
			
			System.out.printf("[1] Entrar%n[2] Registrar%n[3] Encerrar sistema%n");
			int option = Integer.parseInt( input.next());
			
			if(option == 1)
				login();
			else if(option == 2)
				register();
			else 
				break;
		}
	}
	
	
	
	public void register(){
		users.add(new User());
	}
	public void login(){
		
		boolean check = false;
		String login,password;
		while(!check){
			
			
			System.out.println("Nome de usuario: ");
			login = input.next();
			System.out.println("Senha: ");
			password = input.next();
			
			for(User user : users ){
				if(user.getLogin().equals(login))
					if(user.getPassword().equals(password)){
						check = true;
						menu(user);
					}
			}
			
			if(!check)
				System.out.println("Usuario nao encontrado ou senha incorreta");
		}
	}
	public void menu(User user){
		
		int option;
		
		while(true){
			
			System.out.println("[1] Criar um novo projeto%n[2] Explorar projetos%n[3]Informacoes gerais sobre o KickStarter%n" +
					"[4] Ver meus projetos%n [5] Gerenciar projetos%n[6] Editar perfil%n[7] Ver menssagens recebidas%n[8] Enviar menssagem%n[9] Sair%n");
			
			
			option = Integer.parseInt(input.nextLine());
			
			switch(option){
			case 1:
				user.addProjects(new Project(categories));
				break;
			case 2:
				lookProjects();
				break;
			case 3:
				
			default:
				System.out.println("Opcao invalida");
				break;
			}
			
		}
	
	}
	public void lookProjects(){
		System.out.println("Selecione a categoria:");
		int cont = 1;
		for(String category : categories)
			System.out.printf("[%d] %s%n", cont++, category);
		
		
	}

}
