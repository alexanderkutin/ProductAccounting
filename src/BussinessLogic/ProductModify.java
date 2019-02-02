package BussinessLogic;

import ProductValidator.*;

import java.util.ArrayList;
import java.util.List;

import static BussinessLogic.DataBaseInterface.productDataBase;


public class ProductModify {

    private Product.Builder productBuilder;
    private List<String> feedbackMessageArray;
    private Product productToModify;

    public ProductModify(){
        productBuilder = new Product.Builder();
        feedbackMessageArray = new ArrayList<>();
    }

    private void setBuilderFieldsAsProduct(){
        if(productToModify != null) {
            productBuilder.setName(productToModify.getName());
            productBuilder.setPrice(productToModify.getPrice().toString());
            productBuilder.setCategory(productToModify.getCategory().toString());
            productBuilder.setId(productToModify.getId());
            productBuilder.setDiscount(productToModify.getDiscount().toString());
            productBuilder.setDescription(productToModify.getDescriprion());
        }
    }


    private void mandatoryFieldValidator(DTU dataTransferUnit) throws IllegalArgumentException {
        StringValidator stringValidator = new StringValidator();
        PriceValidator priceValidator = new PriceValidator();
        CategoryValidator categoryValidator = new CategoryValidator();

        if(dataTransferUnit.getName().length() > 0) {
            stringValidator.validate(dataTransferUnit.getName());
            productBuilder.setName(dataTransferUnit.getName());
            feedbackMessageArray.add("Name changed to " + dataTransferUnit.getName());
        } else {
            feedbackMessageArray.add("Old Name remains");
        }

        if(dataTransferUnit.getPrice().length() > 0) {
            priceValidator.validate(dataTransferUnit.getPrice());
            productBuilder.setPrice(dataTransferUnit.getPrice());
            feedbackMessageArray.add("Price changed to " + dataTransferUnit.getPrice());
        } else {
            feedbackMessageArray.add("Old Price remains");
        }

        if(dataTransferUnit.getCategory().length() > 0) {
            categoryValidator.validate(dataTransferUnit.getCategory());
            productBuilder.setCategory(dataTransferUnit.getCategory());
            feedbackMessageArray.add("Category changed to " + dataTransferUnit.getCategory());
        } else {
            feedbackMessageArray.add("Old Category remains");
        }
    }


    private void optionalFieldValidator(DTU dataTransferUnit) {
        DiscountValidator discountValidator = new DiscountValidator();
        StringValidator stringValidator = new StringValidator();

        try {
            discountValidator.validate(dataTransferUnit.getDiscount());
            productBuilder.setDiscount(dataTransferUnit.getDiscount());
            feedbackMessageArray.add("Discount changed to " + dataTransferUnit.getDiscount() + "%");
        } catch (IllegalArgumentException e) {
            feedbackMessageArray.add(e.getMessage() + " Old discount remains.");
        }

        try {
            stringValidator.validate(dataTransferUnit.getDescription());
            productBuilder.setDescription(dataTransferUnit.getDescription());
            feedbackMessageArray.add("Description changed");
        } catch (IllegalArgumentException e) {
            feedbackMessageArray.add("Description remains");
        }
    }


    public void validatePresence(String stringID) throws IllegalArgumentException {
        IdValidator idValidator = new IdValidator();
        idValidator.validate(stringID);
        productToModify = productDataBase.findById(new Long(stringID));
    }


    public List<String> modify(DTU dataTransferUnit) throws IllegalArgumentException {
        validatePresence(dataTransferUnit.getId());
        feedbackMessageArray.clear();
        setBuilderFieldsAsProduct();

        mandatoryFieldValidator(dataTransferUnit);
        optionalFieldValidator(dataTransferUnit);

        productToModify = productBuilder.build();
        productDataBase.save(productToModify);

        feedbackMessageArray.add("\nProduct ID:" + productToModify.getId() + " successfully modified.");

        return feedbackMessageArray;
    }
}
