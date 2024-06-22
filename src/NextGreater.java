import java.util.*;

public class NextGreater {
    static ArrayList<Integer> nextGreater(int[] arr){
        ArrayList<Integer> v=new ArrayList<>();
        ArrayDeque<Integer> as = new ArrayDeque<>();
        as.push(arr[arr.length-1]);
        v.add(-1);
        for (int i = arr.length-2; i >=0 ; i--) {
            while (as.isEmpty() == false && as.peek() <= arr[i]) {
                as.pop();
            }
            int ng=as.isEmpty()?-1:as.peek();
            v.add(ng);
            as.push(arr[i]);
        }
        Collections.reverse(v);
        return v;
    }

    public static void main(String[] args) {
        int[] arr = {15,10,18,12,4,6,2,8};
        System.out.println(Arrays.toString(arr));
        for (int i: nextGreater(arr)){
            System.out.print(i+"  ");
        }
    }
}
