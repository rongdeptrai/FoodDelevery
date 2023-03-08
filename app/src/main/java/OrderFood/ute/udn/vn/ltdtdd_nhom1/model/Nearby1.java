package OrderFood.ute.udn.vn.ltdtdd_nhom1.model;

public class Nearby1 {
     String nameStore;
     String location;
    String rating;
    private String reviewers;
    int time;
   int distance;
   int imageStore;

    public Nearby1(String nameStore, String location, String rating, int time, int distance, int imageStore, String reviewers) {
        this.nameStore = nameStore;
        this.location = location;
        this.rating = rating;
        this.time = time;
        this.distance = distance;
        this.imageStore = imageStore;
        this.reviewers=reviewers;
    }

    public String getNameStore() {
        return nameStore;
    }

    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getDistance() {
        return (int) distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getImageStore() {
        return imageStore;
    }

    public void setImageStore(int imageStore) {
        this.imageStore = imageStore;
    }

    public String getReviewers() {
        return reviewers;
    }

    public void setReviewers(String reviewers) {
        this.reviewers = reviewers;
    }
}
