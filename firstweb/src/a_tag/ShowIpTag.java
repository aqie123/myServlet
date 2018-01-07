package a_tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * 自定义标签处理程序
 */
public class ShowIpTag extends SimpleTagSupport{
    // 用于设置 pageContext对象   JspContext 是 pageContext父类
    // 实际传入的 pageContext对象
    /*private JspContext jspContext;
    @Override
    public void setJspContext(JspContext pc) {
        this.jspContext = pc;
    }*/

    @Override
    public void doTag() throws JspException, IOException {
        // 1.获取客户端ip
        PageContext pageContext = (PageContext) this.getJspContext();
        // 2.通过pageContext获取其他八个内置对象
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        String ip = request.getRemoteHost();
        // 3.把ip输出到浏览器
        JspWriter out = pageContext.getOut();
        out.write("Current Client Ip is " +ip);

    }
}
