public class Quiz22 {
    class A {
        public void myMethod() {
            System.out.println("A");
        }
    }

    public class B extends A {
        public void myMethod() {
            System.out.println("B");
        }
    }

    public static void main(String[] args) {
        B b = new B();
        b.myMethod();
    }
}