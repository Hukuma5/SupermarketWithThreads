import java.util.Scanner;

public class Application {
    public static void printCashes(Cash[] cash){
        int maxSize = 0;
        for (Cash c : cash){
            if (maxSize < c.getLenghtOfQueue()){
                maxSize = c.getLenghtOfQueue();
            }
        }
        for (int i = 0; i < 4; i++){
            System.out.printf("%20s", "Cash №" + i + "(" + cash[i].getSpeed() + ")");
            if (i == 3) System.out.println();
        }
        for (int i = 0; i < maxSize; i++){
            for (int j = 0; j < cash.length; j++){
                if (cash[j].getLenghtOfQueue() - 1 < i){
                    System.out.printf("%20s", "");
                } else {
                    String name = cash[j].getQueue().get(i).getName();
                    System.out.printf("%20s", name);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Write count of customers");
        Scanner in = new Scanner(System.in);
        int countOfCustomers = in.nextInt();
        Cash[] cashes = new Cash[4];
        System.out.println("Write speeds of 4 cashes");
        for (int i = 0; i < cashes.length; i++){
            int speed = in.nextInt();
            while (speed < 1 || speed > 3){
                System.out.println("Please, write correct speed. It should be 1 <= speed <= 3");
                speed = in.nextInt();
            }
            cashes[i] = new Cash(speed);
        }
        System.out.println("Write count of steps");
        int countOfSteps = in.nextInt();

        SuperMarket superMarket = new SuperMarket(cashes);
        new CustomerGenerator(superMarket, cashes, countOfCustomers).start();
        new CashService(superMarket, cashes, countOfSteps).start();
    }
}
