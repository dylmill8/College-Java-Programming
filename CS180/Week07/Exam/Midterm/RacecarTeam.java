public class RacecarTeam {
    private Vehicle vehicleOne;
    private Vehicle vehicleTwo;
    private Vehicle vehicleThree;

    public RacecarTeam(Vehicle vehicleOne, Vehicle vehicleTwo, Vehicle vehicleThree) {
        this.vehicleOne = vehicleOne;
        this.vehicleTwo = vehicleTwo;
        this.vehicleThree = vehicleThree;
    }

    public RacecarTeam() {
        vehicleOne = null;
        vehicleTwo = null;
        vehicleThree = null;
    }

    public boolean addVehicle(Vehicle vehicle) {
        if (vehicleOne == null) {
            vehicleOne = vehicle;
            return true;
        } else if (vehicleTwo == null) {
            vehicleTwo = vehicle;
            return true;
        } else if (vehicleThree == null) {
            vehicleThree = vehicle;
            return true;
        }
        return false;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        if (vehicleOne == vehicle) {
            vehicleOne = null;
            return true;
        } else if (vehicleTwo == vehicle) {
            vehicleTwo = null;
            return true;
        } else if (vehicleThree == vehicle) {
            vehicleThree = null;
            return true;
        }
        return false;
    }

    public int getOpenings() {
        int counter = 0;
        if (vehicleOne == null) counter++;
        if (vehicleTwo == null) counter++;
        if (vehicleThree == null) counter++;
        return counter;
    }

    public int getVehicleCount() {
        int counter = 0;
        if (vehicleOne != null) counter++;
        if (vehicleTwo != null) counter++;
        if (vehicleThree != null) counter++;
        return counter;
    }

    public double calculateAverageCostPerWin() {
        double totalPurchasePrice = 0;
        int totalWins = 0; //assuming total wins is greater than 0
        if (vehicleOne != null) {
            totalPurchasePrice = totalPurchasePrice + vehicleOne.getPurchasePrice();
            totalWins = totalWins + vehicleOne.getWins();
        }
        if (vehicleTwo != null) {
            totalPurchasePrice = totalPurchasePrice + vehicleTwo.getPurchasePrice();
            totalWins = totalWins + vehicleTwo.getWins();
        }
        if (vehicleThree != null) {
            totalPurchasePrice = totalPurchasePrice + vehicleThree.getPurchasePrice();
            totalWins = totalWins + vehicleThree.getWins();
        }

        //printing an error message and returning -1 if all cars are null or if there is not a single win across
        //all three cars
        if (totalWins == 0) {
            System.out.println("There was an error calculating your average cost per win!");
            return -1;
        }
        return (totalPurchasePrice / totalWins);
    }

    public double getFastestSpeed() {
        double fastestSpeed = 0;
        if (vehicleOne != null && vehicleOne.getTopSpeed() > fastestSpeed) fastestSpeed = vehicleOne.getTopSpeed();
        if (vehicleTwo != null && vehicleTwo.getTopSpeed() > fastestSpeed) fastestSpeed = vehicleTwo.getTopSpeed();
        if (vehicleThree != null && vehicleThree.getTopSpeed() > fastestSpeed) fastestSpeed = vehicleThree.getTopSpeed();
        return fastestSpeed;
    }
}
