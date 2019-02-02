package UIConsole;

import BussinessLogic.AllProductOutput;


public class GetAll extends CommandBase {

    private AllProductOutput allProductOutput;

    public GetAll(){
        allProductOutput = new AllProductOutput();
    }

    @Override
    public void execute() {

        outputMessages = allProductOutput.getProductList();

        printOutput();
    }

    @Override
    public String toString() {
        return "getall";
    }
}
