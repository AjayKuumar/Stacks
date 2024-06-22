import java.util.ArrayDeque;
import java.util.Stack;

public class StockSpan {
    static void stockSpan(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int span = 1;
            for (int j = i-1; j >=0 && arr[j]<=arr[i] ; j--) {
                span++;
            }
            System.out.print(span+" ");
        }
    }

    static void spanEfficient(int[] arr){
        ArrayDeque<Integer> as= new ArrayDeque<>();
        as.push(0);
        System.out.print(1+" ");
        for (int i = 1; i < arr.length; i++) {
            //We need to keep track of previous greater elements
            while (as.isEmpty()==false && arr[as.peek()]<=arr[i]){
                //If curr element is greater than top element then top element is no useful in finding prev greater element
                //So we pop it first until either stack is empty or top element is greater than curr element
                as.pop();
            }
            //If stack is empty there is no previous greater element then span is curr index +1
            //Otherwise span is  curr index - top index
            int span = (as.isEmpty())?i+1:i-as.peek();
            System.out.print(span+" ");

            //We always push index into stack and pop it again if next element is greater in the next iteration.
            as.push(i);
        }
    }

    public static void main(String[] args) {
        int[] arr= {30,20,25,28,27,29};
        stockSpan(arr);
        System.out.println();
        spanEfficient(arr);
    }
}
