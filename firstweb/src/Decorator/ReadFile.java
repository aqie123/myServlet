package Decorator;

import java.io.*;

public class ReadFile {
    public static void main(String[] args) {
        read();
    }
    // 使用BufferedReader读取一个文件
    public static void read(){
        String fileName = "firstweb/src/Decorator/a.txt";
        String str = null;
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            LineBuffered lb = new LineBuffered(br);
            while((str = lb.readLine()) != null){
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 需求：在每行前加上行号
}

class LineBuffered extends BufferedReader{
    private BufferedReader bufferedReader;
    int i = 1;
    public LineBuffered(Reader in) {
        super(in);
        this.bufferedReader = (BufferedReader) in;
    }

    @Override
    public String readLine() throws IOException {
        String content =  super.readLine();
        if(content != null){
            content = i+ ":" +content;
            i++;
            return content;
        }
        return null;
    }
}