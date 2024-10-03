import java.util.Objects;

public class Entree {
    /**
     * The name of this entree.
     */
    private String name;

    /**
     * The calories of this entree.
     */
    private int calories;

    /**
     * The vegetarian status of this entree.
     */
    private boolean vegetarian;

    /**
     * The vegan status of this entree.
     */
    private boolean vegan;

    /**
     * Constructs a newly allocated {@code Entree} object with the specified name, calories, vegetarian status, and
     * vegan status.
     *
     * @param name the name to be used in construction
     * @param calories the calories to be used in construction
     * @param vegetarian the vegetarian status to be used in construction
     * @param vegan the vegan status to be used in construction
     */
    public Entree(String name, int calories, boolean vegetarian, boolean vegan) {
        this.name = name;
        this.calories = calories;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
    } //Entree

    /**
     * Constructs a newly allocated {@code Entree} object that is a copy of the specified entree.
     *
     * @param entree the entree to be used in construction
     */
    public Entree(Entree entree) {
        Objects.requireNonNull(entree, "the specified entree is null");

        this.name = entree.name;
        this.calories = entree.calories;
        this.vegetarian = entree.vegetarian;
        this.vegan = entree.vegan;
    } //Entree

    /**
     * Constructs a newly allocated {@code Entree} object with a default name of {@code null}, calories of zero,
     * vegetarian status of {@code false}, and vegan status of {@code false}.
     */
    public Entree() {
        this(null, 0, false, false);
    } //Entree

    /**
     * Returns the name of this entree.
     *
     * @return the name of this entree
     */
    public String getName() {
        return this.name;
    } //getName

    /**
     * Returns the calories of this entree.
     *
     * @return the calories of this entree
     */
    public int getCalories() {
        return this.calories;
    } //getCalories

    /**
     * Returns {@code true}, if this entree is vegetarian and {@code false} otherwise.
     *
     * @return {@code true}, if this entree is vegetarian and {@code false} otherwise
     */
    public boolean isVegetarian() {
        return this.vegetarian;
    } //isVegetarian

    /**
     * Returns {@code true}, if this entree is vegan and {@code false} otherwise.
     *
     * @return {@code true}, if this entree is vegan and {@code false} otherwise
     */
    public boolean isVegan() {
        return this.vegan;
    } //isVegan

    /**
     * Updates the name of this entree with the specified name.
     *
     * @param name the name to be used in the update
     */
    public void setName(String name) {
        this.name = name;
    } //setName

    /**
     * Updates the calories of this entree with the specified calories.
     *
     * @param calories the calories to be used in the update
     */
    public void setCalories(int calories) {
        this.calories = calories;
    } //setCalories

    /**
     * Updates the vegetarian status of this entree with the specified vegetarian status.
     *
     * @param vegetarian the vegetarian status to be used in the update
     */
    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    } //setVegetarian

    /**
     * Updates the vegan status of this entree with the specified vegan status.
     *
     * @param vegan the vegan status to be used in the update
     */
    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    } //setVegan

    /**
     * Returns the {@code String} representation of this entree.
     *
     * Example:
     * name = "Penne Pasta"
     * calories = 440
     * vegetarian = true
     * vegan = true
     * toString(): "Entree[name=Penne Pasta, calories=440, vegetarian=true, vegan=true]"
     *
     * @return the {@code String} representation of this entree
     */
    @Override
    public String toString() {
        String format = "Entree[name=%s, calories=%s, vegetarian=%b, vegan=%b]";

        return String.format(format, this.name, this.calories, this.vegetarian, this.vegan);
    } //toString
}