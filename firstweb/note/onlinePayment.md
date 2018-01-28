一：在线支付(易付宝支付)
    1.  正式商户编号：10001126856
        正式商户密钥：69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl
    2.支付宝，微信，易付宝，快钱，财务通，paypal
    3.onlinePayment/pay.jsp
    4.
二：发送邮件 email
    1. smtp 发送邮件
        1.远程连接到smtp服务器(telnet smtp.126.com 25   telnet smtp.163.com 25)
            1. EHLO aqie
            2. auth login
            3. 123456 smtp.163.com   aqie123aqie@163.com
            4. kkzl123456@126.com  qaz@
                1.a2t6bDEyMzQ1NkAxMjYuY29t
                2.UUFacWF6NzUzOTUxQA==
                3.YXFpZTEyM2FxaWVAMTYzLmNvbQ==
                  MTIzNDU2a3ps
                4.ZXJpY3h1XzEyMzQ1QDEyNi5jb20=
                  ZXJpYzEyMzQ1
            5.   telnet pop3.163.com 110    
                  user  aqie123aqie@163.com
                  pass  123456
        2.telnet : (http://blog.csdn.net/msq7487223/article/details/52366148)
    2. Javamail 发送邮件
        1.Session类：该类用于创建一个和邮箱服务器的连接和验证登录。
        2.MimeMessage类： 该类代表一封邮箱（收件人，发件人，主题，正文。。。）
        3.Transport类： 发送邮件 send（MimeMessage）： 发送邮件的方法。 
    3. 邮箱激活  mailRegister.java  user_list(表)
        1.mailReg.jsp -> 
           MailRegServlet(调用业务逻辑,保存用户信息,发送邮件给用户) ->
        2. MailRegister/MailActiveServlet : http://192.168.0.135:8080/mailActive  邮箱激活逻辑
        3. MailRegister/MailRegServlet ：http://192.168.0.135:8080/mailReg  邮箱注册逻辑
        4. http://192.168.0.135:8080/mailRegister/mailReg.jsp  邮箱注册界面
