package OrderFood.ute.udn.vn.ltdtdd_nhom1.model;

public class Categories {

    String name;
    Integer imageUrl;

    public Categories(String name, Integer imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public Categories() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}
