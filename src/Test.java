public class Test {
    public static void main(String[] args) {
//        MyStack s = new MyStack(10);
//        s.push(2);
//        s.push(5);
//        s.push(10);
//        System.out.println(s.pop());
//        System.out.println(s.peek());
//        System.out.println(s.size());
//        System.out.println(s.isEmpty());
//        s.push(8);
//        System.out.println(s.peek());


        // ArrayList Stack Implementation
//        MyStack s = new MyStack();
//        s.push(10);
//        s.push(5);
//        s.push(2);
//        System.out.println(s.pop());
//        System.out.println(s.peek());
//        System.out.println(s.size());
//        s.push(15);
//        System.out.println(s.peek());
//        System.out.println(s.size());
//        s.pop();
//        s.pop();
//        s.pop();
//        System.out.println(s.isEmpty());



//        MyStack s = new MyStack();
//        System.out.println(s.size());
//        s.push(10);
//        s.push(15);
//        s.push(20);
//        System.out.println(s.peek());
//        s.pop();
//        System.out.println(s.peek());
//        System.out.println(s.size);
//        System.out.println(s.isEmpty());
//        s.pop();
//        System.out.println(s.peek());

//        TwoStacks as = new TwoStacks(5);
//        as.push1(10);
//        as.push2(20);
//        as.push1(16);
//        as.push2(30);
//        System.out.println(as.size1());
//        System.out.println(as.size2());
//        System.out.println(as.push1(16));
//        System.out.println(as.push2(40));
//        System.out.println(as.pop2());
//        System.out.println(as.size2());

        KStacks as = new KStacks(3,10);
        as.push(1,5);
        as.push(2,10);
        as.push(1,15);
        System.out.println(as.isEmpty(0));
        System.out.println(as.isEmpty(2));
        as.pop(2);
        System.out.println(as.isEmpty(2));
    }

}
