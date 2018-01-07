一：JavaBean规范
    1.类规则
        1.必须有无参的构造方法
        2.类的属性私有化
        3.提供公共的get和set方法 
        (特例布尔 public boolean isTest())
    2.使用场景
        1.项目实体对象符合javabean规范
        2. EL表达式,访问对象属性${user.name} 调用getName
        3.自定义标签给标签属性赋值
        4.jsp页面使用
    3.作用
        1.用于封装业务数据
二：web开发模式
    1.jsp+JavaBean  用户->jsp->javabean->db
    2.jsp+servlet+javaBean 
        用户->jsp(展示页面)V->servlet(接收数据,处理业务逻辑,获取数据,跳转页面)C->javaBean(封装业务数据)M
    3.
三：MVC
    1.
    2.