import java.util.LinkedList;

public class Cash {
    private int speed;
    private LinkedList<Customer> queue;

    public Cash(int speed){
        this.speed = speed;
        this.queue = new LinkedList<Customer>();
    }

    public void addCustomer(Customer unit){
        this.queue.add(unit);
    }

    public void service(){
        int k = this.speed;
        int removeCounter = 0;
        for (Customer unit : this.queue){
            k -= unit.getRemainsOfPurchases();
            if (k == 0){
                unit.setRemainsOfPurchases(0);
                removeCounter++;
                break;
            } else if(k > 0){
                removeCounter++;
            } else {
                unit.setRemainsOfPurchases(-k);
                break;
            }
        }
        for (int i = 0; i < removeCounter; i++){
            this.queue.remove();
        }
    }

    public int getLenghtOfQueue(){
        return this.queue.size();
    }

    public int getSpeed(){
        return this.speed;
    }

    public LinkedList<Customer> getQueue(){
        return this.queue;
    }
}
