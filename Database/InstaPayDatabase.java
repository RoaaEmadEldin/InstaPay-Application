package Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InstaPayDatabase implements ORM {
    private List<Map<String, Object>> accounts = new ArrayList<>();

    @Override
    public void add(Map<String, Object> newMap) {
        accounts.add(newMap);
    }

    @Override
    public Map<String, Object> get(String key, Object value) {
        for (Map<String, Object> account : accounts) {
            if (account.get(key).equals(value))
                return account;
        }
        return null;
    }

    @Override
    public Boolean update(String id, String targetKey, Object newValue) {
        Map<String, Object> account = get("id", id);
        if (account != null && account.get(targetKey) != null) {
            account.put(targetKey, newValue);
            return true;
        }
        return false;
    }
}
