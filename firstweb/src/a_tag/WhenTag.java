package a_tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class WhenTag extends SimpleTagSupport {
    private Boolean test = false;
    public void setTest(Boolean test){
        this.test = test;
    }
    @Override
    public void doTag() throws JspException, IOException {
        if(test){
            this.getJspBody().invoke(null);
        }
        // 得到父标签
        ChooseTag parentTag = (ChooseTag) this.getParent();
        parentTag.setFlag(test);

    }
}
