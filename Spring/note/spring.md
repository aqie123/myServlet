一：note
    1. UserAction : 判断一个类是单例还是多例,
        a.有维护成员变量,且对成员变量进行修改 是多例，反之单例
        b.提供set方法,给外部调用
       UserService : 单例,启动时创建
       UserDao :单例