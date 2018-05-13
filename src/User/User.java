package User;

public class User extends Profile{

	public User() throws NumberFormatException {	
		System.out.println("Nome: ");
		this.name = input.nextLine();
		
		System.out.println("Nome de usuario: ");
		this.login = input.nextLine();
		
		System.out.println("Senha: ");
		this.password = input.nextLine();
		
		System.out.println("Email: ");
		this.email = input.nextLine();
		
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
	

	
}
