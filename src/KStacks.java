import java.util.Arrays;

public class KStacks {
    int[] arr;
    int[] top;
    int[] next;
    int k,cap;
    int freeTop;
    KStacks(int k1, int n){
        k = k1; cap = n;
        arr=new int[n];
        top=new int[k];
        next = new int[n];
        freeTop = 0;
        Arrays.fill(top,-1);
        for (int i = 0; i < n-1; i++) {
            next[i]=i+1;
        }
        next[n-1]=-1;
    }
    boolean isEmpty(int sn){
        return top[sn]==-1;
    }
    boolean isFull(){
        return freeTop==-1;
    }
    void push(int sn, int x){
        if (isFull()){
            System.out.println("Stack Overflow");
            return;
        }
        int i = freeTop;
        freeTop = next[i];
        next[i]=top[sn];
        top[sn]=i;
        arr[i]=x;
    }
    int pop(int sn){
        if (isEmpty(sn)){
            System.out.println("Stack Underflow");
            return -1;
        }
        int i = top[sn];
        top[sn]=next[i];
        next[i]=freeTop;
        freeTop=i;
        return arr[i];
    }
}
