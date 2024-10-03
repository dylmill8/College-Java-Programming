public class Main {
    int x = 5;
    private int y = 10;

    public static void main(String[] args) {
        Main myObj1 = new Main();  // Object 1
        System.out.println(myObj1.x);

        Main myObj2 = new Main();  // Object 2
        System.out.println(myObj2.y);

        myMethod();

        myStaticMethod(); // Call the static method
        //myPublicMethod(); //This would compile an error

        Main obj = new Main(); // Create an object of Main
        obj.myPublicMethod(); // Call the public method on the object
    }

    static void myMethod() {
        System.out.println("Hello World!");
    }

    // Static method
    static void myStaticMethod() {
        System.out.println("Static methods can be called without creating objects");
    }

    // Public method
    public void myPublicMethod() {
        System.out.println("Public methods must be called by creating objects");
    }
}