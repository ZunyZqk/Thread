
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * 流程：
 *  实现Callable接口
 *  重写call方法，需要返回值
 *  创建服务 ExecutorService ser=Executors.newFixedThreadPool(线程数量);
 *  提交任务  ser.submit(TestCallable类对象);
 *  关闭服务  ser.shutdownNow()
 */
public class TestCallable implements Callable<Boolean> {

    private String url; //下载路径
    private String name;  //保存的文件名

    public TestCallable(String url,String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() {
        DowwnLoad2 dowwnLoad = new DowwnLoad2();
        dowwnLoad.downLoad(url,name);
        System.out.println("下载了文件"+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable thread01 = new TestCallable("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg9.51tietu.net%2Fpic%2F2019-091118%2Fmwrqg2gg4cxmwrqg2gg4cx.jpg&refer=http%3A%2F%2Fimg9.51tietu.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1637946271&t=f9154b1d434d0f40c34d5cb7160074cc","1.jpg");
        TestCallable thread02 = new TestCallable("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg9.51tietu.net%2Fpic%2F2019-091118%2Fmwrqg2gg4cxmwrqg2gg4cx.jpg&refer=http%3A%2F%2Fimg9.51tietu.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1637946271&t=f9154b1d434d0f40c34d5cb7160074cc","2.jpg");
        TestCallable thread03 = new TestCallable("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg9.51tietu.net%2Fpic%2F2019-091118%2Fmwrqg2gg4cxmwrqg2gg4cx.jpg&refer=http%3A%2F%2Fimg9.51tietu.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1637946271&t=f9154b1d434d0f40c34d5cb7160074cc","3.jpg");


        //创建执行服务    3表示开启3个线程
        ExecutorService service = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> submit1 = service.submit(thread01);
        Future<Boolean> submit2 = service.submit(thread02);
        Future<Boolean> submit3 = service.submit(thread03);

        //获取返回值的结果
        System.out.println(submit1.get());
        System.out.println(submit2.get());
        System.out.println(submit3.get());

        //关闭服务
        service.shutdownNow();
    }
}


//下载的方法
class DowwnLoad2{
    public void downLoad(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("下载出错");
        }
    }
}