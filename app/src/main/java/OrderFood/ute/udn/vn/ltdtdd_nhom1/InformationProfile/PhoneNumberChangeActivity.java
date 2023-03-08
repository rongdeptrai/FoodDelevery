package OrderFood.ute.udn.vn.ltdtdd_nhom1.InformationProfile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import OrderFood.ute.udn.vn.ltdtdd_nhom1.R;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.profile.InformationProfileActivity;

public class PhoneNumberChangeActivity extends AppCompatActivity {
    Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number_change);
        //getSupportActionBar().hide();

        btnback = findViewById(R.id.backPhoneNumberChange);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhoneNumberChangeActivity.this, InformationProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}