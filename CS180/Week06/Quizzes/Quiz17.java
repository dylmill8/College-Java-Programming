public class Quiz17 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int sum = 0;

        for (int element : array) {
            if (element % 2 == 0) continue; //continue passes this iteration of the loop if the condition is true
            sum += element;
        }
        System.out.println(sum);
    }
}
