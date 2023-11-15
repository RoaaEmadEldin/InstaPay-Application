package API;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankAPI {
    private static List<Map<String, Object>> users = new ArrayList<>() {
        {
            add(createUserAccount("1111 1111 1111 1111", "Sam", "12345678901", 1000));
            add(createUserAccount("2222 2222 2222 2222", "Mike", "12345678902", 2000));
            add(createUserAccount("3333 3333 3333 3333", "Elena", "12345678903", 3000));
            add(createUserAccount("4444 4444 4444 4444", "Eve", "12345678904", 4000));
        }
    };

    public static Map<String, Object> getUser(String key, Object value) {
        for (Map<String, Object> user : users) {
            if (user.get(key).equals(value))
                return user;
        }
        return null;
    }

    public static Boolean setUserBalance(String cardNumber, double balance) {
        for (Map<String, Object> user : users) {
            if (user.get("cardNumber").equals(cardNumber)) {
                user.put("balance", balance);
                return true;
            }
        }
        return false;
    }

    private static Map<String, Object> createUserAccount(String cardNumber, String name, String phoneNumber,
            double balance) {
        Map<String, Object> user = new HashMap<>();
        user.put("cardNumber", cardNumber);
        user.put("name", name);
        user.put("phoneNumber", phoneNumber);
        user.put("balance", balance);
        return user;
    }
};
