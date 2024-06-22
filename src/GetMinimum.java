import java.util.Stack;
class stack{
    Stack as;
    int min;
    stack(){
        as = new Stack();
        min = Integer.MAX_VALUE;
    }
    void push(int x){
        if (as.isEmpty()){
            min = x;
            as.push(x);
        }else if(x<=min){
            as.push(x-min);
            min=x;
        }else{
            as.push(x);
        }
    }
    int pop(){
        int res = (int) as.pop();
        if (res<=0){
            int t = min;
            min = min-res;
            return t;
        }
        return res;
    }
    int getMin(){
        return min;
    }
    int peek(){
        int t = (int) as.peek();
        return (t<=0)?min:t;
    }
}

public class GetMinimum{

    public static void main(String[] args) {
        stack as = new stack();
        as.push(5);
        as.push(10);
        as.push(20);
        as.push(2);
        as.push(6);
        as.push(4);
        as.pop();
        as.pop();
        as.push(2);
        as.pop();
        as.push(1);
        as.pop();
        as.pop();
        System.out.println(as.getMin());
        System.out.println(as.peek()  );
    }
}
