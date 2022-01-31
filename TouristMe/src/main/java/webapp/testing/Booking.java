package webapp.testing;

public class Booking {
	protected String name;
	
	 public Booking(String name, String email, String cardnumber, String cvv, String expirydate, String quantity, String date) {
		super();
		this.name = name;
		this.email = email;
		this.cardnumber = cardnumber;
		this.cvv = cvv;
		this.expirydate = expirydate;
		this.quantity = quantity;
		this.date = date;
	}
	 
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCardnumber() {
		return cardnumber;
	}
	
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	
	public String getCvv() {
		return cvv;
	}
	
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	public String getExpirydate() {
		return expirydate;
	}
	
	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}
	
	public String getQuantity() {
		return quantity;
	}
	
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	protected String email;
	protected String cardnumber;
	protected String cvv;
	protected String expirydate;
	protected String quantity;
	protected String date;

}
