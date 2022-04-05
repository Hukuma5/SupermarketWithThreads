public class CashService extends Thread {
    private int countOfSteps;
    private Cash[] cashes = new Cash[4];
    private SuperMarket superMarket;
    public CashService(SuperMarket superMarket, Cash[] cashes, int countOfSteps){
        this.superMarket = superMarket;
        this.cashes = cashes;
        this.countOfSteps = countOfSteps;
    }

    public void run(){
        for (int i = 0; i < this.countOfSteps; i++){
            this.superMarket.serviceAll();
        }
        System.out.println("State of cashes before closing the store:");
        Application.printCashes(this.cashes);
    }
}
