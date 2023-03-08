package OrderFood.ute.udn.vn.ltdtdd_nhom1.model;

public class Order_History {
    String restaurant_name;
    String food_name;
    String iteams;
    String time;
    int imageStore;

    public Order_History(String restaurant_name, String food_name, String iteams, String time, int imageStore) {
        this.restaurant_name = restaurant_name;
        this.food_name = food_name;
        this.iteams = iteams;
        this.time = time;
        this.imageStore = imageStore;
    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getIteams() {
        return iteams;
    }

    public void setIteams(String iteams) {
        this.iteams = iteams;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImageStore() {
        return imageStore;
    }

    public void setImageStore(int imageStore) {
        this.imageStore = imageStore;
    }
}
