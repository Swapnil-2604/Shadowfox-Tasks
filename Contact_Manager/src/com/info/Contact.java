package com.info;

public class Contact {
	private String Name;
	private int Phoneno;
	private String Email;
	
	public Contact(String name, int phoneno, String email) {
		this.Name = name;
		this.Phoneno = phoneno;
		this.Email = email;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getPhoneno() {
		return Phoneno;
	}

	public void setPhoneno(int phoneno) {
		Phoneno = phoneno;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "Contact [name=" + Name + ", phoneno=" + Phoneno + ", Email=" + Email + "]";
	}

}
