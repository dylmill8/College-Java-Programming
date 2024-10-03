public class DiningCourt {
    private Entree firstEntree;
    private Entree secondEntree;
    private Entree thirdEntree;

    //constructors
    public DiningCourt(Entree firstEntree, Entree secondEntree, Entree thirdEntree) {
        this.firstEntree = firstEntree;
        this.secondEntree = secondEntree;
        this.thirdEntree = thirdEntree;
    }
    public DiningCourt(DiningCourt diningCourt) {
        this.firstEntree = diningCourt.getFirstEntree();
        this.secondEntree = diningCourt.getSecondEntree();
        this.thirdEntree = diningCourt.getThirdEntree();
    }
    public DiningCourt() {
        this.firstEntree = null;
        this.secondEntree = null;
        this.thirdEntree = null;
    }

    //accessors
    public Entree getFirstEntree() { return firstEntree; }
    public Entree getSecondEntree() { return secondEntree; }
    public Entree getThirdEntree() { return thirdEntree; }

    //mutators
    public void setFirstEntree(Entree firstEntree) { this.firstEntree = firstEntree; }
    public void setSecondEntree(Entree secondEntree) { this.secondEntree = secondEntree; }
    public void setThirdEntree(Entree thirdEntree) { this.thirdEntree = thirdEntree; }

    public Entree getLowestCalorieEntree() {
        if (firstEntree.getCalories() < secondEntree.getCalories() & firstEntree.getCalories() <
                thirdEntree.getCalories()) {
            return firstEntree;
        }
        if (secondEntree.getCalories() < firstEntree.getCalories() & secondEntree.getCalories() <
                thirdEntree.getCalories()) {
            return secondEntree;
        }
        if (thirdEntree.getCalories() < firstEntree.getCalories() & thirdEntree.getCalories() <
                secondEntree.getCalories()) {
            return thirdEntree;
        }
        return null;
    }

    public Entree getHighestCalorieEntree() {
        if (firstEntree.getCalories() > secondEntree.getCalories() & firstEntree.getCalories() >
                thirdEntree.getCalories()) {
            return firstEntree;
        }
        if (secondEntree.getCalories() > firstEntree.getCalories() & secondEntree.getCalories() >
                thirdEntree.getCalories()) {
            return secondEntree;
        }
        if (thirdEntree.getCalories() > firstEntree.getCalories() & thirdEntree.getCalories() >
                secondEntree.getCalories()) {
            return thirdEntree;
        }
        return null;
    }

    public void printVegetarianEntrees() {
        int counter = 0;
        if (firstEntree.isVegetarian()) {
            System.out.println("Option 0: " + firstEntree.getName());
            counter++;
        }
        if (secondEntree.isVegetarian()) {
            System.out.println("Option 1: " + secondEntree.getName());
            counter++;
        }
        if (thirdEntree.isVegetarian()) {
            System.out.println("Option 2: " + thirdEntree.getName());
            counter++;
        }
        if (counter == 0) { System.out.println("No vegetarian options are available :("); }
    }

    public void printVeganEntrees() {
        int counter = 0;
        if (firstEntree.isVegan()) {
            System.out.println("Option 0: " + firstEntree.getName());
            counter++;
        }
        if (secondEntree.isVegan()) {
            System.out.println("Option 1: " + secondEntree.getName());
            counter++;
        }
        if (thirdEntree.isVegan()) {
            System.out.println("Option 2: " + thirdEntree.getName());
            counter++;
        }
        if (counter == 0) { System.out.println("No vegan options are available :("); }
    }

    public String toString() {
        return String.format("DiningCourt<firstEntree=" + firstEntree.toString() + ", secondEntree=" +
                secondEntree.toString() + ", thirdEntree=" + thirdEntree.toString() + ">");
    }
}
