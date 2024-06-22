class evaluationPrefix{
    int top;
    String[] arr;
    int capacity;
    evaluationPrefix(int n){
        top = -1;
        arr = new String[n];
        capacity = n;
    }
    public void push(String x){
        top++;
        arr[top]=x;
    }
    public String pop(){
        if (!isEmpty()){
            String res = arr[top];
            top--;
            return res;
        }else{
            return "$";
        }
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public String peek(){
        return arr[top];
    }
    public String evaluatePrefix(String x){
        for (int i = x.length()-1; i >= 0; i--) {
            if (Character.isDigit(x.charAt(i))){
                push(String.valueOf(x.charAt(i)));
            }else{
                String val1 = pop();
                String val2 = pop();
                int result;
                int int_val1 = Integer.parseInt(val1);
                int int_val2 = Integer.parseInt(val2);
                switch (x.charAt(i)) {
                    case '+':
                        result = int_val1 + int_val2;
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
public class PrefixEvaluation {

    public static void main(String[] args) {
        String exp = "+9*26";
        evaluationPrefix e = new evaluationPrefix(exp.length());
        System.out.println(e.evaluatePrefix(exp));
    }
}
