package MyJUnit;

import entity.Child;
import org.junit.Assert;
import org.junit.Test;

/**
 *  测试数学单元
 */
public class TestMathJUnit {
    @Test
    public void testAdd(){
        System.out.println("注解 测试方法");
        MathUnit mu = new MathUnit();
        int result = mu.add(3,4);
        /*
        手动判定
        if(result != 7){
            throw new RuntimeException("加法 错误数据");
        }*/
        // 使用Assert断言类
        // Assert.assertEquals(5,result);  // (相等时测试通过)(可以比较对象内容,equals)
        Assert.assertSame(7,result);    // 相等时测试通过(比较对象内存地址,用==比较)
        // Assert.assertNotSame(5,result); // 不相等测试通过
    }
    @Test
    public void testDevision() {
        MathUnit mj = new MathUnit();
        double result = mj.devision(6,3);
        if(result != 2){
            throw new RuntimeException("除法 错误数据");
        }
    }
    // 测试 child是否相等
    @Test
    public void testChild(){
        Child child = new Child(1,"aqie");
        Child child1 = new Child(2,"aqie2");
        Child child2 = new Child(2,"aqie2");
        //Assert.assertSame(child,child1);
        // Assert.assertSame(child2,child1);     // 重写equals 还是不相等
        Assert.assertEquals(child2,child1);     // 重写equals 相等  2==1
        // Assert.assertEquals(child,child1);     // 重写equals 相等  1 != 2
    }
}
