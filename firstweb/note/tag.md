一：自定义标签 步骤
    1. 编写标签处理程序,继承SimpleTagSupport类,覆盖doTag类
    2. WEB-INF目录建立tld文件,tld声明标签库信息,以及标签信息
    3. jsp 顶部导入标签库，使用标签库内容
二：自定义标签生命周期
    1. a_tag.HelloTag 演示生命周期
    2.构造方法！
      setJspContext 方法
      setParent 方法
      setJspBody 方法
      执行hello Tag标签 doTag方法
    3.构造方法！
      setJspContext 方法
      执行hello Tag标签 doTag方法
三：自定义标签作用
    1.控制标签体内容是否输出
        输出：jspBody.invoke(null);
    2.控制标签后面内容是否输出
        不输出：throw  new SkipPageException();
    3.重复控制标签体内容输出
        添加for循环
    4.改变标签体内容输出
        1. 得到标签体内容
        2. 修改内容
        3. 输出修改后内容
四： 带属性的自定义标签  customTag/bird.jsp
    1. BirdTag.java 定义 public void setNum(int num)
    2. 在ip.tld 配置属性
五：tld配置
    1.body-content：
        JSP:表示标签体内容可以支持和输出jsp表达式内容(只能在传统标签使用)
        scriptless：标签体内容不支持jsp表达式内容
            1.不支持 ：<%="hello"%>
            2.支持 EL表达式
        empty: 标签体内容为空<该标签为空标签
        tagdependent:标签体内容支持jsp表达式,不输出jsp表达式内容,当字符串处理
六：应用
    1.高仿核心标签库
        1.if
        2.choose
        3.foreach
        4.
    2.