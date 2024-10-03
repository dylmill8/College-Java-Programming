public class Quiz09 {

    public static void main(String[] args) {
        String s1="Purdue:University,";
        String s2="West Lafayette";
        String combine=s1.substring(3,7) + "," + s2.substring(0);
        int len=s1.length();
        String length=Integer.toString(len);
        combine = combine + length;

        System.out.println(combine+"\t\t"+combine.length());
    }
}
