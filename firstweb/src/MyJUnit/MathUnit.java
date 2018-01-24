package MyJUnit;

public class MathUnit {
    public int add(int a, int b){
        return a+b;
    }
    public double devision(int a,int b){
        return a/b;
    }
}

class MathDriver{
    public static void main(String[] args) {
        testAdd();
        testDevision();
    }

    private static void testDevision() {
        MathUnit mj = new MathUnit();
        double result = mj.devision(6,3);
        if(result != 2){
            throw new RuntimeException("除法 错误数据");
        }
    }

    private static void testAdd() {
        MathUnit mj = new MathUnit();
        int result = mj.add(3,4);
        if(result != 7){
            throw new RuntimeException("加法 错误数据");
        }
    }
}