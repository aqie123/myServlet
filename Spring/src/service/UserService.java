package service;

import dao.UserDao;

public class UserService {
    private UserDao userDao = new UserDao();

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(){
        userDao.save();
    }
}
