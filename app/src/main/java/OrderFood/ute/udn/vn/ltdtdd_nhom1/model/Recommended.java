
package OrderFood.ute.udn.vn.ltdtdd_nhom1.model;

public class Recommended {

//    @SerializedName("name")
//    @Expose
    private String name;
//    @SerializedName("imageUrl")
//    @Expose
    private int imageUrl;
//    @SerializedName("rating")
//    @Expose
    private String rating;
//    @SerializedName("deliveryTime")
//    @Expose
    private String deliveryTime;
//    @SerializedName("deliveryCharges")
//    @Expose
    private String deliveryCharges;
//    @SerializedName("price")
//    @Expose
    private String price;
//    @SerializedName("note")
//    @Expose
    private String note;

    public Recommended(String name, int imageUrl, String rating, String deliveryTime, String deliveryCharges, String price, String note) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.deliveryTime = deliveryTime;
        this.deliveryCharges = deliveryCharges;
        this.price = price;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(String deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
