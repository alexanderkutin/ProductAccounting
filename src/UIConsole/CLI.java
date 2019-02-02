package UIConsole;

import BussinessLogic.DataBaseInterface;

import java.util.Scanner;

public class CLI {

    private Command[] commandArr;

    public CLI(Command[] commandArr){
        this.commandArr = commandArr;
    }


    public void console(){

        String input;
        Scanner stringScanner = new Scanner(System.in);
        DataBaseInterface.initializeDataBase();


        while (true){
            System.out.print("Accounting# ");
            input = stringScanner.nextLine();
            input = input.toLowerCase();

            if(input.equals("quit")){
                break;
            }

            for (Command command : commandArr){
                if(input.equals(command.toString())){
                    command.execute();
                }
            }

        }


    }
}
