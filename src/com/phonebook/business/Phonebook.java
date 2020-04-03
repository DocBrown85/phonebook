package com.phonebook.business;

import java.util.List;

import com.phonebook.data.Contact;

public interface Phonebook {
	
	public void addContact(Contact c);
	
	public void updateContact(Contact c);
	
	public void removeContact(Contact c);
	
	public Contact getContact(Integer id);
	
	public List<Contact> getContacts();

}
