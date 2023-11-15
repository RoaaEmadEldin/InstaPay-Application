package Account.BillManager;

import java.util.ArrayList;
import java.util.List;

import API.BillProvidor.ProvidorAPI;
import API.BillProvidor.ProvidorsList;
import Account.BillManager.Bill.Bill;

public class BillManager {
    String registeredNumber;
    List<Bill> bills;
    List<ProvidorAPI> providors;

    public BillManager(String registeredNumber) {
        this.registeredNumber = registeredNumber;
        this.providors = ProvidorsList.BILL_PROVIDORS;
        this.bills = loadBills();
    }

    private List<Bill> loadBills() {
        List<Bill> tempBills = new ArrayList<>();
        for (ProvidorAPI providor : providors) {
            if (providor.getBills(registeredNumber) == null)
                continue;
            for (Bill bill : providor.getBills(registeredNumber)) {
                tempBills.add(bill);
            }
        }
        return tempBills;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public Boolean payBill(Bill bill) {
        if (!bill.getProvidor().payBill(registeredNumber, bill.getId()))
            return false;

        bills = loadBills();
        return true;
    }
}
