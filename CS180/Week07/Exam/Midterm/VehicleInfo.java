import java.util.Scanner;

public class VehicleInfo {
    public static final String WELCOME_MESSAGE = "Welcome to the VehicleInfo program!";
    public static final String MAKE_PROMPT = "What is the vehicle's make?";
    public static final String MODEL_PROMPT = "What is the vehicle's model?";
    public static final String COUNTRY_PROMPT = "Where was the vehicle manufactured?";
    public static final String PRICE_PROMPT = "What was the price (in Dollars) of the vehicle?";
    public static final String DURATION_PROMPT = "How many years has the vehicle been owned for?";
    public static final String VEHICLE_TYPE_PROMPT = "Is the vehicle a car, van, truck, or motorcycle?";
    public static final String PURCHASE_TYPE_PROMPT = "Was the vehicle purchased new or pre-owned?";
    public static final String USER_COUNT_PROMPT = "How many people regularly drive/ride this vehicle?";
    public static final String ITH_PERSON_PROMPT = "What is the name of person number ";
    public static final String REPAIR_COUNT_PROMPT = "How many times did the vehicle need to be repaired?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String identifier = "";

        //assuming valid scanner input
        System.out.println(WELCOME_MESSAGE);
        System.out.println(MAKE_PROMPT);
        String make = scanner.nextLine();
        System.out.println(MODEL_PROMPT);
        String model = scanner.nextLine();
        System.out.println(COUNTRY_PROMPT);
        String country = scanner.nextLine();
        System.out.println(PRICE_PROMPT);
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println(DURATION_PROMPT);
        int duration = scanner.nextInt();
        scanner.nextLine();
        System.out.println(VEHICLE_TYPE_PROMPT);
        String vehicleType = scanner.nextLine();
        System.out.println(PURCHASE_TYPE_PROMPT);
        String purchaseType = scanner.nextLine();
        System.out.println(USER_COUNT_PROMPT);
        int numbUsers = scanner.nextInt();
        scanner.nextLine();

        identifier = identifier + make.toUpperCase().charAt(0) + //make
                model.toUpperCase().charAt(0) + "_" + //model
                country.toUpperCase().substring(0,2) +//first 2 letters of country
                country.toUpperCase().substring(country.length()-2,country.length()) + "_"; //last 2 letters of country

        if (price <= 10000) identifier = identifier + "LOW_";
        else if (price <= 40000) identifier = identifier + "MID_";
        else identifier = identifier + "HIGH_";

        identifier = identifier + duration + "_" + vehicleType.toLowerCase() + "_";

        if (purchaseType.equalsIgnoreCase("new")) identifier = identifier + "N{";
        else identifier = identifier + "PO{";

        String user;
        for (int i = 1; i <= numbUsers; i++) {
            System.out.println(ITH_PERSON_PROMPT + i);
            user = scanner.nextLine();
            identifier = identifier + user + ", ";
        }

        identifier = identifier.substring(0,identifier.length()-2) + "}_";
        System.out.println(REPAIR_COUNT_PROMPT);
        int repairs = scanner.nextInt();
        scanner.nextLine();

        if (repairs <= 2) identifier = identifier + "EXCELLENT";
        else if (repairs <= 8) identifier = identifier + "AVERAGE";
        else identifier = identifier + "POOR";

        identifier = identifier + ";";
        System.out.println(identifier);
    }
}
