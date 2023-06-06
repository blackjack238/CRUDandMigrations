package org.example;

public class LongestProject {
    public LongestProject(int id, int month_count) {
        this.id = id;
        this.month_count = month_count;
    }

    public int getId() {
        return id;
    }

    public int getMonth_count() {
        return month_count;
    }

    int id;
    int month_count;

    @Override
    public String toString() {
        return "LongestProject{" +
                "id=" + id +
                ", month_count=" + month_count +
                '}';
    }
}
