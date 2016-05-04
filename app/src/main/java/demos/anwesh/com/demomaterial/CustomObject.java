package demos.anwesh.com.demomaterial;

/**
 * Created by anweshmishra on 04/05/16.
 */
public class CustomObject {
    private String name;
    private String url;
    public CustomObject(String name,String url) {
        this.name = name;
        this.url = url;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
