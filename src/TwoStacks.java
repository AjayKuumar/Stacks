public class TwoStacks {
    int[]arr;
    int cap;
    int top1;
    int top2;

    TwoStacks(int n){
        arr = new int[n];
        cap = n;
        top1 = -1;
        top2 = n;
    }
    boolean push1(int x){
        if(top1<top2-1){
            top1++;
            arr[top1]=x;
            return true;
        }
        return false;
    }
    boolean push2(int x){
        if(top1<top2-1){
            top2--;
            arr[top2]=x;
            return true;
        }
        return false;
    }
    Integer pop1(){
        if(top1>-1){
            int res = arr[top1];
            top1--;
            return res;
        }
        return null;
    }
    Integer pop2(){
        if (top2<cap){
            int res=arr[top2];
            top2++;
            return res;
        }
        return Integer.MAX_VALUE;
    }
    int size1(){
        return top1+1;
    }
    int size2(){
        return cap-top2;
    }
}
