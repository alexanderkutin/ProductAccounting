package UIConsole;

import java.util.ArrayList;

public class Help extends CommandBase {

    public Help(){
        outputMessages = new ArrayList<>();
    }

    @Override
    public void execute() {
        outputMessages.add("? - Help;");
        outputMessages.add("add - Add new product;");
        outputMessages.add("modify - Modify existing product;");
        outputMessages.add("setdiscount - Set discount to a whole category group;");
        outputMessages.add("get - Get a product by ID;");
        outputMessages.add("getall - Get all product list;");
        outputMessages.add("getcategory - Get a products with given category;");
        outputMessages.add("delete - Delete product by ID;");
        outputMessages.add("quit - Exit the program;");
        printOutput();
    }

    @Override
    public String toString() {
        return "?";
    }
}
