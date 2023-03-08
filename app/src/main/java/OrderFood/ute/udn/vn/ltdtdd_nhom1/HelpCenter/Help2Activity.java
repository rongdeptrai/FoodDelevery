package OrderFood.ute.udn.vn.ltdtdd_nhom1.HelpCenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import OrderFood.ute.udn.vn.ltdtdd_nhom1.R;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.profile.HelpCenterActivity;

public class Help2Activity extends AppCompatActivity {
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help2);
        getSupportActionBar().hide();

        btnback = (Button) findViewById(R.id.closehelp2);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Help2Activity.this, HelpCenterActivity.class);
                startActivity(intent);
            }
        });

    }
}