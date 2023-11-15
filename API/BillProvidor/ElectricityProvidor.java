package API.BillProvidor;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Account.BillManager.Bill.Bill;
import Account.BillManager.Bill.ElectricityBill;

public class ElectricityProvidor extends ProvidorAPI {
    public ElectricityProvidor() {
        super();
    }

    @Override
    protected void loadBillsData() {
        Map<String, List<Bill>> billsData = new HashMap<>() {
            {
                put("12345678901", new ArrayList<>() {
                    {
                        add(new ElectricityBill("1", 3000, new Date(), THIS));
                    }
                });
            }
            {
                put("12345678902", new ArrayList<>() {
                    {
                        add(new ElectricityBill("1", 300, new Date(), THIS));
                    }
                    {
                        add(new ElectricityBill("2", 100, new Date(), THIS));
                    }
                    {
                        add(new ElectricityBill("3", 150, new Date(), THIS));
                    }
                });
            }
            {
                put("12345678903", new ArrayList<>() {
                    {
                        add(new ElectricityBill("3", 150, new Date(), THIS));
                    }
                });
            }
            {
                put("12345678906", new ArrayList<>() {
                    {
                        add(new ElectricityBill("1", 300, new Date(), THIS));
                    }
                    {
                        add(new ElectricityBill("2", 100, new Date(), THIS));
                    }
                    {
                        add(new ElectricityBill("3", 150, new Date(), THIS));
                    }
                });
            }
        };

        setBills(billsData);
    }

    @Override
    public String toString() {
        return "Electricity Providor";
    }
};