package model;

public class User {
	String name;
	String password;
	String role;
	String email;
	int availableCane;
	String date;
	int orderCane;
	int reserveCane;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAvailableCane() {
		return availableCane;
	}
	public void setAvailableCane(int availableCane) {
		this.availableCane = availableCane;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getOrderCane() {
		return orderCane;
	}
	public void setOrderCane(int orderCane) {
		this.orderCane = orderCane;
	}
	public int getReserveCane() {
		return reserveCane;
	}
	public void setReserveCane(int reserveCane) {
		this.reserveCane = reserveCane;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [name=").append(name).append(", password=").append(password).append(", role=").append(role)
				.append(", email=").append(email).append(", availableCane=").append(availableCane).append(", date=")
				.append(date).append(", orderCane=").append(orderCane).append(", reserveCane=").append(reserveCane)
				.append("]");
		return builder.toString();
	}

}
