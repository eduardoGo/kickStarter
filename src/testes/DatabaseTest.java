package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import Database.Database;
import User.User;

public class DatabaseTest {

	@Test
	public void test() {
		Database database = new Database();
		
		User user = new User("Gomes","gg","123",19,"egs1@ic.ufal.br");
		
		database.addUser(user);
		assertEquals(user, database.getUsers().get(1));
	}

}
