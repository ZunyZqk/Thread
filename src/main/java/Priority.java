/**
 * 线程的优先级，优先级高的线程得到的CPU资源比较多，也就是CPU优先执行优先级高的线程
 * 优先级的划分1-10
 * 优先级具有继承性，  例如a继承b，a就和b的优先级相同
 */
public class Priority {

    public static void main(String[] args) {
        //打印主线程默认的优先级
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();

        Thread thread = new Thread(myPriority);
        Thread thread2 = new Thread(myPriority);
        Thread thread3 = new Thread(myPriority);
        Thread thread4 = new Thread(myPriority);
        Thread thread5 = new Thread(myPriority);

        thread.start();

        thread2.setPriority(1);
        thread2.start();


        thread3.setPriority(3);
        thread3.start();

        thread4.setPriority(6);
        thread4.start();

        thread5.setPriority(9);
        thread5.start();
    }


}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"执行");
    }
}
