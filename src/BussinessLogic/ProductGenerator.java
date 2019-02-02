package BussinessLogic;

import ProductValidator.*;

import java.util.ArrayList;
import java.util.List;

import static BussinessLogic.DataBaseInterface.productDataBase;


public class ProductGenerator {

    private Product.Builder productBuilder;
    private List<String> feedbackMessageArray;

    public ProductGenerator(){
        productBuilder = new Product.Builder();
        feedbackMessageArray = new ArrayList<>();
    }


    private void mandatoryFieldValidator(DTU dataTransferUnit) throws IllegalArgumentException {
        StringValidator stringValidator = new StringValidator();
        PriceValidator priceValidator = new PriceValidator();
        CategoryValidator categoryValidator = new CategoryValidator();

        stringValidator.validate(dataTransferUnit.getName());
        productBuilder.setName(dataTransferUnit.getName());

        priceValidator.validate(dataTransferUnit.getPrice());
        productBuilder.setPrice(dataTransferUnit.getPrice());

        categoryValidator.validate(dataTransferUnit.getCategory());
        productBuilder.setCategory(dataTransferUnit.getCategory());
    }


    private void optionalFieldValidator(DTU dataTransferUnit) {
        DiscountValidator discountValidator = new DiscountValidator();
        StringValidator stringValidator = new StringValidator();

        try {
            discountValidator.validate(dataTransferUnit.getDiscount());
            productBuilder.setDiscount(dataTransferUnit.getDiscount());
        } catch (IllegalArgumentException e) {
            feedbackMessageArray.add("WARNING!" + e.getMessage() + " Discount set to 0.");
        }

        try {
            stringValidator.validate(dataTransferUnit.getDescription());
            productBuilder.setDescription(dataTransferUnit.getDescription());
        } catch (IllegalArgumentException e) {
            feedbackMessageArray.add("WARNING! Description is empty.");
        }

    }


    public List<String> generate(DTU dataTransferUnit) throws IllegalArgumentException {
        Product builtProduct;
        feedbackMessageArray.clear();

        mandatoryFieldValidator(dataTransferUnit);
        optionalFieldValidator(dataTransferUnit);

        productBuilder.setId(ProductID.getNewID());
        builtProduct = productBuilder.build();
        productDataBase.save(builtProduct);

        feedbackMessageArray.add("Added new product with ID: " + builtProduct.getId());

        return feedbackMessageArray;
    }
}
