package OrderFood.ute.udn.vn.ltdtdd_nhom1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import OrderFood.ute.udn.vn.ltdtdd_nhom1.R;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.adapter.Order_fragmentAdapter;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.controller.LoadingDiaglog;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.model.Order_History_Fragment;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.model.Order_OnGoing_Frament;

public class OrderActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    Order_fragmentAdapter orderFragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        orderFragmentAdapter = new Order_fragmentAdapter(getSupportFragmentManager());
        //add
        orderFragmentAdapter.AddFragment(new Order_OnGoing_Frament(), "Đang Giao");
        orderFragmentAdapter.AddFragment(new Order_History_Fragment(), "Lịch Sử");
        orderFragmentAdapter.AddFragment(new Order_OnGoing_Frament(), "Giỏ Hàng");
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(orderFragmentAdapter);

        bottomnav();
    }

    private void bottomnav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.order);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.order:
                        return true;
                    case R.id.favourite:
                        startActivity(new Intent(getApplicationContext(), FavouriteActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.nearby:
                        startActivity(new Intent(getApplicationContext(), NearbyActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}