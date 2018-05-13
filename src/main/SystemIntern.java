package main;
import java.util.Scanner;
import java.util.Set;

import enums.Status;
import	java.util.Calendar;
import Categories.Category;
import Database.Database;
import Project.Project;
import Project.Ticket;
import User.Manager;
import User.Menssage;
import User.Profile;
import User.User;


public class SystemIntern {
	
	Scanner input = new Scanner(System.in);
	private Database database = new Database();
	
	public void start(){
		
		int option;
		while(true){
			
			
			System.out.printf("[1] Entrar%n[2] Registrar%n");
			
			try {
				option = Integer.parseInt( input.nextLine());
				
				if(option == 1)
					login();
				else if(option == 2)
					register();
			}catch(NumberFormatException e) {
				System.out.println("Entrada invalida!");
			}
		}
	}
	
	public void register() throws NumberFormatException{
		Profile user = new User();
		database.addUser(user);
	}
	public void login() throws NumberFormatException{
		
		boolean check = false;
		String login,password;
		while(!check){
			
			
			System.out.println("Nome de usuario: ");
			login = input.nextLine();
			System.out.println("Senha: ");
			password = input.nextLine();
			
			for(Profile user : database.getUsers() ){
				if(user.getLogin().equals(login) && user.getPassword().equals(password)) {
					check = true;
					menu(user);
					break;
				}
			}
			
			if(!check) {
				System.out.println("O nome de usuario ou senha esta incorreto");
				System.out.printf("[1] Voltar ao menu anterior%n[2] Tentar novamente%n");
				int option = Integer.parseInt(input.nextLine());
				if(option == 1)
					check = true;
			}
		}
	}
	public void menu(Profile user){
		
		int option;
		checkExpirationTime();
		while(true){
			
			System.out.printf("----%n");
			if(user instanceof Manager) {
				System.out.printf("[0] Revisar projetos%n");
			}
			System.out.printf("[1] Criar um novo projeto%n[2] Explorar projetos%n[3] Informacoes gerais sobre o KickStarter%n" +
					"[4] Ver meus projetos%n[5] Editar perfil%n[6] Ver menssagens recebidas%n[7] Enviar menssagem%n[8] Sair%n");
			
			
			
			try {
				option = Integer.parseInt(input.nextLine());
				
				switch(option){
					case 0:
						if(user instanceof Manager)
							reviewProjects();
						else
							System.out.println("Entrada invalida");
						break;
					case 1:
						newProject(user);
						break;
					case 2:
						lookProjects(user);
						break;
					case 3:
						lookInformationsKickStarter();
						break;
					case 4:
						lookMyProjects(user);
						break;
					case 5:
						user.edit();
						break;
					case 6:
						lookMenssages(user);
						break;
					case 7:
						sendMenssage(user);
						break;
					case 8:
						return;
					default:
						break;
				}
		
				
			}catch(NumberFormatException e) {
				System.out.println("Entrada invalida!");
			}catch(IndexOutOfBoundsException a) {
				System.out.println("Entrada invalida!");
			}
					
		}
	
	}
	void checkExpirationTime() {
		for(Category category : database.getCategories()) {
			for(Project project : category.getProjects()) {
				if(project.getExpirationDate().before(Calendar.getInstance()))
					removeProject(project);
				
			}
		}
	}
	private void removeProject(Project project) {
		
		project.setStatus(Status.EM_CONSTRUCAO);
		project.setExpirationDate(Calendar.getInstance()); //Reset time
		
	}
	private void reviewProjects(){
		int option;
		for(Project project : database.getProjectsToReview()){
			System.out.printf("---%nNome: %s%nDescricao: %s%nLogin do criador do projeto: %s%n",
					project.getName(),project.getDescription(),project.getuserCreator().getLogin());
			System.out.printf("[1] Autorizar [2] Nao autorizar");
			option = Integer.parseInt(input.nextLine());
			if(option == 1){
				project.setStatus(Status.EM_DIVULGACAO);
				
			}
			else{
				project.setStatus(Status.EM_CONSTRUCAO);
			}
		}
	}
	private void sendMenssage(Profile sender){
		System.out.println("Login do usuario que deseja enviar a menssagem: ");
		String login = input.nextLine();
		boolean check = false;
		for(Profile recipient : database.getUsers())
			if(recipient.getLogin().equals(login)){
				check = true;
				System.out.println("Menssagem: ");
				recipient.addMenssageReceived(new Menssage(input.nextLine(),sender));
			}
		
		if(!check)
			System.out.println("Usuario nao encontrado");
		else
			System.out.println("Menssagem enviada!");
	}
	private void lookMenssages(Profile user){
		for(Menssage menssage : user.getMenssageReceived()){
			System.out.printf("---%nRemetente: %s%nMenssagem: %s%n", menssage.getSender().getLogin(),menssage.getMenssage());
		}
	}
	private void lookMyProjects(Profile user) throws NumberFormatException, IndexOutOfBoundsException{
		int option = 1;
		for(Project project : user.getProjects()){
			System.out.printf("[%d] --- %nNome: %s%nDescricao: %s%nCategoria: %s%nStatus: %s%n", 
					option++,project.getName(),project.getDescription(),project.getCategory().toString(),project.getStatus());
			if(project.getStatus() == Status.EM_DIVULGACAO){
				System.out.printf("Valor arrecadado: %d%nContribuidores:%n", project.getValueAcquired());
				Set<Profile> keys = project.getContributors().keySet();
				
				for(Profile userCurrent : keys)
					System.out.printf("Nome: %s - Valor: %d%n", userCurrent.getName(),project.getContributors().get(userCurrent));
				
			}
		}
		System.out.printf("[0] Voltar ao menu principal%nSelecione o projeto caso queira edita-lo ou volte ao menu principal%n");
		option = Integer.parseInt(input.nextLine());
		if(option == 0)
			return;
		editProject(user.getProjects().get(option-1));
	}
	private void editProject(Project project) throws NumberFormatException{
		System.out.printf("Selecione o que deseja editar:%n[1] Nome%n[2] Adcionar ticket%n[3] Descricao%n" +
				"[4] Meta%n[5] Categoria%n[6] Enviar para revisao%n[0] Voltar ao menu anterior%n");
		int option = Integer.parseInt(input.nextLine());
		
		switch(option){
		
		case 0:
			return;
		case 1:
			System.out.printf("Novo nome: ");
			project.setName(input.nextLine());
			break;
		case 2:
			project.addPromotios(new Ticket());
			break;
		case 3:
			System.out.printf("Nova descricao: ");
			project.setDescription(input.nextLine());
			break;
		case 4:
			System.out.println("Nova meta: ");
			project.setGoal(Integer.parseInt(input.nextLine()));
			break;
		case 5:
			editCategory(project);
			break;
		case 6:	
			if(project.getStatus() == Status.EM_CONSTRUCAO){
				database.addProjectsToReview(project);
				project.setStatus(Status.EM_REVISAO);
			}else 
				System.out.println("Esse projeto nao pode ser enviado para revisao");
			break;
		default:
			System.out.println("Entrada invalida");
			break;
		}
	}
	private void editCategory(Project project) throws NumberFormatException, IndexOutOfBoundsException{
		System.out.println("Selecione a nova categoria:");
		int option = 1;
		for(Category category : database.getCategories())
			System.out.printf("[%d] %s%n", option++, category.toString());
	
		option = Integer.parseInt(input.nextLine());
		project.getCategory().getProjects().remove(project);
		project.setCategory(database.getCategories().get(option - 1));
		database.getCategories().get(option-1).addProjects(project);
		
	}
	private void lookInformationsKickStarter(){
		System.out.printf("---%nQuantidade de usuarios cadastrados: %d%n", database.getUsers().size());
		int total=0;
		for(Category category : database.getCategories())
			total += category.getProjects().size();
		
		System.out.printf("Quantidade de projetos criados: %d%n-----%n",total);
	
	}
	private void newProject(Profile user) throws NumberFormatException, IndexOutOfBoundsException {
		
		Project project = new Project(database.getCategories(), user);
		project.getCategory().addProjects(project);
		user.addProject(project);
	
		
	}
	
	private void lookProjects(Profile user) throws NumberFormatException, IndexOutOfBoundsException{
		System.out.println("Selecione a categoria:");
		int option = 1;
		for(Category category : database.getCategories())
			System.out.printf("[%d] %s%n", option++, category.toString());
		
	
		option = Integer.parseInt(input.nextLine());
			
		
		
		database.getCategories().get(option - 1).lookProjects(user);
	}

}
