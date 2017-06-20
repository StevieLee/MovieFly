package toltech.moviefly;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends Activity {

    ImageView imageView;

    Handler myhandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    Picasso.with(getApplicationContext()).load("http://i.imgur.com/DvpvklR.png").into(imageView);
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.img_show);

        process m1 = new process();
        m1.start();
    }

    public class process extends Thread{
        public process() {
            super();
        }

        @Override
        public void run() {
            Message aa = new Message();
            aa.what = 0;
            myhandler.sendMessage(aa);
            super.run();
        }
    }

}
