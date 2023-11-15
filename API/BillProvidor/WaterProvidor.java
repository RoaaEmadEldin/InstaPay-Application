package API.BillProvidor;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Account.BillManager.Bill.Bill;
import Account.BillManager.Bill.WaterBill;

public class WaterProvidor extends ProvidorAPI {

    public WaterProvidor() {
        super();
    }

    @Override
    protected void loadBillsData() {
        Map<String, List<Bill>> billsData = new HashMap<>() {
            {
                put("12345678901", new ArrayList<>() {
                    {
                        add(new WaterBill("1", 300, new Date(), THIS));
                    }
                    {
                        add(new WaterBill("2", 100, new Date(), THIS));
                    }
                    {
                        add(new WaterBill("3", 150, new Date(), THIS));
                    }
                });
            }
            {
                put("12345678902", new ArrayList<>() {
                    {
                        add(new WaterBill("1", 300, new Date(), THIS));
                    }
                    {
                        add(new WaterBill("2", 100, new Date(), THIS));
                    }
                    {
                        add(new WaterBill("3", 150, new Date(), THIS));
                    }
                });
            }
            {
                put("12345678903", new ArrayList<>() {
                    {
                        add(new WaterBill("1", 300, new Date(), THIS));
                    }
                    {
                        add(new WaterBill("2", 100, new Date(), THIS));
                    }
                    {
                        add(new WaterBill("3", 150, new Date(), THIS));
                    }
                });
            }
            {
                put("12345678904", new ArrayList<>() {
                    {
                        add(new WaterBill("1", 300, new Date(), THIS));
                    }
                    {
                        add(new WaterBill("2", 100, new Date(), THIS));
                    }
                    {
                        add(new WaterBill("3", 150, new Date(), THIS));
                    }
                });
            }
        };

        setBills(billsData);
    }

    @Override
    public String toString() {
        return "Water Providor";
    }
};
