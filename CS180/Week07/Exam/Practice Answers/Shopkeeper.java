import java.util.Scanner;
public class Shopkeeper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        double itemTotal = 0d;
        System.out.println("What is the customer's name?");
        String customerName = scanner.nextLine();
        if (customerName.contains(" ")) {
            sb.append(customerName.charAt(0));
            sb.append(customerName.charAt(customerName.indexOf(' ') + 1));
        } else {
            sb.append(customerName.charAt(0));
        }
        System.out.println("How many items did the customer purchase?");
        int numItemsPurchased = scanner.nextInt();
        scanner.nextLine();
        sb.append(numItemsPurchased);
        String numberSuffix = "";
        for (int i = 0; i < numItemsPurchased; i++) {
            String numStr = Integer.toString(i + 1);
            if (numStr.length() > 1 && numStr.charAt(numStr.length() - 2) == '1') {
                numberSuffix = "th";
            } else if (numStr.charAt(numStr.length() - 1) == '2') {
                numberSuffix = "nd";
            } else if (numStr.charAt(numStr.length() - 1) == '3') {
                numberSuffix = "rd";
            } else if (numStr.charAt(numStr.length() - 1) == '1') {
                numberSuffix = "st";
            } else {
                numberSuffix = "th";
            }
            System.out.println("Enter the " + (i + 1) + numberSuffix + " item name.");
            String itemName = scanner.nextLine();
            System.out.println("How much did this item cost?");
            itemTotal += scanner.nextDouble();
            scanner.nextLine();
            sb.append(itemName);
            if (i != numItemsPurchased - 1) {
                sb.append(",");
            } else {
                sb.append(":");
            }
        }
        sb.append(itemTotal);
        System.out.println("Your customer string is " + sb.toString());
    }
}