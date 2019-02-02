package BussinessLogic;

import ProductValidator.CategoryValidator;
import ProductValidator.DiscountValidator;

import java.util.ArrayList;
import java.util.List;

import static BussinessLogic.DataBaseInterface.productDataBase;


public class CategoryGroupDiscountModifier {
    private List<String> feedbackMessageArray;
    private DiscountValidator discountValidator;
    private CategoryValidator categoryValidator;

    public CategoryGroupDiscountModifier(){
        feedbackMessageArray = new ArrayList<>();
        discountValidator = new DiscountValidator();
        categoryValidator = new CategoryValidator();
    }


    private Product.Builder generateBuilderAsProduct(Product product){
        Product.Builder productBuilder = new Product.Builder();

        productBuilder.setName(product.getName());
        productBuilder.setPrice(product.getPrice().toString());
        productBuilder.setCategory(product.getCategory().toString());
        productBuilder.setId(product.getId());
        productBuilder.setDiscount(product.getDiscount().toString());
        productBuilder.setDescription(product.getDescriprion());

        return productBuilder;
    }


    private Product setDiscount(Product product, String discount){
        Product.Builder productBuilder = generateBuilderAsProduct(product);
        productBuilder.setDiscount(discount);
        return productBuilder.build();
    }


    public List<String> modifyDiscount(String categoryString, String discountString) throws IllegalArgumentException {
        List<Product> productList;
        feedbackMessageArray.clear();
        categoryValidator.validate(categoryString);
        discountValidator.validate(discountString);

        productList = productDataBase.findByCategory(Cat.valueOf(categoryString));

        if((productList.size() > 0) && (productList != null)) {
            for (Product product : productList) {
                productDataBase.save(setDiscount(product, discountString));
            }
            feedbackMessageArray.add("Discount successfully updated to " + discountString + "% in " + productList.size() + " products.");
        } else {
            feedbackMessageArray.add("No products found with category " + categoryString);
        }

        return feedbackMessageArray;
    }
}
