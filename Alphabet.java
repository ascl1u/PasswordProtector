public class Alphabet{
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
	private static final String NUMBER = "1234567890";
	private static final String SYMBOL = "!@#$%^&*()-_=+\\/~?";

    private final StringBuilder charPool;

    public Alphabet(boolean upper, boolean lower, boolean number, boolean symbol){
        charPool = new StringBuilder();
        if(upper){charPool.append(UPPER);}
        if(lower){charPool.append(LOWER);}
        if(number){charPool.append(NUMBER);}
        if(symbol){charPool.append(SYMBOL);}
    }

    public String getAlphabet(){
        return charPool.toString();
    }
}