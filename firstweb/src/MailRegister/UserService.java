package MailRegister;

public class UserService {
    UserDao dao = new UserDao();
    // 用户注册
    public void reg(User_list user){
        dao.save(user);
    }
    public User_list queryUser(String code){
        return dao.queryUser(code);
    }
    // 用户激活
    public void active(String id){
        dao.update(id);
    }
}
