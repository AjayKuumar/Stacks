import java.util.ArrayDeque;
import java.util.Stack;

public class Stacks {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(15);
        s.push(20);
        System.out.println(s.peek());
        s.pop();
        System.out.println(s.peek());
        System.out.println(s.size());
        System.out.println(s.isEmpty());

        ArrayDeque<Integer> as = new ArrayDeque<>();
        as.push(10);
        as.push(20);
        as.push(30);
        System.out.println(as.peek());
        as.pop();
        System.out.println(as.peek());
        System.out.println(as.size());
        System.out.println(as.isEmpty());
    }
}
