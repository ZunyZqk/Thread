import sun.applet.Main;

/**
 * yield 礼让线程
 * 礼让不一定成功，看CPU的调度
 */
public class Yield {

    public static void main(String[] args) {
        MyYield myYield = new MyYield();

        new Thread(myYield,"ii").start();
        new Thread(myYield,"pp").start();
    }
}


class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始执行");
        Thread.yield();//礼让线程
        System.out.println(Thread.currentThread().getName()+"线程终止执行");
    }
}