package UIConsole;

import BussinessLogic.OutputByID;

import java.util.Scanner;

public class Get extends CommandBase {

    private OutputByID outputByID;

    public Get(){
        outputByID = new OutputByID();
    }

    @Override
    public void execute() {
        String productInput;
        Scanner stringScanner = new Scanner(System.in);

        System.out.print("Enter product ID: ");
        productInput = stringScanner.nextLine();

        try {
            outputMessages = outputByID.getProduct(productInput);
        } catch (RuntimeException e) {
            System.out.println("\nERROR! " + e.getMessage() + "\n");
            return;
        }

        printOutput();
    }

    @Override
    public String toString() {
        return "get";
    }
}
