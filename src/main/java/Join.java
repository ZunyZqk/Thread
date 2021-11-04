/**
 * 测试join方法 -- 想象成插队
 */
public class Join implements Runnable{

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            System.out.println("vip来了"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动自己的线程
        Join join = new Join();
        Thread thread = new Thread(join);
        thread.start();


        //启动主线程

        for (int i = 0; i < 500; i++) {
            //当主线程运行到200时让其他线程插队执行，当其他线程执行完之后主线成再执行
            if (i==200){
                thread.join();
            }
            System.out.println("main"+i);
        }
    }
}