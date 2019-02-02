package BussinessLogic;

import java.util.ArrayList;
import java.util.List;

import static BussinessLogic.DataBaseInterface.productDataBase;

public class AllProductOutput {
    private List<String> feedbackMessageArray;
    private List<Product> productList;

    public AllProductOutput(){
        feedbackMessageArray = new ArrayList<>();
    }

    public List<String> getProductList(){
        feedbackMessageArray.clear();
        productList = productDataBase.findAll();

        if(productList.isEmpty()){
            feedbackMessageArray.add("\nProduct list is empty!\n");
        } else {
            for (Product product : productList) {
                feedbackMessageArray.add(product.toString());
            }
        }

        return feedbackMessageArray;
    }

}
