//public class MyStack {
//    int[] arr;
//    int cap;
//    int top;
//    MyStack(int c){
//        top=-1;
//        cap =c;
//        arr=new int[cap];
//    }
//    void push(int x){
//        top++;
//        arr[top]=x;
//    }
//    int pop(){
//        int res = arr[top];
//        top--;
//        return res;
//    }
//    int peek(){
//        return arr[top];
//    }
//    int size(){
//        return top+1;
//    }
//    boolean isEmpty(){
//        return top==-1;
//    }
//}

//import java.util.ArrayList;
//
//public class MyStack {
//    ArrayList<Integer> arr;
//    int top;
//    MyStack(){
//        top=-1;
//        arr=new ArrayList();
//    }
//    void push(int x){
//        arr.add(x);
//        top++;
//    }
//    int pop(){
//        int res = (int) arr.get(top);
//        arr.remove(top);
//        top--;
//        return res;
//    }
//    int peek(){
//        return (int) arr.get(top);
//    }
//    int size(){
//        return arr.size();
//    }
//    boolean isEmpty(){
//        return arr.isEmpty();
//    }
//}
class Node{
    int data;
    Node next;
    Node(int d){
        data =d;
        next =null;
    }
}

public class MyStack {
    Node head;
    int size;
    MyStack(){
        head=null;
        size=0;
    }
    void push(int x){
        Node temp = new Node(x);
        temp.next=head;
        head=temp;
        size++;
    }
    int pop(){
        int res=head.data;
        head=head.next;
        size--;
        return res;
    }
    int size(){
        return size;
    }
    boolean isEmpty(){
        return head==null;
    }
    int peek(){
        return head.data;
    }
}