
public class Listings {
	protected String name;
	public Listings(String name, String region, String price, String address, String type, String details, String image) {
		super();
		this.name = name;
		this.region = region;
		this.price = price;
		this.address = address;
		this.type = type;
		this.details = details;
		this.image = image;
	}
	 protected String region;
	 protected String price;
	 protected String address;
	 protected String type;
	 protected String details;
	 public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	protected String image;


}
