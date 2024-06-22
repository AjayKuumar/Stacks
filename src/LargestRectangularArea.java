import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangularArea {
    static void reverse(int[] arr){
        int start=0;
        int end =arr.length-1;
        while(start<end){
            int temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    static int[] previousSmaller(int[] arr){
        int[] prev = new int[arr.length];
        ArrayDeque<Integer> as = new ArrayDeque<>();
        as.push(0);
        prev[0]=-1;
        for (int i = 1; i < arr.length; i++) {
            while(as.isEmpty()==false && arr[as.peek()]>=arr[i]){
                as.pop();
            }
            prev[i] = (as.isEmpty())?-1:as.peek();
            as.push(i);
        }
        return prev;
    }
    static int[] nextSmaller(int[] arr){
        int[] next = new int[arr.length];
        ArrayDeque<Integer> as = new ArrayDeque<>();
        as.push(arr.length-1);
        next[arr.length-1]=arr.length;
        for (int i =arr.length-2; i>=0; i--) {
            while(as.isEmpty()==false && arr[as.peek()]>=arr[i]){
                as.pop();
            }
            int ns = as.isEmpty()?arr.length:as.peek();
            next[i]=ns;
            as.push(i);
        }
        return next;
    }

    static int largestArea(int[] arr){
        int res = 0;
        int prevSmaller[] = previousSmaller(arr);
        int nextSmaller[] = nextSmaller(arr);
        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            curr+= arr[i]*(i-prevSmaller[i]-1);
            curr+= arr[i]*(nextSmaller[i]-1-i);
            res = Math.max(res,curr);
        }
        return res;
    }

    static int greaterArea(int[] arr){
        Stack<Integer> as = new Stack<>();
        int res = 0;
        int curr ;
        for (int i = 0; i < arr.length; i++) {
            while (as.isEmpty() == false && arr[as.peek()] >= arr[i]) {
                int tp =as.peek();
                as.pop();
                curr = arr[tp] * ((as.isEmpty()) ? i : i - as.peek() - 1);
                res = Math.max(res, curr);
            }
            as.push(i);
        }
        while (!as.isEmpty()){
            int tp = as.peek();
            as.pop();
            curr = arr[tp]*((as.isEmpty())?arr.length:arr.length-1-as.peek());
            res =  Math.max(res,curr);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={6,2,5,4,1,5,6};
        System.out.println(Arrays.toString(previousSmaller(arr)));
        System.out.println(Arrays.toString(nextSmaller(arr)));
        System.out.println(largestArea(arr));
        System.out.println(greaterArea(arr));
    }
}
