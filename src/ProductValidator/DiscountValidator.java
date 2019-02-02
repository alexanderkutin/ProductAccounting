package ProductValidator;

import java.math.BigDecimal;

public class DiscountValidator extends ObjectValidator<String> {

    @Override
    public Boolean validate(String arg) throws IllegalArgumentException {
        BigDecimal discount = null;

        if(!assertNotNull(arg)){
            throw new IllegalArgumentException("ERROR!");
        }

        try {
            discount = new BigDecimal(arg);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("Discount must be entered in digits.");
        }

        if((discount.doubleValue() < 0) || (discount.doubleValue() > 100)){
            throw new IllegalArgumentException("Discount must be between 0 and 100 %.");
        }

        return true;
    }
}
