package User;

public class Menssage {

	private String menssage;
	private User sender;
	
	
	
	public Menssage(String menssage, User sender) {
	
		this.menssage = menssage;
		this.sender = sender;
	}
	public String getMenssage() {
		return menssage;
	}
	public void setMenssage(String menssage) {
		this.menssage = menssage;
	}
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	
	
}
