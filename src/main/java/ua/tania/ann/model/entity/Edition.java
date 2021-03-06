package ua.tania.ann.model.entity;

/**
 * Created by Таня on 17.08.2018.
 */
public class Edition {
    private int id;
    private String name;
    private String info;
    private Double price;
    private String imageUrl;
    private String type;

    public Edition(int id, String name, String info, Double price, String imageUrl, String type) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.price = price;
        this.imageUrl = imageUrl;
        this.type = type;
    }

    public Edition(String name, String info, Double price, String imageUrl, String type) {
        this.name = name;
        this.info = info;
        this.price = price;
        this.imageUrl = imageUrl;
        this.type = type;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
