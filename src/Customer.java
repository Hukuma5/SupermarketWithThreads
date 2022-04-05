public abstract class Customer {
    private final int purchaseCount;
    private boolean isJustComeIn;
    private volatile int remainsOfPurchases;

    public Customer(){
        this.purchaseCount = 0;
        this.remainsOfPurchases = 0;
    }
    public Customer(int n){
        this.purchaseCount = n;
        this.remainsOfPurchases = n;
    }

    public int getRemainsOfPurchases(){
        return this.remainsOfPurchases;
    }

    public void setRemainsOfPurchases(int a){
        this.remainsOfPurchases = a;
    }

    public int getPurchaseCount(){
        return this.purchaseCount;
    }

    abstract Cash choosingCash(Cash[] cash);
    abstract String getName();
}
