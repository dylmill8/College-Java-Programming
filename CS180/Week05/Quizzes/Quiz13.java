public class Quiz13 {
    private int k = 3;

    void doIt(int k) {
        k = 7;
    }

    public static void main(String[] args) {
        Quiz13 q = new Quiz13();
        q.doIt(12);
        System.out.println(q.k);
    }
}