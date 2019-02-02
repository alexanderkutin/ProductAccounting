package UIConsole;

import BussinessLogic.Cat;
import BussinessLogic.CategoryGroupDiscountModifier;

import java.util.Arrays;
import java.util.Scanner;

public class SetDiscount extends CommandBase {

    private CategoryGroupDiscountModifier categoryGroupDiscountModifier;

    public SetDiscount(){
        categoryGroupDiscountModifier = new CategoryGroupDiscountModifier();
    }

    @Override
    public void execute() {
        String categoryInput;
        String discountInput;
        Scanner stringScanner = new Scanner(System.in);

        System.out.println("Select the category from available options");
        System.out.print(Arrays.asList(Cat.values()) + ": ");
        categoryInput = stringScanner.nextLine();
        categoryInput = categoryInput.toUpperCase();

        System.out.print("Enter the discount [from 0% to 100%]: ");
        discountInput = stringScanner.nextLine();

        try {
            outputMessages = categoryGroupDiscountModifier.modifyDiscount(categoryInput, discountInput);
        } catch (RuntimeException e){
            System.out.println("\nERROR! " + e.getMessage() + "\n");
            return;
        }

        printOutput();
    }

    @Override
    public String toString() {
        return "setdiscount";
    }
}
