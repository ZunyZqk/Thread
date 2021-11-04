/**
 * 线程停止：
 * 1、不推荐使用stop、destory
 * 2、最好让线程运行结束后自动停止
 * 3、可以使用标志位，切换状态来达到线程停止
 */
public class StopThresd implements Runnable{

    private boolean flag = true;

    @Override
    public void run() {

        while (flag){
            int i=0;
            System.out.println("run thresd"+i++);
        }
    }

    //自定义的stop方法，切换线程的状态
    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {

        StopThresd stopThresd = new StopThresd();
        new Thread(stopThresd).start();
        for (int i=0;i<=100;i++){
            if(i==88){
                //调用方法，让线程停止
                stopThresd.stop();
                System.out.println("线程高停止了");
            }
        }
    }
}
