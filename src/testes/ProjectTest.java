package testes;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;
import Database.Database;
import Project.Project;
import User.Profile;
import enums.Status;
public class ProjectTest {

	Database database = new Database();
	Project project = new Project("Teste", "Testandooooo 123", database.getUsers().get(0),999,
			Status.EM_DIVULGACAO,database.getCategories().get(0),Calendar.getInstance());
	Profile user = database.getUsers().get(0);
	
	@Test
	public void testPayment() {
			
		
		project.payment(user,999,"91387123");
		assertEquals(999,project.getValueAcquired());
		
		project.payment(null, 999, null);
		assertEquals(999,project.getValueAcquired());
		
		project.payment(user,-10,"91387123");
		assertEquals(999,project.getValueAcquired());
	
	}
	@Test
	public void testContributors(){
		
		project.payment(user,999,"91387123");
		assertEquals(new Integer(999), project.getContributors().get(user));
		
	}

}
