package Account.BillManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import API.BillAPI.ElectricityAPI;
import API.BillAPI.GasAPI;
import API.BillAPI.WaterAPI;
import Account.BillManager.Bill.Bill;
import Account.BillManager.Bill.ElectricityBill;
import Account.BillManager.Bill.GasBill;
import Account.BillManager.Bill.Providor;
import Account.BillManager.Bill.WaterBill;

public class BillManager {
    String registeredNumber;
    List<Bill> bills;

    public BillManager(String registeredNumber) {
        this.registeredNumber = registeredNumber;
        this.bills = loadBills();
    }

    private List<Map<String, Object>> getBillsList(List<Map<String, Object>> list) {
        if (list == null)
            return new ArrayList<>();
        return list;
    }

    private List<Bill> loadBills() {
        List<Bill> tempBills = new ArrayList<>();
        List<Map<String, Object>> gasBills = getBillsList(GasAPI.getBills(registeredNumber));
        List<Map<String, Object>> waterBills = getBillsList(WaterAPI.getBills(registeredNumber));
        List<Map<String, Object>> electricityBills = getBillsList(ElectricityAPI.getBills(registeredNumber));

        for (Map<String, Object> bill : gasBills) {
            tempBills
                    .add(new GasBill((String) bill.get("id"), (double) bill.get("amount"), (Date) bill.get("dueDate")));
        }
        for (Map<String, Object> bill : waterBills) {
            tempBills.add(
                    new WaterBill((String) bill.get("id"), (double) bill.get("amount"), (Date) bill.get("dueDate")));
        }
        for (Map<String, Object> bill : electricityBills) {
            tempBills.add(new ElectricityBill((String) bill.get("id"), (double) bill.get("amount"),
                    (Date) bill.get("dueDate")));
        }
        return tempBills;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public Boolean payBill(Bill bill) {
        if (bill.getProvidor() == Providor.GAS)
            GasAPI.payBill(registeredNumber, bill.getId());
        if (bill.getProvidor() == Providor.WATER)
            WaterAPI.payBill(registeredNumber, bill.getId());
        if (bill.getProvidor() == Providor.Electricity)
            ElectricityAPI.payBill(registeredNumber, bill.getId());

        bills = loadBills();
        return true;
    }
}
