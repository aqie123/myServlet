package a_tag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ForeachTag extends SimpleTagSupport {
    private Object items;   // (List或Map)
    public void setItems(Object items){
        this.items = items;
    }

    public Object getItems() {
        return items;
    }

    private String var;     // 每个元素名
    public void setVar(String var){
        this.var = var;
    }
    @Override
    public void doTag() throws JspException, IOException {
        // 得到pageContext对象
        JspContext jspContext = this.getJspContext();
        PageContext pageContext = (PageContext)jspContext;
        /*
        // 如果是List,强转成List
        if(items instanceof List){
            List list = (List) items;
            // 遍历list
            for(Object obj:list){
                // 输出标签体内容
                // 将obj放入域对象中
                pageContext.setAttribute(var,obj);
                this.getJspBody().invoke(null);
            }
        }
        // 如果是Map
        if(items instanceof Map){
            Map map = (Map) items;
            // entrySet遍历
            Set entrySet = map.entrySet();
            for (Object obj:entrySet){
                pageContext.setAttribute(var,obj);
                this.getJspBody().invoke(null);
            }
        }
        */
        // List和Map数据转到Collection
        Collection collection = null;
        if(items instanceof List){
            collection = (List)items;
        }
        if(items instanceof Map){
            Map map = (Map)items;
            collection = map.entrySet();
        }
        for(Object obj:collection){
            pageContext.setAttribute(var,obj);
            this.getJspBody().invoke(null);
        }
    }
}
