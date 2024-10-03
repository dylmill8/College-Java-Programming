import java.util.*;

class Quiz18 {
    public static void main(String[] args){
        List l = new ArrayList();
        l.add(100);
        l.add(100);
        System.out.print(l.size());
        l.remove(new Integer(100));
        System.out.print(l.size());
    }
}
