public class SuperMarket {
    private volatile Cash[] cashes = new Cash[4];
    private volatile boolean availableForService = false;

    public SuperMarket(Cash[] cashes){
        this.cashes = cashes;
    }

    public synchronized void serviceAll(){
        while(!availableForService){
            try{
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Application.printCashes(cashes);
        for (Cash c : cashes){
            c.service();
        }
        availableForService = false;
        notifyAll();
    }

    public synchronized void addCustomerToQueue(Customer customer, Cash cash){
        while(availableForService){
            try{
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        cash.addCustomer(customer);
        availableForService = true;
        notifyAll();
    }
}
