package a_tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

public class BirdTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        System.out.println("just do sth!");
        JspFragment jspBody = this.getJspBody();
        // 1.1创建StringWriter,用于存储标签体内容
        StringWriter sw = new StringWriter();
        // 1.2 标签体内容拷贝到StringWriter中
        jspBody.invoke(sw);
        // 1.3 得到StringWriter的内容
        String content = sw.toString();
        // 1.4 修改内容
        content = content.toUpperCase();
        // 1.5 输出修改后内容
        for (int i=0;i<num;i++){
            this.getJspContext().getOut().write(content);  // Perfect!
        }

        // 重复输出
        /*for(int i = 0;i<3;i++){
            jspBody.invoke(null);
        }
        throw  new SkipPageException();*/
    }

    private int num;
    public void setNum(int num){
        this.num = num;
    }
}
