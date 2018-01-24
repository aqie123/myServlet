package MyEnum;

/**
 *  Enum 类评定成绩
 */
public class EvaluatePerformance {
    public static void main(String[] args) {
        // printScore();
        printGrade(Grade.D);
    }
    // 打印成绩 ABCD
    public static void printScore(){
        System.out.println(Score.A);
        System.out.println(Score.B);
        System.out.println(Grade.C);
        System.out.println(Grade.D);
    }
    // 根据分数段打印成绩
    public static void printGrade(Grade g){
        System.out.println(g.getScoreSection());
        /**
         * 得到枚举类中所有的值,每个类型都有一个values()方法
         */
        Grade[] arr = Grade.values();
        for(Grade grade : arr){
            System.out.println(grade);
        }
    }
}

class Score{
    // 1.私有化构造方法,不让构造对象
    public static final Score A = new Score("A");
    public static final Score B = new Score("B");
    public static final Score C = new Score("C");
    public static final Score D = new Score("D");

    public String score;
    private Score(String score){
        this.score = score;
    }

    @Override
    public String toString() {
        return this.score;
    }
}

enum Grade{
    // 带参数构造函数
    A("100-90"),B("89-70"),C("69-60"),D("59-40");

    private String scoreSection;
    private Grade(String scoreSection){
        this.scoreSection = scoreSection;
    }

    public String getScoreSection() {
        return scoreSection;
    }

    public void setScoreSection(String scoreSection) {
        this.scoreSection = scoreSection;
    }
}