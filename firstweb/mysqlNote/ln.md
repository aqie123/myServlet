一：mysql
    1.数据约束
    2.多表查询
    3.数据库设计
    4.存储过程
        1.保存在数据库服务端
        2.效率高
        3.移植性差
    5.触发器
    6.权限
    7.备份
二：JDBC
    1. 导入mysql-connector-java-5.1.7-bin.jar包
    2. finalConnection
    3. api
        1. Driver接口：驱动程序接口
            Connection connect() : 用于连接数据库的方法
        2. Connection接口：和数据库连接
            Statement createStatement() : 创建Statement接口对象
            PreparedStatement preparedStatement: 创建PreparedStatement接口对象
            CallableStatement prepareCall(String sql) : 创建 CallableStatement 对象
        |. Statement接口：用于执行静态sql语句
            int executeUpdate(String sql)  执行DDL和DML (更新SQL语句)
            ResultSet executeQuery(String sql) 执行DQL(查询SQL语句)
            |. PreparedStatement 接口:执行预编译SQL语句
                int executeUpdate(String sql)  执行DDL和DML (更新SQL语句)
                ResultSet executeQuery(String sql) 执行DQL(查询SQL语句)
                |. CallableStatement接口 ：执行存储过程的SQL语句
                    ResultSet executeQuery(String sql) 只能执行查询语句
        |. ResultSet 接口 ： 数据库结果集
            boolean next()  将光标移至下一行
            getXXX()    获取结果集中每列的值
    4. 步骤
        1.注册驱动程序
        2.获取连接对象
        3.准备SQL语句(DDL+)
        4.创建Statement对象
        5.执行SQL语句 (DDL+DML : )
            executeUpdate(sql) ：执行更新
            executeQuery(sql) : 执行查询
        6.返回结果,处理结果
        7.关闭资源
    5. ResultSet 对象
        1.对象具有指向当前数据行光标,开始光标置于第一行前
        2.next 将光标移动到下一行
        3.在ResultSet对象没有下一行时返回false,可在while循环迭代结果集
        4. rs.getString rs.getObject 获取查询结果
    6. statement 语句执行查询 Statements.java
    7. PrepareStatement执行CURD         PrepareStatement.java
        1. 执行预编译SQL语句
        2. ?:参数占位符
        3. 好处：可以利用数据库SQL缓存功能，执行效率高
            mysql:没有缓存
            oracle:有缓存
        4.既可以执行静态执行语句,也可以执行预编译语句
        5. 可以防止SQL注入
    8. 使用CallableStatement调用存储过程
        1.执行存储过程只能使用 statement.executeQuery()
        2.
三：note
    1.//测试是否实现了父类  
      boolean re1= Object.class.isAssignableFrom(IsAssignableFromTest.class);  
      //测试是否实现了接口  
      boolean re2=Serializable.class.isAssignableFrom(IsAssignableFromTest.class);  
    2. jdbc 读取配置文件路径
        1. D:\coreJava\myServlet\firstweb\src\mysql\JdbcUtil.java
    3. 读取本地字节文件
        1.发送数据内容超过字段长度限制,则抛出 Data too long ，修改字段类型
        2.发送数据超过1MB（修改my.ini max_allowed_packet=50N）
四：JDBC 批处理
    1.前提：jdbc 每次向服务器执行多次插入
    2.API
        1.Statement批处理
            1. void add Batch()  sql添加到缓存区(未发送)
            2. int[] executeBatch() 执行批处理缓存中SQL语句(数据库执行)
            3. void clearBatch() 清空缓存区SQL语句
        2.PreparedStatement
        3.mysql 不支持prepareStatement优化,也不支持批处理优化
        Innodb(88463) MYISAM(97846)
五:jdbc 处理大容量数据  JdbcText.java
    1. 存储字符内容：char varchar(65535)
    2. 大容量
        字符字段 text longtext(4G字符)
        字节字段 blob(65kb) mediumblob(16mb) longblog(4GB)
    3. 写入
    4. 读取
        1.text 字段可以当字符串读取
        2.text 当输入流读取
六：jdbc的clob和blob        JdbcText.java
    1. 完成文件的数据库写入读取 clob
    2. 完成图片的数据库写入读取 blob
七：获取自增长值   AutoIncrement.java
    1. RETURN_GENERATED_KEYS : 可以返回自增张生成值
    2. NO_GENERATED_KEYS    : 不返回
八：数据库事务 Transaction.java
    1.set autocommit = 1/0 
        0:关闭自动提交,开始事务
        1：自动提交,执行完均会提交(不可回滚)
         commit rollback
    2.事务四个特性
        1. 原子性（Atomicity）
        2. 一致性（Consistency）
        3. 隔离性（Isolation）
        4. 持久性（Durability）
    3. 事务事项
        1. 脏读
        2. 不可重复读
        3. 虚读(幻读)
    4. 四种隔离级别
        ① Serializable (串行化)：可避免脏读、不可重复读、幻读的发生。
    　　② Repeatable read (可重复读)：可避免脏读、不可重复读的发生。    
    　　③ Read committed (读已提交)：可避免脏读的发生。    
    　　④ Read uncommitted (读未提交)：最低级别，任何情况都无法保证。
    5. jdbc 
        1.connection.setAutoCommit(false);
        2.connection.commit();
        3.connection.rollback();
九：应用 通讯录
    1.开发顺序
        1. 设计数据库(联系人表)
        2. 编写dao接口实现类,jdbc操作联系人列表
        3. service层切换到实现类即可
        4.
    2.项目文件
        1.实体类： entity.Contact
        2.service：service.InterfaceService  service.ContactService  控制器
        3.Dao类：dao.ContactDao implements InterfaceDao              模型层      
        4.配置文件：configs/jdbc.properties
        5.web(Servlet):                                              视图层 Servlet
        6.异常exception: Exception.NameExistException
        7. view(jsp) ：view                                          视图层
    3.访问路径 实体类->Dao->Service->web(Servlet)->view(Jsp)
        1. http://localhost:8080/contact/list  不能直接访问jsp(带不过数据来)
十：连接池(connectionPool) 
    1.连接池要素
        1.初始化连接数
        2.最大连接数
    2.问题
        1.Connection 连接对象利用率低
        2.控制java程序连接数据库的并发连接次数(最大连接数)
        3.
    3. 自定义连接池工具 MyPool.java
    4. 使用代理模式重写Connection close 方法   
        1.MyPool2.java
        2.新建Connection静态代理类 
            Connection 接口实现类 MyConnection.java 
        3. 动态代理类 MyConnection2.java  MyPool3.java
    5.dbcp(DataBase Connection Pool) 连接池工具
        1.导入包 commons-pool-1.5.6.jar  commons-dbcp-1.4.jar
        2.BasicDataSource  连接池对象
    6.c3p0 连接池工具(框架hibernate内置连接池)
        1.c3p0-0.9.1.2.jar
    7._beanutils 工具
        1. 方便开发者操作javabean对象
        2.作用：
            1. 拷贝一个javabean对象属性
            2. 拷贝整个javabean对象(所有属性)
            3. 从一个map集合中拷贝到javabean对象中
        3.导入包
            commons-beanutils-1.8.3.jar
            commons-logging-1.1.3.jar
        4.注意
            1.拷贝的方法能自动将非String类型转换为对应类型的属性
            2.默认不支持字符串转date,手动注册一个日期转换器
            3.只拷贝javabean存在的属性(SetXXX)
            4.需要拷贝的数据时数组类型,只拷贝数组第一个
        6.应用 (http://localhost:8080//contact/list)
            1.优化 AddServlet
    8._dbutils工具
    