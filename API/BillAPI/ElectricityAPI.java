package API.BillAPI;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElectricityAPI {
    private static Map<String, List<Map<String, Object>>> bills = new HashMap<>() {
        {
            put("12345678901", new ArrayList<>() {
                {
                    add(createBill("1", 3000, new Date()));
                }
            });
        }
        {
            put("12345678902", new ArrayList<>() {
                {
                    add(createBill("1", 300, new Date()));
                }
                {
                    add(createBill("2", 100, new Date()));
                }
                {
                    add(createBill("3", 150, new Date()));
                }
            });
        }
        {
            put("12345678903", new ArrayList<>() {
                {
                    add(createBill("3", 150, new Date()));
                }
            });
        }
        {
            put("12345678906", new ArrayList<>() {
                {
                    add(createBill("1", 300, new Date()));
                }
                {
                    add(createBill("2", 100, new Date()));
                }
                {
                    add(createBill("3", 150, new Date()));
                }
            });
        }
    };

    public static List<Map<String, Object>> getBills(String phoneNumber) {
        return bills.get(phoneNumber);
    }

    public static Boolean payBill(String phoneNumber, String billID) {
        List<Map<String, Object>> userBills = bills.get(phoneNumber);
        if (userBills != null) {
            for (Map<String, Object> bill : userBills) {
                if (bill.get("id").equals(billID)) {
                    userBills.remove(bill);
                    return true;
                }
            }
        }
        return false;
    }

    private static Map<String, Object> createBill(String id, double amount, Date dueDate) {
        Map<String, Object> bill = new HashMap<>();
        bill.put("id", id);
        bill.put("amount", amount);
        bill.put("dueDate", dueDate);
        return bill;
    }
};
