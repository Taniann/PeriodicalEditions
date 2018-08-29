package ua.tania.ann.auxiliary.entity;

import ua.tania.ann.model.entity.Edition;

import java.util.Set;

/**
 * Created by Таня on 29.08.2018.
 */
public class CartRecord {
    private static int idCounter = 0;
    private int id = 0;
    private Edition edition;
    private Double amount;
    private Set<String> months;

    public CartRecord(Edition edition, Double amount, Set<String> months) {
        idCounter++;
        this.id = idCounter;
        this.edition = edition;
        this.amount = amount;
        this.months = months;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Set<String> getMonths() {
        return months;
    }

    public void setMonths(Set<String> month) {
        this.months = month;
    }

    public int getId() {
        return id;
    }
}
