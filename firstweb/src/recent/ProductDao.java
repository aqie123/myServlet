package recent;

import libs.PublicFunctions;
import org.dom4j.Document;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    // 查看所有商品
    public List<Product> findAll(){
        // 1.读取xml文件
        Document doc = PublicFunctions.readXml("firstweb/src/login/users.xml");
        // 2.读取所有product标签
        List<Element> proList = null;
        try {
            proList = doc.getRootElement().elements("product");
        }catch(NullPointerException e){
            e.printStackTrace();
        }

        List<Product> list = new ArrayList<>();
        // 3.遍历
        if(proList != null){
            for(Element proElem : proList){
                Product p = getProduct(proElem);

                // 3.3 封装好对象放到List
                list.add(p);
            }
        }
        return list;
    }

    private Product getProduct(Element proElem) {
        // 3.1创建Product 对象
        Product p = new Product();
        // 3.2 product标签封装到Product对象中
        p.setId(proElem.attributeValue("id"));
        p.setName(proElem.elementText("name"));
        p.setType(proElem.elementText("type"));
        p.setPrice(proElem.elementText("price"));
        return p;
    }

    // 商品详情根据id
    public Product findById(String id){
        // 1.读取xml
        String fileName = "firstweb/src/cookie/product.xml";
        Document doc = PublicFunctions.readXml(fileName);
        // 2.查询指定id的Product标签
        Element proElem = (Element)doc.selectSingleNode("//product[@id='"+id+"']");
        // 3.封装Product对象
        Product p = null;
        if(proElem != null){
            p = getProduct(proElem);
        }
        return p;
    }
}
