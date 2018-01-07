package a_tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class ParentTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        // 执行输出标签体内容
        this.getJspBody().invoke(null);
    }
}
