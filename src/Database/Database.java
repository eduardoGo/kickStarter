package Database;

import java.util.ArrayList;

import Categories.Arts;
import Categories.Category;
import Categories.Design;
import Categories.Film;
import Categories.Food;
import Categories.Games;
import Categories.Music;
import Categories.Technology;
import Project.Project;
import User.Manager;
import User.Profile;

public class Database {

	private ArrayList<Profile> users = new ArrayList<Profile>();
	private ArrayList<Category> categories = new ArrayList<Category>();
	private ArrayList<Project> projectsToReview = new ArrayList<Project>();
	

		
	public Database() {
		this.users.add(new Manager("Eduardo", "edu","123",19,"edu@ic.ufal.br"));
		this.categories.add(new Arts());
		this.categories.add(new Design());
		this.categories.add(new Film());
		this.categories.add(new Food());
		this.categories.add(new Games());
		this.categories.add(new Music());
		this.categories.add(new Technology());
	}

	
	
	public ArrayList<Project> getProjectsToReview() {
		return projectsToReview;
	}

	public void addProjectsToReview(Project project) {
		this.projectsToReview.add(project);
	}

	public ArrayList<Category> getCategories() {
		return categories;
	}
	public ArrayList<Profile> getUsers() {
		return users;
	}

	public void addUser(Profile user) {
		this.users.add(user);
	}

	

}
