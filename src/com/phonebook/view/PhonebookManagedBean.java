package com.phonebook.view;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.phonebook.business.PhonebookLocal;
import com.phonebook.data.Contact;

@ManagedBean(name="phonebook")
@RequestScoped
public class PhonebookManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PhonebookLocal phonebookBusiness;
	private Contact contact;
	
	public PhonebookManagedBean() {
		super();
		contact = new Contact();
	}

	public PhonebookLocal getPhonebookBusiness() {
		return phonebookBusiness;
	}

	public void setPhonebookBusiness(PhonebookLocal phonebookBusiness) {
		this.phonebookBusiness = phonebookBusiness;
	}


	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public List<Contact> getContactsList() {
		List<Contact> contacts = phonebookBusiness.getContacts();
		return contacts;
	}
	
	public void save() {
		phonebookBusiness.addContact(contact);
	}

}
