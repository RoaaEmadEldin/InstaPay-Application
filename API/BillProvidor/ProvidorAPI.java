package API.BillProvidor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Account.BillManager.Bill.Bill;

public abstract class ProvidorAPI {
    protected Map<String, List<Bill>> bills;
    ProvidorAPI THIS;

    public ProvidorAPI() {
        this.THIS = this;
        this.bills = new HashMap<String, List<Bill>>();
        loadBillsData();
    }

    protected void parseBillsData(Map<String, List<Bill>> billsData) {
        for (Map.Entry<String, List<Bill>> user : billsData.entrySet()) {
            if (bills.get(user.getKey()) == null)
                bills.put(user.getKey(), new ArrayList<Bill>());

            for (Bill bill : user.getValue()) {
                bills.get(user.getKey()).add(bill);
            }
        }
    }

    public List<Bill> getBills(String phoneNumber) {
        return bills.get(phoneNumber);
    };

    public Boolean payBill(String phoneNumber, String billID) {
        List<Bill> userBills = bills.get(phoneNumber);
        if (userBills != null) {
            for (Bill bill : userBills) {
                if (bill.getId().equals(billID)) {
                    userBills.remove(bill);
                    return true;
                }
            }
        }
        return false;
    };

    protected abstract void loadBillsData();
}
