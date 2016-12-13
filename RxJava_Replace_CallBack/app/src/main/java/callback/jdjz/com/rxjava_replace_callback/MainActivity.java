package callback.jdjz.com.rxjava_replace_callback;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import android.net.Uri;
import rx.functions.Action1;
public class MainActivity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn_rxjava);

        final ManagerFields managerFields  = new ManagerFields(this);
        Log.d("MainActivity","Thread Name:"+Thread.currentThread().getName().toString()+
                " \n Thread id:"+Thread.currentThread().getId());
        final Observable observable = Observable.create(new Observable.OnSubscribe<Long>(){

            @Override
            public void call(Subscriber<? super Long> subscriber) {
                Long bjtime = TimeUtil.getBJTime();
                subscriber.onNext(bjtime);
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                observable.observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<Long>() {
                            @Override
                            public void call(Long bjtime) {
                                managerFields.doSomething(bjtime);
                            }
                        });
            }
        });
    }
}
