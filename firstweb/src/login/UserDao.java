package login;

import libs.PublicFunctions;
import org.dom4j.Document;
import org.dom4j.Element;

public class UserDao {
    public User findByName(String name){
        // 1. 读取xml文件
        String fileName = "firstweb/src/login/users.xml";
        Document doc = PublicFunctions.readXml(fileName);
        // 2.查询是否存在name标签 指定文本的内容
        String xpath = "//name[text()='"+name+"']";
        Element nameElem = (Element) doc.selectSingleNode(xpath);
        User user = null;
        if(nameElem != null){
            user = new User();
            // 把user标签信息封装到user对象
            Element userElem = nameElem.getParent();
            user.setId(userElem.attributeValue("id"));
            user.setName(userElem.elementText("name"));
            user.setPassword(userElem.elementText("password"));
        }
        return user;
    }
}
