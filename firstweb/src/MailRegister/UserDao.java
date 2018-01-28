package MailRegister;

import mysql.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.UUID;

/**
 * 邮箱注册保存用户信息
 */
public class UserDao {
    private QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
    public void save(User_list user){
        try {
            qr.update("insert into user_list(id,name,password,email,status,validateCode,create_time) values(?,?,?,?,?,?,?)",
                    new Object[]{
                        user.getId(),
                        user.getName(),
                        user.getPassword(),
                        user.getEmail(),
                        0,
                        user.getValidateCode(),
                        user.getCreate_time()
                    });
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void update(String id){
        try {
            qr.update("update user_list set status = 1 where id=?",new Object[]{id});
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    // 根据随机验证码查找用户
    public User_list queryUser(String code){
        try {
            return (User_list)qr.query("select * from user_list where validateCode=?",
                    new BeanHandler<>(User_list.class), new Object[]{code});
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private String uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
