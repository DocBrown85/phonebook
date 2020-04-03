package com.phonebook.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.phonebook.data.Contact;

@Stateless
public class PhonebookBean implements PhonebookLocal, PhonebookRemote {
	
	@PersistenceContext(unitName="phonebookPersistence")
	EntityManager entityManager;
	
	public void addContact(Contact c) {
		entityManager.persist(c);
	}
	
	public void updateContact(Contact c) {
		entityManager.merge(c);
	}
	
	public void removeContact(Contact c) {
		entityManager.remove(c);
	}	
	
	public Contact getContact(Integer id) {
		return entityManager.find(Contact.class, id);
	}
	
	public List<Contact> getContacts() {
		Query q = entityManager.createQuery("SELECT c FROM Contact c");
		
		return q.getResultList();
	}

}
