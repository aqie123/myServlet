package a_tag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.Writer;

public class HelloTag extends SimpleTagSupport {

    public HelloTag(){
        System.out.println("构造方法！");
    }

    @Override
    public void setJspContext(JspContext pc) {
        System.out.println("setJspContext 方法");
    }

    @Override
    public void setParent(JspTag parent) {
        System.out.println("setParent 方法");
    }

    @Override
    public void setJspBody(JspFragment jspBody) {
        System.out.println("setJspBody 方法");
    }

    @Override
    public void doTag() throws JspException, IOException {
        System.out.println("执行hello Tag标签 doTag方法"); // 常规输出
        // 1.控制标签体内容是否输出
        /*JspFragment jspBody = this.getJspBody();    // 得到标签体内容
        // 2.输出标签体内容(invoke(Writer writer) 把标签体内容往指定writer输出)
        JspWriter writer = this.getJspContext().getOut();
        // 向浏览器输出标签内容
        jspBody.invoke(writer);*/

    }
}
