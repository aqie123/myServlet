package myProxy;

public class App {
    public static void main(String[] args) {
        /*Dao proxy = new UserDaoProxy();
        proxy.save();*/

        // 创建目标对象（动态代理）
        Dao target = new AdminDao();
        /*
        System.out.println("目标对象 ："+target.getClass());
        Dao adminProxy = (Dao)new AdminDaoProxy(target).getTarget();
        System.out.println("代理对象： "+adminProxy.getClass());
        adminProxy.save();*/

        // Cglib
        AdminDao adminCglib = (AdminDao) new AdminCglib(target).getTarget();
        adminCglib.save();
        adminCglib.find();
    }
}
