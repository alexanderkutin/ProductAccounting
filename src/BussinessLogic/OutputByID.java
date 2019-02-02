package BussinessLogic;

import Database.ItemNotFoundException;
import ProductValidator.IdValidator;

import java.util.ArrayList;
import java.util.List;

import static BussinessLogic.DataBaseInterface.productDataBase;

public class OutputByID {
    private List<String> feedbackMessageArray;
    private IdValidator idValidator;

    public OutputByID(){
        feedbackMessageArray = new ArrayList<>();
        idValidator = new IdValidator();
    }

    public List<String> getProduct(String stringID) throws IllegalArgumentException {
        feedbackMessageArray.clear();
        idValidator.validate(stringID);

        try {
            feedbackMessageArray.add(productDataBase.findById(new Long(stringID)).toString());
        } catch (ItemNotFoundException e){
            feedbackMessageArray.add(e.getMessage());
        }

        return feedbackMessageArray;
    }

}
