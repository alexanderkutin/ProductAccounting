package BussinessLogic;

import ProductValidator.CategoryValidator;

import java.util.ArrayList;
import java.util.List;

import static BussinessLogic.DataBaseInterface.productDataBase;

public class OutputByCategory {
    private List<String> feedbackMessageArray;
    private CategoryValidator categoryValidator;
    private List<Product> productList;

    public OutputByCategory(){
        feedbackMessageArray = new ArrayList<>();
        categoryValidator = new CategoryValidator();
    }

    public List<String> getProductList(String categoryString) throws IllegalArgumentException {
        feedbackMessageArray.clear();
        categoryValidator.validate(categoryString);

        productList = productDataBase.findByCategory(Cat.valueOf(categoryString));

        if(productList.isEmpty()){
            feedbackMessageArray.add("No products with category: " + categoryString);
        } else {
            for (Product product : productList) {
                feedbackMessageArray.add(product.toString());
            }
        }

        return feedbackMessageArray;
    }
}
