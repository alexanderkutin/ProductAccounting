package UIConsole;

public class CLImain {

    public static void main(String[] args){

        CLI comline = new CLI(new Command[]{
                new Help(),
                new Add(),
                new Modify(),
                new SetDiscount(),
                new Get(),
                new GetAll(),
                new GetCategory(),
                new Delete()
        });

        comline.console();
    }

}
