package service;

import dao.UserDao;

public class UserService {
    // 接收IOC容器注入值
    private UserDao userDao = new UserDao();

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(){
        userDao.save();
    }
}
