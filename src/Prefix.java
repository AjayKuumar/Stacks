import java.util.HashMap;
import java.util.Map;

class ConversionPrefix {
    private int top;
    private int capacity;
    private char[] array;
    private String output;
    private Map<Character, Integer> precedence;

    public ConversionPrefix(int capacity) {
        top = -1;
        this.capacity = capacity;
        array = new char[capacity];
        output = "";
        precedence = new HashMap<>();
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('^', 3);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public char peek() {
        return array[top];
    }

    public char pop() {
        if (!isEmpty()) {
            top--;
            return array[top + 1];
        } else {
            return '$';
        }
    }

    public void push(char op) {
        top++;
        array[top] = op;
    }

    public boolean isOperand(char ch) {
        return Character.isLetter(ch);
    }

    public boolean notGreater(char i) {
        int a, b;
        if (precedence.containsKey(i) && precedence.containsKey(peek())) {
            a = precedence.get(i);
            b = precedence.get(peek());
            return (a < b);
        } else {
            return false;
        }
    }
    public void infixToPrefix(String exp) {
        for (int i = exp.length()-1; i >=0; i--) {
            if (isOperand(exp.charAt(i))) {
                output += exp.charAt(i);
            } else if (exp.charAt(i) == ')') {
                push(exp.charAt(i));
            } else if (exp.charAt(i) == '(') {
                while (!isEmpty() && peek() != ')') {
                    char a = pop();
                    output += a;
                }
                if (!isEmpty() && peek() != ')') {
                    System.out.println("Invalid expression");
                    return;
                } else {
                    pop();
                }
            } else {
                while (!isEmpty() && notGreater(exp.charAt(i))) {
                    char a = pop();
                    output += a;
                }
                push(exp.charAt(i));
            }
        }
        while (!isEmpty()) {
            char a = pop();
            output += a;
        }
        System.out.println(output);
        char[] result = output.toCharArray();
        int start = 0;
        int end  = result.length-1;
        while(start<end){
            char temp = result[start];
            result[start] = result[end];
            result[end] = temp;
            start++;
            end--;
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }
}
public class Prefix {
    public static void main(String[] args) {
        String pre = "x-y+z";
        ConversionPrefix e = new ConversionPrefix(pre.length());
        e.infixToPrefix(pre);
    }
}
