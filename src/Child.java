import java.util.Random;

public class Child extends Customer {
    public Child(){
        super();
    }
    public Child(int n){
        super(n);
    }

    public Cash choosingCash(Cash[] cash){
        Random rnd = new Random();
        return cash[rnd.nextInt(cash.length)];
    }

    public String getName(){
        return "Child(" + Integer.toString(getRemainsOfPurchases()) + ")";
    }
}
