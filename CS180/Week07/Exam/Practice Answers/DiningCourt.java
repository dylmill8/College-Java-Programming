import java.util.Objects;

public final class DiningCourt {
    private Entree firstEntree;
    private Entree secondEntree;
    private Entree thirdEntree;

    /**
     * Constructs a newly allocated {@code DiningCourt} object with the specified first, second, and third entree.
     *
     * @param firstEntree the first entree to be used in construction
     * @param secondEntree the second entree to be used in construction
     * @param thirdEntree the third entree to be used in construction
     */
    public DiningCourt(Entree firstEntree, Entree secondEntree, Entree thirdEntree) {
        this.firstEntree = firstEntree;
        this.secondEntree = secondEntree;
        this.thirdEntree = thirdEntree;
    } //DiningCourt

    /**
     * Constructs a newly allocated {@code DiningCourt} object that is a shallow copy of the specified dining court.
     *
     * @param diningCourt the dining court to be used in construction
     */
    public DiningCourt(DiningCourt diningCourt) {
        Objects.requireNonNull(diningCourt, "the specified dining court is null");

        this.firstEntree = diningCourt.firstEntree;
        this.secondEntree = diningCourt.secondEntree;
        this.thirdEntree = diningCourt.thirdEntree;
    } //DiningCourt

    /**
     * Constructs a newly allocated {@code DiningCourt} object with a default first, second, and third entree of
     * {@code null}.
     */
    public DiningCourt() {
        this(null, null, null);
    } //DiningCourt

    public Entree getFirstEntree() {
        return this.firstEntree;
    } //getFirstEntree

    public Entree getSecondEntree() {
        return this.secondEntree;
    } //getSecondEntree

    public Entree getThirdEntree() {
        return this.thirdEntree;
    } //getThirdEntree
    public void setFirstEntree(Entree firstEntree) {
        this.firstEntree = firstEntree;
    } //setFirstEntree

    public void setSecondEntree(Entree secondEntree) {
        this.secondEntree = secondEntree;
    } //setSecondEntree

    public void setThirdEntree(Entree thirdEntree) {
        this.thirdEntree = thirdEntree;
    } //setThirdEntree
    public Entree getLowestCalorieEntree() {
        int firstCalories;
        int secondCalories;
        int thirdCalories;
        Entree lowCalEntree;

        firstCalories = this.firstEntree.getCalories();

        secondCalories = this.secondEntree.getCalories();

        thirdCalories = this.thirdEntree.getCalories();

        lowCalEntree = this.firstEntree;

        if ((secondCalories < thirdCalories) && (secondCalories < firstCalories)) {
            lowCalEntree = secondEntree;
        } else if ((thirdCalories < secondCalories) && (thirdCalories < firstCalories)) {
            lowCalEntree = thirdEntree;
        } //end if

        return lowCalEntree;
    } //getLowestCalorieEntree

    /**
     * Returns the highest calorie entree of this dining court.
     *
     * @return the highest calorie entree of this dining court
     */
    public Entree getHighestCalorieEntree() {
        int firstCalories;
        int secondCalories;
        int thirdCalories;
        Entree highCalEntree;

        firstCalories = this.firstEntree.getCalories();

        secondCalories = this.secondEntree.getCalories();

        thirdCalories = this.thirdEntree.getCalories();

        highCalEntree = this.firstEntree;

        if ((secondCalories > thirdCalories) && (secondCalories > firstCalories)) {
            highCalEntree = secondEntree;
        } else if ((thirdCalories > secondCalories) && (thirdCalories > firstCalories)) {
            highCalEntree = thirdEntree;
        } //end if

        return highCalEntree;
    } //getHighestCalorieEntree

    /**
     * Prints the vegetarian entrees of this dining court.
     *
     * Example output:
     * Option 0: Penne Pasta
     * Option 1: Mac and cheese
     *
     * Example output (none available):
     * No vegetarian options are available :(
     */
    public void printVegetarianEntrees() {
        int index = 0;
        String name;

        if (this.firstEntree.isVegetarian()) {
            name = this.firstEntree.getName();

            System.out.printf("Option %d: %s%n", index, name);

            index++;
        } //end if

        if (this.secondEntree.isVegetarian()) {
            name = this.secondEntree.getName();

            System.out.printf("Option %d: %s%n", index, name);

            index++;
        } //end if

        if (this.thirdEntree.isVegetarian()) {
            name = this.thirdEntree.getName();

            System.out.printf("Option %d: %s%n", index, name);

            index++;
        } //end if

        if (index == 0) {
            System.out.println("No vegetarian options are available :(");
        } //end if
    } //printVegetarianEntrees

    /**
     * Prints the vegan entrees of this dining court.
     *
     * Example output:
     * Option 0: Vegan Chik Nugget
     * Option 1: Fresh Pineapple Chunks
     *
     * Example output (none available):
     * No vegan options are available :(
     */
    public void printVeganEntrees() {
        int index = 0;
        String name;

        if (this.firstEntree.isVegan()) {
            name = this.firstEntree.getName();

            System.out.printf("Option %d: %s%n", index, name);

            index++;
        } //end if

        if (this.secondEntree.isVegan()) {
            name = this.secondEntree.getName();

            System.out.printf("Option %d: %s%n", index, name);

            index++;
        } //end if

        if (this.thirdEntree.isVegan()) {
            name = this.thirdEntree.getName();

            System.out.printf("Option %d: %s%n", index, name);

            index++;
        } //end if

        if (index == 0) {
            System.out.println("No vegan options are available :(");
        } //end if
    } //printVeganEntrees


    /**
     * Returns the {@code String} representation of this dining court.
     *
     * Example:
     * firstEntree = "Entree[name=Penne Pasta, calories=440, vegetarian=true, vegan=true]"
     * secondEntree = "Entree[name=Mac and Cheese, calories=350, vegetarian=true, vegan=false]"
     * thirdEntree = "Entree[name=Tilapia in Jalapeno Cream, calories=590, vegetarian=false, vegan=false]"
     * toString(): "DiningCourt[firstEntree=Entree[name=Penne Pasta, calories=440, vegetarian=true, vegan=true], secondEntree=Entree[name=Mac and Cheese, calories=350, vegetarian=true, vegan=false], thirdEntree=Entree[name=Tilapia in Jalapeno Cream, calories=590, vegetarian=false, vegan=false]]"
     *
     * @return the {@code String} representation of this dining court
     */
    @Override
    public String toString() {
        String format = "DiningCourt[firstEntree=%s, secondEntree=%s, thirdEntree=%s]";

        return String.format(format, this.firstEntree, this.secondEntree, this.thirdEntree);
    } //toString
}
