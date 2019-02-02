package UIConsole;

import BussinessLogic.Cat;
import BussinessLogic.DTU;
import BussinessLogic.ProductGenerator;

import java.util.Arrays;
import java.util.Scanner;


public class Add extends CommandBase {

    private ProductGenerator productGenerator;

    public Add(){
        productGenerator = new ProductGenerator();
    }

    @Override
    public void execute(){
        String productInput;
        Scanner stringScanner = new Scanner(System.in);
        DTU dataTransferUnit = new DTU();


        //Mandatory Fields BEGIN
        System.out.print("Enter the name: ");
        productInput = stringScanner.nextLine();
        dataTransferUnit.setName(productInput);

        System.out.print("Enter the price (Digits only): ");
        productInput = stringScanner.nextLine();
        dataTransferUnit.setPrice(productInput);

        System.out.println("Enter the category from available options");
        System.out.print(Arrays.asList(Cat.values()) + ": ");
        productInput = stringScanner.nextLine();
        productInput = productInput.toUpperCase();
        dataTransferUnit.setCategory(productInput);
        //Mandatory Fields END


        //Optional Fields BEGIN
        System.out.print("Enter the discount in percents (From 0 to 100): ");
        productInput = stringScanner.nextLine();
        dataTransferUnit.setDiscount(productInput);

        System.out.print("Enter the description: ");
        productInput = stringScanner.nextLine();
        dataTransferUnit.setDescription(productInput);
        //Optional Fields END


        try {
            outputMessages = productGenerator.generate(dataTransferUnit);
        } catch (RuntimeException e){
            System.out.println("\nERROR! " + e.getMessage() + "\n");
            return;
        }

        printOutput();
    }


    @Override
    public String toString() {
        return "add";
    }
}
