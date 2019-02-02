package UIConsole;

import BussinessLogic.Cat;
import BussinessLogic.DTU;
import BussinessLogic.ProductModify;

import java.util.Arrays;
import java.util.Scanner;

public class Modify extends CommandBase {

    private ProductModify productModify;

    public Modify(){
        productModify = new ProductModify();
    }

    @Override
    public void execute() {
        String productInput;
        Scanner stringScanner = new Scanner(System.in);
        DTU dataTransferUnit = new DTU();

        System.out.print("Enter product ID (Digits only): ");
        productInput = stringScanner.nextLine();
        dataTransferUnit.setId(productInput);

        try {
            productModify.validatePresence(productInput);
            dataTransferUnit.setId(productInput);
        } catch (RuntimeException e){
            System.out.println("\nERROR! " + e.getMessage() + "\n");
            return;
        }

        //Mandatory Fields BEGIN
        System.out.print("Modify the name (Leave empty to keep old value): ");
        productInput = stringScanner.nextLine();
        dataTransferUnit.setName(productInput);

        System.out.print("Modify the price (Leave empty to keep old value): ");
        productInput = stringScanner.nextLine();
        dataTransferUnit.setPrice(productInput);

        System.out.println("Modify the category (Leave empty to keep old value)");
        System.out.print(Arrays.asList(Cat.values()) + ": ");
        productInput = stringScanner.nextLine();
        productInput = productInput.toUpperCase();
        dataTransferUnit.setCategory(productInput);
        //Mandatory Fields END


        //Optional Fields BEGIN
        System.out.print("Modify the discount [from 0% to 100%] (Leave empty to keep old value): ");
        productInput = stringScanner.nextLine();
        dataTransferUnit.setDiscount(productInput);

        System.out.print("Modify the description (Leave empty to keep old value): ");
        productInput = stringScanner.nextLine();
        dataTransferUnit.setDescription(productInput);
        //Optional Fields END


        try {
            outputMessages = productModify.modify(dataTransferUnit);
        } catch (RuntimeException e){
            System.out.println("\nERROR! " + e.getMessage() + "\n");
            return;
        }

        printOutput();
    }

    @Override
    public String toString() {
        return "modify";
    }
}
