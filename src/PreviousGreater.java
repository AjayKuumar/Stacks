import java.util.ArrayDeque;

public class PreviousGreater {
    static void previousGreater(int[] arr){
        ArrayDeque<Integer> as = new ArrayDeque<>();
        as.push(arr[0]);
        System.out.print(-1+" ");
        for (int i = 1; i < arr.length; i++) {
            while(as.isEmpty()==false && as.peek()<=arr[i]){
                as.pop();
            }
            int prevGreater = (as.isEmpty())?-1:as.peek();
            System.out.print(prevGreater+" ");
            as.push(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {15,10,18,12,4,6,2,8};
        previousGreater(arr);
    }
}
