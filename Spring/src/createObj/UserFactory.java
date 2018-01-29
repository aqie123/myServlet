package createObj;

import entity.User;

public class UserFactory {
    // 非静态
    public User getInstance() {
        return new User(666,"工厂实例方法，创建对象");
    }

    // 静态
    public static User getStaticInstance() {
        return new User(888,"工厂静态方法，创建对象");
    }
}
