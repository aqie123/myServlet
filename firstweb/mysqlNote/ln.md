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
        5.执行SQL语句 (DDL+DML : executeUpdate(sql))
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
    2.
            