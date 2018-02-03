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
        2.spring-beans-4.3.14.RELEASE :                          spring源码,bean节点管理
        3.spring-context-4.3.14.RELEASE：                        spring上下文
        4.spring-core-4.3.14.RELEASE:                            IOC容器
        5.spring-expression-4.3.14.RELEASE：                     spring 表达式
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
    2. 处理依赖关系
        1.set方法注入
        2.内部bean
        3.p名称空间
        4.自动装配
        5.注解
            1.dao->service->action 添加component
            2.service 添加 
五：依赖注入注意
    1.name：对应的set属性
    2.ref : 对应的id值
六：自动装配
    1.autowire="byName" 根据名称自动装配,会去容器找指定名称的对象
    2.default-autowire="byType"  配置到全局
      当前所有的bean都采用”根据类型自动装配“
    3.配置到bean节点
        autowire="byName"  根据名称自动装配， 会去容器找指定名称的对象，注入到set方法的参数中！
        autowire="byType"  根据类型自动装配, 要确保改类型对应的对象在IOC容器中唯一，否则报错！
七：注解总结：
  @Component  表示一个组件(类)，把当前组件加入ioc容器
             加入容器的组件的名称默认是类名第一个字母小写
  @Component(“”)   指定加入ioc容器的组件类的类名
  
  @Repository    标识是一个持久层的组件
  		@Service       标识是一个业务逻辑层的组件
  @Controller     标识是一个控制层的组件
  
  @Scope("prototype")	指定对象单例/多例
  @Resource   1. 默认根据修饰的字段名称会取ioc容器找对象自动注入
  				找到后注入
  			  2. 如果名称没有找到，再根据类型查找  找到后就立刻注入  
  			     如果改类型在ioc容器中有多个对象，报错！
  			  3. 根据类型也没有找到对象，报错！		
  @Resource(name =””) 会根据指定的名称去容器找对象自动注入
八： 代理模式(Proxy) : 通过代理访问目标对象  【手动AOP】
    1.java 中代理
        a.静态代理
            1.特点
                1. 目标对象必须要实现接口
                2. 代理对象，要实现与目标对象一样的接口
            2.缺点
                1.需要依赖目标对象的接口，接口变化引发一系列变化
                2.对每一个代理类都要写一个代理类,麻烦
        b.动态代理(jdk代理):通过jdk的api在运行期间，动态的生成代理对象
            1. 目标对象一定要实现接口,代理对象不用实现接口
            2. newProxyInstance(loader,interface,h)
                loader:当前目标对象使用的类加载器
                interface:当前目标对象实现的接口
                h:接口类型,事件处理器
                当执行目标对象方法时,会触发事件,把当前执行的方法，传入事件
                处理器方法参数中,根据业务逻辑,判断是否执行目标对象方法或扩展功能
            3.动态代理对象必须实现一个或多个接口
        c.Cglib 代理(Spring 默认) : 目标对象没有实现接口
            1.目标对象可以不实现接口
            2.目标类不能为final，final报错
            3.方法为final/static 不会被代理拦截
九：AOP(Aspect Object Programming) 模式：(  a.分离业务代码和关注点代码,(jdk/cglib 代理)
                 b.关注点代码，写一次,执行业务代码时动态植入关注点代码
                 c. 切面：关注点代码形成的类，叫做切面
                 d. springAop编程,也叫面向切面编程
                )
    1.手动实现aop编程       myProxy
        a.UserDao->TransactionAop->bean.xml(开启注解扫描)->App
        b.AdminDao->ProxyFactory->bean.xml()
    2.spring AOP注解方式(实现AOP编程)     myAOP.AnnotationAop   bean2.xml  
        1. 
        2.
    3.Spring Aop XML配置实现AOP编程
        1.
        2.
    4.切入点表达式：
        1.Spring 在初始化容器时,会根据切入点表达式规则,符合拦截规则的方法
                        所在的类生成代理对象
        2.拦截方法,给方法所在的类，生成代理对象 
        3.语法 
            execution(
            modifiers-pattern?   				拦截的方法的访问修饰符
            ret-type-pattern                   方法返回类型，必须指定
            declaring-type-pattern?             拦截的方法所在的类
            name-pattern(param-pattern)       拦截的方法（以及方法的参数列表）
            throws-pattern?)                  方法声明的异常
        4.拦截，一定要指定到方法！     
    5.aop 编程步骤
        1. 引入aop相关jar文件,(aopalliance-1.0,spring-aop-4.3.14.RELEASE,aspectjrt,aspectjweaver)
        2. 引入aop名称空间
        3. 开启注解扫描
        4. 开启aop注解
    6.使用Aop相关注解     
      @Aspect      指定一个类为切面类
      				（切面类也需要实例化）
      				（切面类中的方法，也叫做通知）
      @Before	       前置通知  【在执行目标对象方法之前执行】
      @After			   后置通知  【在执行目标对象方法之后执行】
      @AfterReturning    返回后通知  【在执行目标对象方法结束后执行， 出现异常不执行】
      @AfterThrowing    异常通知   【在执行目标对象方法出现异常时候执行】
      @Around          环绕通知   【环绕目标方法执行】      
      @Pointcut      定义一个切入点表达式变量  （后面使用这个切入点表达式的时候，直接引用方法名即可）
    7.Spring生成代理对象的过程？
        1. 创建容器对象的时候， 根据“切入点表达式”拦截的类，生成代理对象；
        2. 如果目标对象有实现接口，使用jdk代理！
        3. 如果目标对象没有实现接口，使用cglib代理！
        4. 从容器获取代理后的对象
        5. 执行代理对象的方法，在运行时期，动态植入“切面”类中的“通知”!
    8.切面应用
        1.事务
        2.权限控制
        3.日志
    9. note
        1. SpringAop 编程,如果目标对象有实现接口,
            符合切入点表达式的类,从容器获取对象时,一定要通过接口接收
        2. 目标对象没有实现接口,使用cglib代理
        3. 目标对象未实现接口,且为final,不能使用aop编程
十：spring 对jdbc模块支持
        1.jar文件
            1.spring-jdbc-4.3.14.RELEASE        工具包类
            2.spring-tx-4.3.14.RELEASE          事务支持依赖包
            3.mysql-connector-java.jar : Class.forName("com.mysql.jdbc.Driver");
            4.导入包 commons-pool-1.5.6.jar  commons-dbcp-1.4.jar
        2.开发步骤
            1. 原始的jdbc操作代码
                1.mysql-connector-java.jar
            2. 对连接管理
                1. c3p0-0.9.5.2.jar
                2. 
            3. 对jdbc操作进行简化
               JdbcTemplate  工具类Api
              JdbcTemplate与DataSource依赖关系
                1.创建JdbcTemplate对象.实例化 JdbcTemplate 和
                2. 加载Properties配置文件,修改 <bean id="dataSource"
        3. 重点
            1. Aop, xml配置方式实现
        	2. Aop, 注解方式实现
        	3. 三种代理模式，练习
        	4. Spring 对jdbc支持
十一：快捷键
    1.Win+D或者Win+L