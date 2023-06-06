package org.example;

public class ProjectPrice {
    public ProjectPrice(int id, int price) {
        this.id = id;
        this.price = price;
    }

    private int id;
    private int price;

    @Override
    public String toString() {
        return "projectPrice{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }
}
