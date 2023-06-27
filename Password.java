public class Password{
    private int length;
    private String password;

    public Password(String input){
        password = input;
        length = input.length();
    }

    public static int charType(char c){
        //symbol
        int val = 0;
        if((int) c >= 65 && (int) c <= 90){
            //uppercase
            val = 1;
        }
        else if((int) c >= 97 && (int) c <= 122){
            //lowercase
            val = 2;
        }
        else if((int) c >= 48 && (int) c <= 57){
            //number
            val = 3;
        }
        return val;
    }

    public boolean passwordStrength(){
        int upper = 0;
        int lower = 0;
        int number = 0;
        int symbol = 0;
        for(int i = 0; i < length; i++){
            switch(charType(password.charAt(i))){
                case 1: upper++;
                break;
                case 2: lower++;
                break;
                case 3: number++;
                break;
                default: symbol++;
            }
        }
        return upper > 0 && lower > 0 && number > 0 && symbol > 0 && length >= 8;
    }
    
    public String passwordFeedback(){
        if(passwordStrength()){
            return "Your password is strong.";
        }
        return "Your password has vulnerabilities.";
    }

    @Override
    public String toString(){
        return password;
    }
}