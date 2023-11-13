package Database;

import java.util.Map;

public interface ORM {
    void add(Map<String, Object> newMap);

    Map<String, Object> get(String key, Object value);

    Boolean update(String id, String targetKey, Object newValue);

}
