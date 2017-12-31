一：URLEncoder  URLDecode类  MyURLEncoder.java 对中文进行加密解密
    1. url加密
    2.
二：会话管理
    1.一次回话 打开浏览器->访问服务器->关闭浏览器
    2.context域会覆盖之前数据
    3.使用request域,一定要使用转发技术来跳转页面
    4.session
    5.cookie
三：cookie
    1.创建cookie对象 new Cookie();
    2.修改Cookie对象
        setPath()
        setMaxAge()
        setValue()
    3.cookie数据发送给浏览器保存
        response.add(cookie)
    4.浏览器带着cookie访问服务器,服务器接收
        request.getCookie();
四：session