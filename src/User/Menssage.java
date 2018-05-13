package User;

public class Menssage {

	private String menssage;
	private Profile sender;
	
	
	
	public Menssage(String menssage, Profile sender) {
	
		this.menssage = menssage;
		this.sender = sender;
	}
	public String getMenssage() {
		return menssage;
	}
	public void setMenssage(String menssage) {
		this.menssage = menssage;
	}
	public Profile getSender() {
		return sender;
	}
	public void setSender(Profile sender) {
		this.sender = sender;
	}
	
	
}
