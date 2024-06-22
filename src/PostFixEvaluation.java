class Evaluation{
    int top;
    int capacity;
    String[] arr;
    Evaluation(int n){
        top = -1;
        capacity = n;
        arr = new String[n];
    }
    public boolean isEmpty(){
        return (top==-1);
    }
    public String peek(){
        return arr[top];
    }
    public void push(String x){
        top++;
        arr[top] = x;
    }
    public String pop(){
        if (isEmpty()){
            return "$";
        }else{
            String res = arr[top];
            top--;
            return res;
        }
    }
    public String evaluate(String s){
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))){
                push(String.valueOf(s.charAt(i)));
            }else{
                String val1 = pop();
                String val2 = pop();
                int result;
                int int_val1 = Integer.parseInt(val1);
                int int_val2 = Integer.parseInt(val2);
                switch (s.charAt(i)){
                    case '+':
                        result = int_val1+int_val2;
                        break;
                    case '-':
                        result = int_val2 - int_val1;
                        break;
                    case '*':
                        result = int_val2 * int_val1;
                        break;
                    case '/':
                        result = int_val2 / int_val1;
                        break;
                    default:
                        result = 0;
                }
                push(String.valueOf(result));
            }
        }
        return pop();
    }
}
public class PostFixEvaluation {

    public static void main(String[] args) {
        String exp = "231*+9-";
        Evaluation obj = new Evaluation(exp.length());
        System.out.println("Postfix evaluation: " + obj.evaluate(exp));
    }
}
