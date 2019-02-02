package ProductValidator;

import java.math.BigDecimal;

public class PriceValidator extends ObjectValidator<String> {

    @Override
    public Boolean validate(String arg) throws IllegalArgumentException {
        BigDecimal price = null;

        if(!assertNotNull(arg)){
            throw new IllegalArgumentException("ERROR!");
        }

        try {
            price = new BigDecimal(arg);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Price must be entered in digits.");
        }

        if(price.doubleValue() < 0){
            throw new IllegalArgumentException("Price must be greater than zero.");
        }

        return true;
    }
}
