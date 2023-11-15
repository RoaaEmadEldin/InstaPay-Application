package API.BillProvidor;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Account.BillManager.Bill.Bill;
import Account.BillManager.Bill.GasBill;

public class GasProvidor extends ProvidorAPI {
    private GasProvidor THIS = this;

    public GasProvidor() {
        super();
    }

    @Override
    protected void loadBillsData() {
        Map<String, List<Bill>> billsData = new HashMap<>() {
            {
                put("12345678904", new ArrayList<>() {
                    {
                        add(new GasBill("1", 300, new Date(), THIS));
                    }
                    {
                        add(new GasBill("2", 100, new Date(), THIS));
                    }
                    {
                        add(new GasBill("3", 150, new Date(), THIS));
                    }
                });
            }
            {
                put("12345678905", new ArrayList<>() {
                    {
                        add(new GasBill("1", 300, new Date(), THIS));
                    }
                    {
                        add(new GasBill("2", 100, new Date(), THIS));
                    }
                    {
                        add(new GasBill("3", 150, new Date(), THIS));
                    }
                });
            }
            {
                put("12345678906", new ArrayList<>() {
                    {
                        add(new GasBill("1", 300, new Date(), THIS));
                    }
                    {
                        add(new GasBill("2", 100, new Date(), THIS));
                    }
                    {
                        add(new GasBill("3", 150, new Date(), THIS));
                    }
                });
            }
            {
                put("12345678907", new ArrayList<>() {
                    {
                        add(new GasBill("1", 300, new Date(), THIS));
                    }
                    {
                        add(new GasBill("2", 100, new Date(), THIS));
                    }
                    {
                        add(new GasBill("3", 150, new Date(), THIS));
                    }
                });
            }
        };

        parseBillsData(billsData);
    }
};