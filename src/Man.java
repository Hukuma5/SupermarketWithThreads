public class Man extends Customer{
    public Man(){
        super();
    }
    public Man(int n){
        super(n);
    }

    public Cash choosingCash(Cash[] cash){
        Cash choosenCach = cash[0];
        double[] parametr = new double[] {0, 0, 0, 0};

        for (int i = 0; i < 4; i++){
            if (cash[i].getLenghtOfQueue() == 0){
                parametr[i] = this.getPurchaseCount() / (double)cash[i].getSpeed();
            } else {
                for (Customer c : cash[i].getQueue()){
                    parametr[i] += c.getRemainsOfPurchases();
                }
                parametr[i] += this.getPurchaseCount();
                parametr[i] /= (double)cash[i].getSpeed();
            }
        }
        int minI = 0;
        double min = parametr[0];
        for (int i = 1; i < 4; i++){
            if (parametr[i] < min){
                min = parametr[i];
                minI = i;
            }
        }
        return cash[minI];
    }

    public String getName(){
        return "Man(" + Integer.toString(getRemainsOfPurchases()) + ")";
    }
}
