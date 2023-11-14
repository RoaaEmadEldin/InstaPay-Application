package Account.BillManager.Bill;

import java.util.ArrayList;
import java.util.Date;

public abstract class Bill {
    protected double price;
    protected Date dueDate;
    protected Providor providor;
    protected String id;

    public Bill(String id, double price, Date dueDate) {
        this.id = id;
        this.price = price;
        this.dueDate = dueDate;
    }

    public double getPrice() {
        return price;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Providor getProvidor() {
        return providor;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return providor + ": " + price + " -> " + dueDate;
    }
}
