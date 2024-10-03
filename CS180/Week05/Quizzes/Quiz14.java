public class Quiz14 {
    int x = 7;
    void goBoilers(int x) {
        System.out.println(this.x);
    }
    public static void main(String[] args) {
        Quiz14 q = new Quiz14();
        q.goBoilers(5);
    }
}
