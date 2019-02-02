package ProductValidator;

import BussinessLogic.Cat;

public class CategoryValidator extends ObjectValidator<String> {

    @Override
    public Boolean validate(String arg) throws IllegalArgumentException {
         if(!assertNotNull(arg)){
            throw new IllegalArgumentException();
         }

         try {
             Cat.valueOf(arg);
         } catch (IllegalArgumentException e){
             throw new IllegalArgumentException("Valid category must be entered.");
         }

        return true;
    }
}
