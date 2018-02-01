package base.entity;

import ReflectionOfGeneric.Column;
import ReflectionOfGeneric.Table;

import java.util.Date;

@Table(tableName="student")
public class Student {
    @Column(name="sid")
    private int id;
    @Column(name="sname")
    private String name;
    @Column(name="sgender")
    private boolean gender;
    private double score;
    private Date birth;
    private int create_time;

    public Student(){}

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getBirth() {
        return birth;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getCreate_time() {
        return create_time;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "id: "+id + " name :"+name+" score: "+score+" birth "+birth;
    }
}
