
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//为了避免单继承的局限性，实现接口
public class Thread02 implements Runnable{

    private String url; //下载路径
    private String name;  //保存的文件名

    public Thread02(String url,String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        DowwnLoad1 dowwnLoad = new DowwnLoad1();
        dowwnLoad.downLoad(url,name);
        System.out.println("下载了文件"+name);
    }

    public static void main(String[] args) {
        Thread01 thread01 = new Thread01("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg9.51tietu.net%2Fpic%2F2019-091118%2Fmwrqg2gg4cxmwrqg2gg4cx.jpg&refer=http%3A%2F%2Fimg9.51tietu.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1637946271&t=f9154b1d434d0f40c34d5cb7160074cc","1.jpg");
        Thread01 thread02 = new Thread01("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg9.51tietu.net%2Fpic%2F2019-091118%2Fmwrqg2gg4cxmwrqg2gg4cx.jpg&refer=http%3A%2F%2Fimg9.51tietu.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1637946271&t=f9154b1d434d0f40c34d5cb7160074cc","2.jpg");
        Thread01 thread03 = new Thread01("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg9.51tietu.net%2Fpic%2F2019-091118%2Fmwrqg2gg4cxmwrqg2gg4cx.jpg&refer=http%3A%2F%2Fimg9.51tietu.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1637946271&t=f9154b1d434d0f40c34d5cb7160074cc","3.jpg");

       new Thread(thread01).start();
       new Thread(thread02).start();
       new Thread(thread03).start();
    }
}


//下载的方法
class DowwnLoad1{
    public void downLoad(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("下载出错");
        }
    }
}