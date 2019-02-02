package UIConsole;

import BussinessLogic.ProductDelete;

import java.util.Scanner;

public class Delete extends CommandBase {

    private ProductDelete productDelete;

    public Delete(){
        productDelete = new ProductDelete();
    }

    @Override
    public void execute() {
        String productInput;
        Scanner stringScanner = new Scanner(System.in);

        System.out.print("Enter product ID: ");
        productInput = stringScanner.nextLine();

        try {
            outputMessages = productDelete.deleteByID(productInput);
        } catch (RuntimeException e) {
            System.out.println("\nERROR! " + e.getMessage() + "\n");
            return;
        }

        printOutput();
    }

    @Override
    public String toString() {
        return "delete";
    }
}
