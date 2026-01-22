import java.time.LocalDate;
import java.util.*;
class CreditCard {
    private String number;
    private String name;
    private String bank;
    private double balance;
    private int limit;
    private LocalDate dueDate;
    private static final double LATE_FEE = 50.0;

    CreditCard(String no, String nm, String bk, double bal, int lim, LocalDate due) {
        number = no;
        name = nm;
        bank = bk;
        balance = bal;
        limit = lim;
        dueDate = due;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getBank() {
        return bank;
    }

    public Double getBalance() {
        return balance;
    }

    public int getLimit() {
        return limit;
    }

    public void modifyName(String name) {
        this.name = name;
    }

    public boolean chargeIt(double price) {
        if (price + balance > (double) limit)
            return false;
        balance += price;
        return true;
    }

    public void makePayment(double payment) {
        LocalDate today = LocalDate.now();

        if (today.isAfter(dueDate)) {
            balance += LATE_FEE;
        }
        balance = balance - (payment + payment * 0.02);
    }

    public static void printCard(CreditCard c) {
        System.out.println("Number = " + c.getNumber());
        System.out.println("Name = " + c.getName());
        System.out.println("Bank = " + c.getBank());
        System.out.println("Balance = " + c.getBalance());
        System.out.println("Limit = " + c.getLimit());
    }

}

class Suffle {
    public int[] numbers;

    Suffle(int[] num) {
        numbers = num;
    }

    public int[] fisherYates() {
            for (int i = numbers.length - 1; i > 0; i--) {
                int temp = numbers[i];
                int random = (int) (Math.random() * (i+1));
                numbers[i] = numbers[random];
                numbers[random]=temp;
            }
            return numbers;
        }

}

public class Test {

    public static void main(String args[]) {

        int[] nums = new int[52];
        for (int i = 0; i < 52; i++) {
            nums[i] = i + 1;
        }
        Suffle s = new Suffle(nums);
        System.out.println(Arrays.toString(s.fisherYates()));

        CreditCard c[] = new CreditCard[10];

        c[0] = new CreditCard("2034 3103 4231 3243", "Raj", "Axis", 0.0, 2500, LocalDate.now().plusDays(5));
        c[1] = new CreditCard("2034 4231 4231 3243", "Rohan", "Axis", 0.0, 3500, LocalDate.now().plusDays(10));
        c[2] = new CreditCard("1002 3303 9373 8922", "Rajan", "Axis", 0.0, 5000, LocalDate.now().plusDays(11));

        c[0].modifyName("Axay");

        for (int i = 0; i <= 58; i++) {
            c[0].chargeIt((double) i);
            c[1].chargeIt(2.0 * i);
            c[2].chargeIt((double) 3 * i);
        }

        for (int i = 0; i < 3; i++) {
            CreditCard.printCard(c[i]);
            while (c[i].getBalance() > 100.0) {
                c[i].makePayment(100.0);
                System.out.println("New balance = " + c[i].getBalance());
            }
        }
    }
}
