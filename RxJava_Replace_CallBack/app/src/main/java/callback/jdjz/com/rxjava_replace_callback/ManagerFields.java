package callback.jdjz.com.rxjava_replace_callback;

import android.content.Context;
import android.util.Log;

/**
 * Created by tchl on 2016-12-12.
 */
public class ManagerFields {
    Context mContext;

    public ManagerFields(Context mContext) {
        this.mContext = mContext;
    }


    public void doSomething(long bjTime){
        Log.d("ManagerFields","Thread Name:"+Thread.currentThread().getName().toString()+
                " \n Thread id:"+Thread.currentThread().getId());

        Log.d("ManagerFields","Time :"+bjTime);
    }

    
}
