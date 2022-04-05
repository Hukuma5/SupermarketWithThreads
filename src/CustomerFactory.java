import java.util.Random;

public class CustomerFactory {
    private int generateCountOfPurchases(){
        Random rnd = new Random();
        return rnd.nextInt(5) + 1;
    }

    public Customer generateCustomer(){
        Random rnd = new Random();
        int custNum = rnd.nextInt(3);
        Customer customer;
        int CountOfPurchases = this.generateCountOfPurchases();
        switch (custNum) {
            case 0:
                customer = new Child(CountOfPurchases);
                break;
            case 1:
                customer = new Women(CountOfPurchases);
                break;
            default:
                customer = new Man(CountOfPurchases);
                break;
        }
        return customer;
    }
}
