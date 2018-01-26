package entity;

import ReflectionOfGeneric.Column;
import ReflectionOfGeneric.Table;

@Table(tableName = "lion_list")
public class Lion {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "lid")
    private int id;
    @Column(name = "lname")
    private String name;

    @Override
    public String toString() {
        return "nicky name: "+name;
    }
}
