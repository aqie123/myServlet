package games;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

public class GuessNumber extends HttpServlet {
    private int answer;
    private String msg;     // 用于存储竞猜结果
    private int count;      // 用于存储竞猜次数
    public GuessNumber(){
        genAnswer();
    }
    private void genAnswer(){
        // 生成10以内的随机数字
        Random random = new Random();
        answer = random.nextInt(11);
        msg = "";
        count = 0;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        resp.getWriter().write("guessGame!!!");
        // 接收用户传入数据
        String number = req.getParameter("lucky");
        String userCount = req.getParameter("count");
        if(userCount!=null && !(userCount.equals(""))){
            this.count = Integer.parseInt(userCount);
            count++;
        }
        // 转型
        if(number != null && !(number.equals(""))){
            if(count < 3){
                int lucky = Integer.parseInt(number);
                // 和answer比较
                if(lucky > answer){
                    msg = "big";
                }else if(lucky < answer){
                    msg = "small";
                }else{
                    msg = "you got it";
                    genAnswer();
                }
            }else{
                msg = "次数超过5次，请重新开始";
                genAnswer();
            }

            // 结果存进域对象中
            req.setAttribute("msg",msg);
            req.setAttribute("answer",answer);
            req.setAttribute("count",count);
            req.setAttribute("countMsg","You have "+(2-count)+"time to guess!");
            // 转发
            req.getRequestDispatcher("/games/guessNumber.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
