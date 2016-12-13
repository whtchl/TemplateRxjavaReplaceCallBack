package callback.jdjz.com.rxjava_replace_callback;

import android.util.Log;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

/**
 * Created by tchl on 2016-12-12.
 */
public class TimeUtil {

    static  Long    getBJTime() {
        URL url = null;
        try {
            url = new URL("http://www.baidu.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLConnection uc = null;// 生成连接对象
        try {
            uc = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            uc.connect(); // 发出连接
        } catch (IOException e) {
            e.printStackTrace();
        }
        long ld = uc.getDate(); // 取得网站日期时间
        Date date = new Date(ld); // 转换为标准时间对象
        // 分别取得时间中的小时，分钟和秒，并输出
        Log.d("TimeUtil","Thread Name:"+Thread.currentThread().getName().toString()+
                " \n Thread id:"+Thread.currentThread().getId());
        return date.getTime();
    }
}

