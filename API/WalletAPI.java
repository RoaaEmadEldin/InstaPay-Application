package API;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WalletAPI {
    private static List<Map<String, Object>> users = new ArrayList<>() {
        {
            add(createUserAccount("5", "Smith", "12345678905", 5000));
            add(createUserAccount("6", "Michael", "12345678906", 6000));
            add(createUserAccount("7", "Elenoise", "12345678907", 7000));
            add(createUserAccount("8", "Eva", "12345678908", 8000));
        }
    };

    public static Map<String, Object> getUser(String key, Object value) {
        for (Map<String, Object> user : users) {
            if (user.get(key).equals(value))
                return user;
        }
        return null;
    }

    private static Map<String, Object> createUserAccount(String id, String name, String phoneNumber,
            double balance) {
        Map<String, Object> user = new HashMap<>();
        user.put("id", id);
        user.put("name", name);
        user.put("phoneNumber", phoneNumber);
        user.put("balance", balance);
        return user;
    }
};
