package contacts;

import java.util.List;

public interface MenuHandler {
    List<String> listFields();

    void changeField(String field, String value);

    String getField(String field);
}
