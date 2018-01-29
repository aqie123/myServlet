一：note
    1. UserAction : 判断一个类是单例还是多例,
        a.有维护成员变量,且对成员变量进行修改 是多例，反之单例
        b.提供set方法,给外部调用
       UserService : 单例,启动时创建
       UserDao :单例
    2.java 基础(http://www.whucke.com/articles/2018/01/28/1517153852208.html)
    3. UserAction : IOC容器读取对象
    4. bean创建细节
    5. spring jar
        1.commons-logging-1.2 :
        2.spring-beans-4.3.14.RELEASE :spring源码,bean节点管理
        3.spring-context-4.3.14.RELEASE：spring上下文
        4.spring-core-4.3.14.RELEASE:IOC容器
        5.spring-expression-4.3.14.RELEASE：spring 表达式
    6.开发流程：
        引入jar->新建xml配置文件,引入约束->配置bean->测试
二：IOC容器
    1.id与name区别
        1. id不能以数字开头,不能含有特殊符号,不能有空格逗号
    2. 默认对象是单例的singleton,
    3. init-method="init" destroy-method="destory" : 单例才会执行销毁
    4. 销毁容器实例
    5. 单例对象，默认在创建容器时就创建所有单例,
       希望第一次访问时创建对象 lazy-init="true"
       多例： lazy-init无影响
    6.Bean声名周期
      singleton  单例
        1) 创建对象
             如果有配置延迟初始化，
                lazy-init=true  如果单例的对象有配置延迟初始化， 在创建容器之后，在第一次从容器获取对象的时候
             创建单例的对象！
            如果没有配置或延迟初始化为默认值, 单例的对象会在创建容器的时候创建对象
        2) 执行初始化方法 , init-method配置的方法会执行
        3) 调用容器destroy() 方法时候，容器在销毁单例对象的实例的时候，会调用destroy-method对应的方法
           此时bean对象会被销毁！      		   	  
      prototype  多例
         1) 每次在从容器获取对象的时候，都会创建新的对象
         2) 每次创建完对象后，就执行初始化方法
         3) java回回收不用资源(jvm gc)	
三：创建对象方式 (junit/bean.xml)
    1.调用无参的构造函数
    2.调用有参数构造函数
    3.工厂：
        静态
        非静态
四：处理对象的依赖关系 user5
    1.给对象属性赋值(DI 依赖注入)
        1) 构造函数赋值
        2) set 方法注入值
            1.普通字段赋值
            2.集合属性(list/map/property)
        3) 应用
            1.Dao/Service/Action实例,处理依赖关系
五：依赖注入注意
    1.name：对应的set属性
    2.ref : 对应的id值
六：自动装配
    1.
    2.