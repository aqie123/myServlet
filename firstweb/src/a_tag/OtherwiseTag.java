package a_tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class OtherwiseTag extends SimpleTagSupport {
    // 得到when标签test值
    Boolean test = false;
    @Override
    public void doTag() throws JspException, IOException {
        ChooseTag parentTag = (ChooseTag) this.getParent();
        test = parentTag.getFlag();
        // 根据test值
        if(!test){
            this.getJspBody().invoke(null);
        }

    }
}
