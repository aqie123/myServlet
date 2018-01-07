package a_tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class IfTag extends SimpleTagSupport {
    private Boolean test = false;
    public void setTest(Boolean test){
        this.test = test;
    }
    @Override
    public void doTag() throws JspException, IOException {
        JspFragment jspBody = this.getJspBody();
        if(test){
            jspBody.invoke(null);
        }
    }
}
