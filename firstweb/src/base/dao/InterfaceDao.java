package base.dao;

import base.entity.Contact;

import java.util.List;

// 联系人接口
public interface InterfaceDao {
    public void addContact(Contact contact);
    public void updateContact(Contact contact);
    public void deleteContact(String id);
    public List<Contact> findAll();
    public Contact findById(String id);

    public boolean checkNameExist(String name);
}
