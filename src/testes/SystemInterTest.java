package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import Database.Database;
import User.Menssage;
import User.Profile;
import User.User;

public class SystemInterTest {

	Database database = new Database();
	
	@Test
	public void testRegister() {
		
		
		User user = new User("Gomes","gg","123",19,"egs1@ic.ufal.br");
		
		assertEquals("Teste 1 Registar", "gg", user.getLogin());
		assertEquals("Teste 2 Registar", "123", user.getPassword());
		
		database.addUser(user);	
		
	
	}
	
	@Test
	public void testMenssage() {
		User userSender = new User("Gomes","gg","123",19,"egs1@ic.ufal.br");
		database.addUser(userSender);	
		Profile userRecipient = database.getUsers().get(0);
		
		userRecipient.addMenssageReceived(new Menssage("Iae", userSender));
		
		assertEquals("Iae", userRecipient.getMenssageReceived().get(0).getMenssage());
		assertEquals(userSender, userRecipient.getMenssageReceived().get(0).getSender());
	}

}
