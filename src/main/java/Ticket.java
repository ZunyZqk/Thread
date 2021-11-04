import java.text.BreakIterator;

public class Ticket implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {

        while (true) {
            try {
                //模拟延时
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->买到了票"+ticket--);
            if (ticket <= 0) {
                break;
            }
        }
    }


    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(ticket,"小明").start();
        new Thread(ticket,"小丽").start();
        new Thread(ticket,"小红[033hasdG]").start();
    }
}
