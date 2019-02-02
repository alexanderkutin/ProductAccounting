package BussinessLogic;

public class ProductID {

    private static long sourceID = 0;

    public static long getNewID(){
        sourceID++;
        return sourceID;
    }
}
