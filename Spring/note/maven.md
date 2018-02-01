一：Maven
    1.配置环境变量：
        a.%MAVEN_HOME%\bin : D:\Program Files\apache-maven-3.5.2
        b.MAVEN_OPTS : -Xms256m -Xmx512m
    2.配置 conf/setting.xml <localRepository>D:/gits/repo</localRepository>
    3. 命令行运行 ： mvn -version
二：MAVEN 演示
    1. Conversion Over Configuration (约定优于配置)
    --src
    ----main
    ------java : 存放Java文件
    ------resource : 用于存放资源文件
    ----test
    ------java : 存放测试Java的文件
    ------resources:
    --target : 项目输出位置,编译完毕后自动生成
    --pom.xml: 项目对象模型的描述
三：maven 相关网址
    1，http://blog.csdn.net/qq_32588349/article/details/51461182
    2.http://mvnrepository.com/