package sock_merchant;

import java.util.HashMap;
import java.util.Scanner;

class Counter {

    private int counter;

    Counter() {
        counter = 1;
    }

    //If the number of sock became a pair number, inform it is a pair.
    boolean isPairCounter() {
        return (++counter % 2) == 0;
    }
}

public class Sock_Merchant {

    //If the new sock is a pair of an existing sock increases pair and return.
    static int addSock(HashMap<Integer, Counter> map, int pairs, Integer sock) {
        if (map.containsKey(sock)) {
            if (map.get(sock).isPairCounter()) {
                pairs++;
            }
        } else {
            Counter counter = new Counter();
            map.put(sock, counter);
        }
        return pairs;
    }

    public static void main(String[] args) {
        HashMap<Integer, Counter> map = new HashMap<>();
        int pairs = 0;
        Scanner input = new Scanner(System.in);
        try {

            int numberOfEntry = input.nextInt();
            while (numberOfEntry-- > 0) {
                Integer sock = input.nextInt();
                pairs = addSock(map, pairs, sock);
            }
            System.out.println("Number of pairs in the given sock list is " + pairs);
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
    }

}
