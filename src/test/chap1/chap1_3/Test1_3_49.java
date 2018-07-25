package test.chap1.chap1_3;

/**
 * 六个栈的队列
 * 参见 http://www.cnblogs.com/ikesnowy/p/7157813.html
 *
 * 程序设计
 根据之前的内容，我们可以开始设计程序了。主要实现三个功能，Enqueue(), Dequeue() 和 Peek()。

 根据算法要求我们添加一个进行复制时操作的函数 OneStep()，用于执行元素的复制，栈交换等操作。

 Peek() 只需要根据是否在进行复制选择栈 h 或栈 H 进行 Peek()。

 Enqueue()
 如果不处于复制状态
 如果 H.Length – T.Length > 0，直接将元素压入栈 T。
 否则令 IsCopying = true，h 进行浅拷贝，进行两次的 OneStep。
 如果处于复制状态，将元素压入 T'，进行两次的 OneStep。

 Dequeue()
 如果不处于复制状态
 如果 H.Length – T.Length > 0，直接从 H 弹出元素。
 否则从 H 弹出元素，IsCopying = true，h 进行浅拷贝，进行两次的 OneStep。
 如果处于复制状态，从 h 弹出元素，needcopy - 1，进行两次的 OneStep。

 OneStep()
 如果不处于复制状态，什么也不做。
 如果处于复制状态。
 如果 H 和 T 都不为空，从 H 搬运一个元素至 HR ，从 T 搬运一个元素至 H' ，needcopy + 1。
 如果 H 为空但 T 不为空，从 T 搬运一个元素至 H' 。
 如果 H 和 T 都为空，但 needcopy > 1，从 HR 搬运一个元素至 H' ，needcopy – 1。
 如果 H 和 T 都为空，但 needcopy = 1，从 HR 搬运一个元素至 H' ，needcopy – 1，交换 H 和 H' 以及 T 和 T'，其他栈置空，退出复制状态。
 如果 H 和 T 都为空，但 needcopy = 0，交换 H 和 H' 以及 T 和 T'，其他栈置空，退出复制状态。
 */
public class Test1_3_49<T> {
    public static void main(String[] args) {
        Test1_3_49<String> queue = new Test1_3_49<>();
        queue.enqueue("a");
//        System.out.println(queue.peek());
        queue.enqueue("b");
        System.out.println(queue.dequeue());
//        System.out.println(queue.peek());
        queue.enqueue("c");
        queue.enqueue("d");
        System.out.println(queue.dequeue());
        queue.enqueue("e");
        queue.enqueue("f");
        queue.enqueue("g");
        queue.enqueue("h");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
    Stack<T> H, T, h, HH, TT, Hr;   //HH表示H', TT表示T'
    boolean isCopying; //H中的数量小于T中的数量时，为true，启动复制
    int needCopy;   //Hr中需要复制的元素数量
    Test1_3_49(){
        isCopying = false;
        needCopy = 0;
        this.H = new Stack<>();
        this.T = new Stack<>();
        this.h = new Stack<>();
        this.HH = new Stack<>();
        this.TT = new Stack<>();
        this.Hr = new Stack<>();
    }

    /**
     * 栈顶元素
     * @return 栈顶元素
     */
    public T peek(){
        if (this.isCopying){
            return h.peek();
        }else
            return H.peek();
    }

    public void enqueue(T item){
        if (!isCopying && diffLength() > 0){
            needCopy = 0;
            T.push(item);
        }else if (!isCopying && diffLength() == 0){
            T.push(item);
            isCopying = true;
            h = new Stack<>(H);
            this.oneStep();
            this.oneStep();
        }else {
            TT.push(item);
            this.oneStep();
            this.oneStep();
        }
    }

    public T dequeue(){
        if (!isCopying && diffLength() > 0){
            return H.pop();
        }else if (!isCopying && diffLength() == 0){
            T t = H.pop();
            h = new Stack<>(H);
            isCopying = true;
            this.oneStep();
            this.oneStep();
            return t;
        }else {
            T t = h.pop();
            needCopy--;
            this.oneStep();
            this.oneStep();
            return t;
        }
    }

    //执行元素的复制，栈交换等操作
    public void oneStep(){
        if (isCopying){
            if (H.size != 0 && T.size != 0){
                HH.push(T.pop());
                Hr.push(H.pop());
                needCopy++;
            }else if (H.size == 0 && T.size != 0 ){
                isCopying = true;
                HH.push(T.pop());
            }else if (H.size == 0 && T.size == 0 && needCopy > 1){
                HH.push(Hr.pop());
                needCopy--;
                isCopying = true;
            }else if (H.size == 0 && T.size == 0 && needCopy == 1){
                isCopying = false;
                needCopy--;
                HH.push(Hr.pop());
                H = HH;
                T = TT;
                HH = new Stack<>();
                TT = new Stack<>();
                Hr = new Stack<>();
                h = new Stack<>();
            }else if (H.size == 0 && T.size == 0 && needCopy == 0){
                isCopying = false;
                H = HH;
                T = TT;
                HH = new Stack<>();
                TT = new Stack<>();
                Hr = new Stack<>();
                h = new Stack<>();
            }
        }
    }
    public int diffLength(){
        return H.size - T.size;
    }
}
