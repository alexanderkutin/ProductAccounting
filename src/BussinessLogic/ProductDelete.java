package BussinessLogic;

import Database.ItemNotFoundException;
import ProductValidator.IdValidator;

import java.util.ArrayList;
import java.util.List;

import static BussinessLogic.DataBaseInterface.productDataBase;

public class ProductDelete {
    private List<String> feedbackMessageArray;
    private IdValidator idValidator;

    public ProductDelete(){
        feedbackMessageArray = new ArrayList<>();
        idValidator = new IdValidator();
    }

    public List<String> deleteByID (String stringID) throws IllegalArgumentException {
        feedbackMessageArray.clear();
        idValidator.validate(stringID);

        try {
            productDataBase.delete(new Long(stringID));
            feedbackMessageArray.add("Product with ID:" + stringID + " deleted.");
        } catch (ItemNotFoundException e){
            feedbackMessageArray.add(e.getMessage());
        }

        return feedbackMessageArray;
    }
}
