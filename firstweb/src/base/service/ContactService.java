package base.service;

import MyException.NameExistException;
import base.dao.ContactDao;
import base.dao.InterfaceDao;
import base.entity.Contact;

import java.util.List;

public class ContactService implements InterfaceService {
    private InterfaceDao contactDao = new ContactDao();

    public void addContact(Contact contact)throws NameExistException{
        // 姓名重复不能添加
        if(contactDao.checkNameExist(contact.getName())){
            throw new NameExistException("姓名重复不能添加");
        }
        contactDao.addContact(contact);
    }

    public void updateContact(Contact contact){
        contactDao.updateContact(contact);
    }

    public void deleteContact(String id){
        contactDao.deleteContact(id);
    }

    public List<Contact> findAll(){
        List<Contact> list = contactDao.findAll();
        return list;
    }

    public Contact findById(String id){
        return contactDao.findById(id);
    }
}
