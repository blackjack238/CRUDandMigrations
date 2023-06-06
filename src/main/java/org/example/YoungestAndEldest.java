package org.example;

public class YoungestAndEldest {
    public YoungestAndEldest(String type, String name, String birthaday) {
        this.type = type;
        this.name = name;
        this.birthday = birthaday;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getBirthaday() {
        return birthday;
    }

    private String type;
    private String name;
    private String birthday;

    @Override
    public String toString() {
        return "YoungestAndEldest{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", birthaday='" + birthday + '\'' +
                '}';
    }
}
