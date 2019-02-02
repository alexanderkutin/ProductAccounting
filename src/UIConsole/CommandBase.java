package UIConsole;

import java.util.List;

abstract class CommandBase implements Command {

    protected List<String> outputMessages;

    protected void printOutput(){
        if(outputMessages != null){
            System.out.println();
            for(String message : outputMessages){
                System.out.println(message);
            }
            System.out.println();
        } else {
            System.out.println();
        }
    }
}
