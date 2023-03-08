package OrderFood.ute.udn.vn.ltdtdd_nhom1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import OrderFood.ute.udn.vn.ltdtdd_nhom1.R;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.adapter.Nearby_FragmentAdapter;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.model.CakesFrament;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.model.DrinkFrament;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.model.FoodFrament;

public class NearbyActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    Nearby_FragmentAdapter nearby_frament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby);

        bottomnav();

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        nearby_frament= new Nearby_FragmentAdapter(getSupportFragmentManager());
        //add
        nearby_frament.AddFragment(new FoodFrament(),"Food");
        nearby_frament.AddFragment(new DrinkFrament(),"Drink");
        nearby_frament.AddFragment(new CakesFrament(),"Cakes");
        nearby_frament.AddFragment(new FoodFrament(),"Asia");
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(nearby_frament);

    }

    private void bottomnav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nearby);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.order:
                        startActivity(new Intent(getApplicationContext(), OrderActivity.class));
                        overridePendingTransition(0, 0);
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
                        return true;
                }
                return false;
            }
        });
    }
}