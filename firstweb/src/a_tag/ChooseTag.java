package a_tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class ChooseTag extends SimpleTagSupport {
    private Boolean flag = false;
    public void setFlag(Boolean flag){
        this.flag = flag;
    }

    public Boolean getFlag() {
        return flag;
    }

    @Override
    public void doTag() throws JspException, IOException {
        // 输出标签体内容
        this.getJspBody().invoke(null);
    }
}
