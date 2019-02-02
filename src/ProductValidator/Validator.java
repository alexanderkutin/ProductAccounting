package ProductValidator;

import BussinessLogic.Product;

public interface Validator<T> {

    Boolean validate(T arg) throws IllegalArgumentException;
}
