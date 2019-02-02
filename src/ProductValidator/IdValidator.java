package ProductValidator;

public class IdValidator extends ObjectValidator<String> {

    @Override
    public Boolean validate(String arg) throws IllegalArgumentException {
        Long id = null;

        if(!assertNotNull(arg)){
            throw new IllegalArgumentException("ERROR!");
        }

        try {
            id = new Long(arg);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("ID must be entered in digits.");
        }

        if(id.doubleValue() < 0){
            throw new IllegalArgumentException("ID must be greater than 0.");
        }

        return true;
    }
}
