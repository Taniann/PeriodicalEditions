package ua.tania.ann.model.entity;

import java.util.Arrays;
import java.util.Date;
import java.util.Set;

/**
 * Created by Таня on 25.08.2018.
 */
public class Subscription {
    private int id;
    private int userId;
    private int editionId;
    private String[] months;
    private Double amount;

    public Subscription(int id, int userId, int editionId, String[] months, Double amount) {
        this.id = id;
        this.userId = userId;
        this.editionId = editionId;
        this.months = months;
        this.amount = amount;
    }

    public Subscription(int userId, int editionId, String[] months, Double amount) {
        this.userId = userId;
        this.editionId = editionId;
        this.months = months;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getEditionId() {
        return editionId;
    }

    public void setEditionId(int editionId) {
        this.editionId = editionId;
    }

    public String[] getMonths() {
        return months;
    }

    public void setMonths(String[] months) {
        this.months = months;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMonthsForInsert() {
        String result = Arrays.toString(months).replace("[", "").replaceAll(" ", "").replace("]", "");
        return result;
    }
}
