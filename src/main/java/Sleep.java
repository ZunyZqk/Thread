import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleep 指定当前线程阻塞的毫秒数
 * 时间达到后线程进入就绪状态
 * 可以模拟网络延时，倒计时
 * 每一个对象都有一个锁，sleep不会释放锁
 */
public class Sleep {

    public static void main(String[] args) throws InterruptedException {
      //  tenDown(); //模拟倒计时

        //打印当前时间
        Date data = new Date(System.currentTimeMillis());//获取系统当前时间
        while (true){
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(data));
            data = new Date(System.currentTimeMillis());//更新时间
        }
    }

    //模拟倒计时
    public static void tenDown() throws InterruptedException{
        int num =10;
        while(true){
            Thread.sleep(1000);
            System.out.println(num--);
            if(num<=0){
                break;
            }
        }
    }




}
