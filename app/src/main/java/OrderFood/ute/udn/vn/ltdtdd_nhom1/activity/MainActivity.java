package OrderFood.ute.udn.vn.ltdtdd_nhom1.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import OrderFood.ute.udn.vn.ltdtdd_nhom1.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Thread thread;
        thread = new Thread() {
            public void run() {
                try {
                    sleep(4000);

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }

            }
        };
        thread.start();
    }
}