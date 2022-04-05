public class Women extends Customer{
    public Women(){
        super();
    }
    public Women(int n){
        super(n);
    }

    public Cash choosingCash(Cash[] cash){
        int minLenght = cash[0].getLenghtOfQueue();
        Cash choosenCash = cash[0];
        for (Cash i : cash){
            if (minLenght > i.getLenghtOfQueue()){
                minLenght = i.getLenghtOfQueue();
                choosenCash = i;
            }
        }
        return choosenCash;
    }

    public String getName(){
        return "Women(" + Integer.toString(getRemainsOfPurchases()) + ")";
    }
}
