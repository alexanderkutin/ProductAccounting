package ProductValidator;

abstract class ObjectValidator<T> implements Validator<T> {

    boolean assertNotNull(T arg) {
        return arg != null;
    }
}
