import java.util.Scanner;

public class Generator{
    private Alphabet alphabet;
    private static Scanner keyboard;

    public Generator(Scanner scanner){
        keyboard = scanner;
    }

    public Generator(boolean upper, boolean lower, boolean number, boolean symbol){
        alphabet = new Alphabet(upper, lower, number, symbol);
    }

    private void printMenu(){
        System.out.println("");
        System.out.println("1 - Password Generator");
        System.out.println("2 - Password Feedback");
        System.out.println("3 - Quit");
        System.out.print("Your choice: ");
    }

    public void mainLoop(){
        System.out.println("Welcome to Password Protector");
        printMenu();
        String input = "-1";
        while(!input.equals("3")){
            input = keyboard.next();
            switch(input){
                case "1": requestPassword();
                break;
                case "2": checkPassword();
                break;
                case "3": System.out.println("Closing Password Protector");
                break;
                default: System.out.println("Choose a command");
            }
            printMenu();
        }
    }

    private void requestPassword(){
        boolean upper = false;
        boolean lower = false;
        boolean number = false;
        boolean symbol = false;
        boolean invalid = true;
        System.out.println();
        System.out.println("Answer the following questions with yes/no to generate a password");
        do{
            System.out.println("Do you want to use uppercase letters?");
            String input = keyboard.next();
            if(include(input)){upper = true;}
            System.out.println("Do you want to use lowercase letters?");
            input = keyboard.next();
            if(include(input)){lower = true;}
            System.out.println("Do you want to use numbers?");
            input = keyboard.next();
            if(include(input)){number = true;}
            System.out.println("Do you want to use symbols?");
            input = keyboard.next();
            if(include(input)){symbol = true;}
            if(!upper && !lower && !number && !symbol){
                System.out.println("It is impossible to generate a password with no characters");
                continue;
            }
            invalid = false;
            System.out.println("What length should the password be?");
            int length = keyboard.nextInt();
            final Generator generator = new Generator(upper, lower, number, symbol);
            final Password password = generator.generatePassword(length);
            System.out.println("The generated password is: " + password);
        }
        while(invalid);
    }

    private Password generatePassword(int length){
        final StringBuilder password = new StringBuilder();
        final int alphabetLength = alphabet.getAlphabet().length();
        for(int i = 0; i < length; i++){
            int index = (int)(Math.random() * alphabetLength);
            password.append(alphabet.getAlphabet().charAt(index));
        }
        return new Password(password.toString());
    }

    private void checkPassword(){
        System.out.println("Enter your password");
        String input = keyboard.next();
        final Password check = new Password(input);
        System.out.println(check.passwordFeedback()); 
    }

    private boolean include(String input){
        if(input.equalsIgnoreCase("yes")){
            return true;
        }
        return false;
    }
}