package base.service;

import MyException.NameExistException;
import base.entity.Contact;

import java.util.List;

public interface InterfaceService {
    public void addContact(Contact contact)throws NameExistException;
    public void updateContact(Contact contact);
    public void deleteContact(String id);
    public List<Contact> findAll();
    public Contact findById(String id);
}
