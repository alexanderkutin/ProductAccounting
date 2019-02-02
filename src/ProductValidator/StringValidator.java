package ProductValidator;

public class StringValidator extends ObjectValidator<String> {

    @Override
    public Boolean validate(String arg) throws IllegalArgumentException {
        if(!assertNotNull(arg)){
            throw new IllegalArgumentException("String must be entered.");
        }

        if(arg.length() <= 0){
            throw new IllegalArgumentException("String must be entered.");
        }

        return true;
    }
}
