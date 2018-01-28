一：框架简介
    1.Struts 基于MVC模式的应用层框架
        作为控制层组件 ： javabean jsp
    2.Hibernate : 持久层组件，简化jdbc操作
    3.Controller(struts/Action) -> Service(业务逻辑 事务控制) ->Dao(数据访问 Hibernate/Session)
二：spring 框架
    1. 六大模块功能
        1.IOC容器, 解决对象创建及依赖关系
        2.Spring Web Spring对web模块的支持。 
          可以与struts整合,让struts的action创建交给spring
          spring mvc模式
        3.Spring DAO Spring 对jdbc操作的支持 【JdbcTemplate模板工具类】
        4.Spring ORM spring对orm的支持： 
          既可以与hibernate整合，【session】
          也可以使用spring的对hibernate操作的封装
        5.Spring AOP 切面编程
        6.SpringEE spring 对javaEE其他模块的支持
    2.专业术语
        1.高内聚,低耦合：类内部关系越来越紧密,类与类关系越少越好
        2.侵入式设计：引入组件对现有类结构有影响 (Struts)
        3.非侵入式设计：(Hibernate,Spring)
        4.IOC : inversion of control 控制反转 ： 自己不创建,交给外部容器创建
                IOC容器 = bean.xml 配置 + ApplicationContext 容器类
                User user = new User(); 自己控制对象创建                
        5.dependency injection 依赖注入
            创建对象后,处理对象的依赖关系
            User user = new User();
            user.setAddress(); // 创建用户对象，先创建地址对象
    3.应用
        1. 解决项目中如何创建对象