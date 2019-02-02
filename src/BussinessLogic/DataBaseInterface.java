package BussinessLogic;

import Database.ProductRepository;

public class DataBaseInterface {
    public static ProductRepository productDataBase;

    public static void initializeDataBase(){
        productDataBase = new ProductRepository();
    }
}
