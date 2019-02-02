package UIConsole;

import BussinessLogic.Cat;
import BussinessLogic.OutputByCategory;

import java.util.Arrays;
import java.util.Scanner;

public class GetCategory extends CommandBase {

    private OutputByCategory outputByCategory;

    public GetCategory(){
        outputByCategory = new OutputByCategory();
    }

    @Override
    public void execute() {
        String categoryInput;
        Scanner stringScanner = new Scanner(System.in);

        System.out.println("Enter the category from available options");
        System.out.print(Arrays.asList(Cat.values()) + ": ");
        categoryInput = stringScanner.nextLine();
        categoryInput = categoryInput.toUpperCase();

        try {
            outputMessages = outputByCategory.getProductList(categoryInput);
        } catch (RuntimeException e) {
            System.out.println("\nERROR! " + e.getMessage() + "\n");
            return;
        }

        printOutput();
    }

    @Override
    public String toString() {
        return "getcategory";
    }
}
