package ua.tania.ann.model.entity;

/**
 * Created by Таня on 25.08.2018.
 */
public class Category {
    private int id;
    private String name;

    public Category(int id) {
        this.id = id;
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

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
}
