package API;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WalletAPI {
    private static List<Map<String, Object>> users = new ArrayList<>() {
        {
            add(createUserAccount("Smith", "12345678905", 5000));
            add(createUserAccount("Michael", "12345678906", 6000));
            add(createUserAccount("Elenoise", "12345678907", 7000));
            add(createUserAccount("Eva", "12345678908", 8000));
        }
    };

    public static Map<String, Object> getUser(String key, Object value) {
        for (Map<String, Object> user : users) {
            if (user.get(key).equals(value))
                return user;
        }
        return null;
    }

    public static Boolean setUserBalance(String phoneNumber, double balance) {
        for (Map<String, Object> user : users) {
            if (user.get("phoneNumber").equals(phoneNumber)) {
                user.put("balance", balance);
                return true;
            }
        }
        return false;
    }

    private static Map<String, Object> createUserAccount(String name, String phoneNumber,
            double balance) {
        Map<String, Object> user = new HashMap<>();
        user.put("name", name);
        user.put("phoneNumber", phoneNumber);
        user.put("balance", balance);
        return user;
    }

    public static Boolean exists(String phoneNumber) {
        for (Map<String, Object> user : users) {
            if (user.get("phoneNumber").equals(phoneNumber))
                return true;
        }
        return false;
    }
};
