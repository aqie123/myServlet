package libs;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// 公用方法
public class PublicFunctions {

    // 传入document对象,写出到xml文件中
    public static void write2Xml(String fileName,Document doc){
        try {
            OutputStream outputStream = new FileOutputStream(fileName);
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("utf-8");
            XMLWriter writer = new XMLWriter(outputStream,format);
            writer.write(doc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 创建xml读取对象
    public static Document readXml(String fileName){
        SAXReader reader = new SAXReader();
        Document doc;
        try {
            // "firstweb/src/cookie/product.xml"
            doc =  reader.read(new File(fileName));
            return doc;
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
