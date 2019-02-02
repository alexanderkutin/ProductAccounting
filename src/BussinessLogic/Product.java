package BussinessLogic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Product {

    //Mandatory fields
    private String name;
    private BigDecimal price;
    private Cat category;
    private BigDecimal actualPrice;

    //Optional fields
    private BigDecimal discount;
    private String description;

    //ID
    private Long id;

    //Constructor
    public Product(){}

    public Product(String name, BigDecimal price, Cat category, BigDecimal discount, String description, Long id) {
        BigDecimal discountAmount = price.multiply(discount).scaleByPowerOfTen(-2);

        this.name = name;
        this.price = price.setScale(2, BigDecimal.ROUND_CEILING);
        this.category = category;
        this.discount = discount;
        this.description = description;

        this.actualPrice = price.subtract(discountAmount).setScale(2, BigDecimal.ROUND_HALF_EVEN);

        this.id = id;
    }

    //Getters Begin
    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Cat getCategory() {
        return category;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public String getDescriprion() {
        return description;
    }
    //Getters End


    //Builder Begin
    public static class Builder {

        private String name;
        private Long id;
        private BigDecimal price;
        private Cat category;
        private BigDecimal discount = new BigDecimal("0");
        private String description = "none";


        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setPrice(String price) {
            this.price = new BigDecimal(price);
            return this;
        }

        public Builder setCategory(String category) {
            this.category = Cat.valueOf(category);
            return this;
        }

        public Builder setDiscount(String discount) {
            this.discount = new BigDecimal(discount);
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Product build() {
            return new Product(name, price, category, discount, description, id);
        }
    }
    //Builder End


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                category == product.category &&
                Objects.equals(description, product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, category, discount, description, id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "Name:'" + name + '\'' +
                ", Price=" + price +
                ", Category=" + category +
                ", Discount=" + discount + "%" +
                ", Actual price=" + actualPrice +
                ", Description:'" + description + '\'' +
                ", ID=" + id +
                '}';
    }
}
