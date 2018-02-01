package base.dao;

import base.entity.Contact;
import mysql.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDao implements InterfaceDao{
    public void addContact(Contact contact){
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = JdbcUtil.getConnection();
            String sql = "insert into contact (name,gender,email,mobile,address) values(?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,contact.getName());
            statement.setString(2,contact.getGender());
            statement.setString(3,contact.getEmail());
            statement.setString(4,contact.getPhone());
            statement.setString(5,contact.getAddress());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JdbcUtil.close(statement,connection);
        }
    }

    public void updateContact(Contact contact){
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = JdbcUtil.getConnection();
            String sql = "update contact set name=?,gender=?,email=?,mobile=?,address=? where id=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,contact.getName());
            statement.setString(2,contact.getGender());
            statement.setString(3,contact.getEmail());
            statement.setString(4,contact.getPhone());
            statement.setString(5,contact.getAddress());
            statement.setString(6,contact.getId());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JdbcUtil.close(statement,connection);
        }
    }

    public void deleteContact(String id){
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = JdbcUtil.getConnection();
            String sql = "delete from contact where id=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,id);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JdbcUtil.close(statement,connection);
        }
    }

    public List<Contact> findAll(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = JdbcUtil.getConnection();
            String sql = "select * from contact";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            List<Contact> list = new ArrayList<>();
            while(resultSet.next()){
                Contact contact = new Contact();
                contact.setId(resultSet.getString("id"));
                contact.setName(resultSet.getString("name"));
                contact.setGender(resultSet.getString("gender"));
                contact.setEmail(resultSet.getString("email"));
                contact.setPhone(resultSet.getString("mobile"));
                contact.setAddress(resultSet.getString("address"));
                list.add(contact);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JdbcUtil.close(resultSet,statement,connection);
        }
    }

    public Contact findById(String id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = JdbcUtil.getConnection();
            String sql = "select * from contact where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,id);
            resultSet = statement.executeQuery();
            Contact contact = null;
            if(resultSet.next()){
                contact = new Contact();
                contact.setId(resultSet.getString("id"));
                contact.setName(resultSet.getString("name"));
                contact.setGender(resultSet.getString("gender"));
                contact.setEmail(resultSet.getString("email"));
                contact.setPhone(resultSet.getString("mobile"));
                contact.setAddress(resultSet.getString("address"));
            }
            return contact;
        }catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JdbcUtil.close(resultSet,statement,connection);
        }
    }

    public boolean checkNameExist(String name){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection = JdbcUtil.getConnection();
            String sql = "select * from contact where name = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            resultSet = statement.executeQuery();
            return resultSet.next();
        }catch(SQLException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JdbcUtil.close(resultSet,statement,connection);
        }
    }
}
