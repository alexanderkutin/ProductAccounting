package BussinessLogic;

public class DTU {
    private String name;
    private String price;
    private String category;
    private String discount;
    private String description;
    private String id;

    public DTU() {
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id){
        this.id = id;
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getDiscount() {
        return discount;
    }

    public String getDescription() {
        return description;
    }

    public String getId() { return id; }
}
