package myProxy;

/**
 *  dao 静态代理类,对UserDao类功能扩展
 */
public class UserDaoProxy implements Dao{
    // 代理对象,内部维护被代理对象
    private Dao target = new UserDao();

    @Override
    public void save() {
        System.out.println("代理模式,开启事务！");
        target.save();
        System.out.println("代理模式,关闭事务！");
    }

    @Override
    public void find() {

    }
}
