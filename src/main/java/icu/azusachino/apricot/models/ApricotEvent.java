package icu.azusachino.apricot.models;

/**
 * @author haru
 * @date 2024-06-26 22:25
 */
public class ApricotEvent {

    private String id;
    private String key;
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
