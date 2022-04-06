public class CustomerGenerator extends Thread{
    private int countOfCustomer;
    private Cash[] cashes = new Cash[4];
    private SuperMarket superMarket;
    public CustomerGenerator(SuperMarket superMarket, Cash[] cashes, int countOfCustomer){
        this.superMarket = superMarket;
        this.countOfCustomer = countOfCustomer;
        this.cashes = cashes;
    }

    public void run(){
        CustomerFactory factory = new CustomerFactory();
        for (int i = 0; i < this.countOfCustomer; i++){
            Customer customer = factory.generateCustomer();
            Cash choosingCash = customer.choosingCash(this.cashes);
            this.superMarket.addCustomerToQueue(customer, choosingCash);
        }
        this.superMarket.stopGenerate();
    }
}
