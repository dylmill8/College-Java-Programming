import java.util.Scanner;

public class Shopkeeper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String customerString = "";

        System.out.println("What is the customer's name?");
        String name = scanner.next();
        String lastName = scanner.nextLine();
        System.out.println("How many items did the customer purchase?");
        int numbItems = scanner.nextInt();
        scanner.nextLine();
        customerString = customerString + name.charAt(0) + lastName.charAt(1) + numbItems;

        String itemName;
        double itemPrice;
        double totalCost = 0;
        for (int i = 1; i <= numbItems; i++) {
            switch (i % 10) {
                case 1 -> System.out.printf("Enter the %dst item name.%n", i);
                case 2 -> System.out.printf("Enter the %dnd item name.%n", i);
                case 3 -> System.out.printf("Enter the %drd item name.%n", i);
                default -> System.out.printf("Enter the %dth item name.%n", i);
            }
            itemName = scanner.nextLine();
            customerString = customerString + itemName + ",";
            System.out.println("How much did this item cost?");
            itemPrice = scanner.nextDouble();
            scanner.nextLine();
            totalCost = totalCost + itemPrice;
        }

        customerString = customerString.substring(0, customerString.length() - 1);
        customerString = customerString + ":";
        System.out.printf("Your customer string is " + customerString + "%.2f", totalCost);
    }
}
