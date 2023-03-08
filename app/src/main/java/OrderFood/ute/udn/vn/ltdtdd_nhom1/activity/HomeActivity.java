package OrderFood.ute.udn.vn.ltdtdd_nhom1.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import OrderFood.ute.udn.vn.ltdtdd_nhom1.R;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.adapter.CategoriesAdapter;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.adapter.SaleFoodAdapter;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.model.Categories;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.model.SaleFood;


public class HomeActivity extends AppCompatActivity {
    RecyclerView categoryCycle, saleFoodCycle, hotpickCycle;
    SaleFoodAdapter saleFoodAdapter;
    CategoriesAdapter categoriesAdapter;
    FusedLocationProviderClient fusedLocationProviderClient;
    ImageView img_get_location;
    TextView tvLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        img_get_location = findViewById(R.id.img_getLocation);
        tvLocation = findViewById(R.id.tv_location);


        bottomnav();

        sliderImage(); //Slide banner
        categoryAdd(); //Category muc chon
        hotsaleAdd(); //Them cac mon khuyen mai
        hotsalePickAdd(); //Them cac mon khuyen mai
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        img_get_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(HomeActivity.this
                        , Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    getLocation();
                } else {
                    ActivityCompat.requestPermissions(HomeActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
                }
            }
        });
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                Location location = task.getResult();
                if (location != null) {
                    try {
                        Geocoder geocoder = new Geocoder(HomeActivity.this,
                                Locale.getDefault());
                        List<Address> addresses = geocoder.getFromLocation(
                                location.getLatitude(), location.getLongitude(), 1
                        );
                        tvLocation.setText(addresses.get(0).getAddressLine(0));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }


    private void bottomnav() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
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
                        startActivity(new Intent(getApplicationContext(), NearbyActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }

    private void hotsaleAdd() {
        List<SaleFood> saleFoods = new ArrayList<>();
        saleFoods.add(new SaleFood("Bánh tráng cô Tiên", "THCS Kim Đồng", R.drawable.ic_banhtrangtron));
        saleFoods.add(new SaleFood("Trà sữa Phúc Long", "Phúc Long N.V.Linh", R.drawable.ic_trasua_phuclong));
        saleFoods.add(new SaleFood("Gà rán KFC", "KFC BigC", R.drawable.fried_chicken));
        saleFoods.add(new SaleFood("Bánh tráng cô Tiên", "THCS Kim Đồng", R.drawable.ic_banhtrangtron));
        saleFoods.add(new SaleFood("Trà sữa Phúc Long", "Phúc Long N.V.Linh", R.drawable.ic_trasua_phuclong));
        saleFoods.add(new SaleFood("Gà rán JollyBean", "72 Mai Am", R.drawable.fried_chicken));
        saleFoods.add(new SaleFood("Bánh tráng cô Tiên", "THCS Kim Đồng", R.drawable.ic_banhtrangtron));
        saleFoods.add(new SaleFood("Trà sữa Phúc Long", "Phúc Long N.V.Linh", R.drawable.ic_trasua_phuclong));
        saleFoods.add(new SaleFood("Gà chiên phô mai", "THCS Kim Đồng", R.drawable.fried_chicken));
        setSaleRecycler(saleFoods);
    }

    private void setSaleRecycler(List<SaleFood> saleFoods) {
        saleFoodCycle = findViewById(R.id.hot_sale_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        saleFoodCycle.setLayoutManager(layoutManager);
        saleFoodAdapter = new SaleFoodAdapter(this, saleFoods);
        saleFoodCycle.setAdapter(saleFoodAdapter);
    }

    private void categoryAdd() {
        List<Categories> categories = new ArrayList<>();
        categories.add(new Categories("Tất cả", R.drawable.ic_all));
        categories.add(new Categories("Trà Sữa", R.drawable.milk_tea_more));
        categories.add(new Categories("Cơm", R.drawable.cafe));
        categories.add(new Categories("Ăn Vặt", R.drawable.milk_tea));
        categories.add(new Categories("Gà rán", R.drawable.fried_chicken));
        categories.add(new Categories("Pizza", R.drawable.asiafood1));
        categories.add(new Categories("Bánh xèo", R.drawable.asiafood1));
        categories.add(new Categories("Bánh kem", R.drawable.cake));
        setCategoriesRecycle(categories);
    }

    private void sliderImage() {
        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.sale_banner, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.sale_banner1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.sale_banner2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.sale_banner3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.sale_banner4, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.CENTER_INSIDE);
    }


    private void setCategoriesRecycle(List<Categories> categoriesList) {
        categoryCycle = findViewById(R.id.categories_recycle);
        categoriesAdapter = new CategoriesAdapter(this, categoriesList);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 1);
        gridLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        categoryCycle.setLayoutManager(gridLayoutManager);

        categoryCycle.setAdapter(categoriesAdapter);
    }

    private void hotsalePickAdd() {
        List<SaleFood> hotpick = new ArrayList<>();
        hotpick.add(new SaleFood("Bánh tráng cô Tiên", "THCS Kim Đồng", R.drawable.ic_banhtrangtron));
        hotpick.add(new SaleFood("Trà sữa Phúc Long", "Phúc Long N.V.Linh", R.drawable.ic_trasua_phuclong));
        hotpick.add(new SaleFood("Gà rán KFC", "KFC BigC", R.drawable.fried_chicken));
        hotpick.add(new SaleFood("Bánh tráng cô Tiên", "THCS Kim Đồng", R.drawable.ic_banhtrangtron));
        hotpick.add(new SaleFood("Trà sữa Phúc Long", "Phúc Long N.V.Linh", R.drawable.ic_trasua_phuclong));
        hotpick.add(new SaleFood("Gà rán JollyBean", "72 Mai Am", R.drawable.fried_chicken));
        hotpick.add(new SaleFood("Bánh tráng cô Tiên", "THCS Kim Đồng", R.drawable.ic_banhtrangtron));
        hotpick.add(new SaleFood("Trà sữa Phúc Long", "Phúc Long N.V.Linh", R.drawable.ic_trasua_phuclong));
        hotpick.add(new SaleFood("Gà chiên phô mai", "THCS Kim Đồng", R.drawable.fried_chicken));
        setHotPickRecycler(hotpick);

    }

    private void setHotPickRecycler(List<SaleFood> hotpick) {
        hotpickCycle = findViewById(R.id.hot_pick_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        hotpickCycle.setLayoutManager(layoutManager);
        saleFoodAdapter = new SaleFoodAdapter(this, hotpick);
        hotpickCycle.setAdapter(saleFoodAdapter);
    }

    public void open_activity_nearby(View view) {

//        startActivity(new Intent(getApplicationContext(), NearbyActivity.class));
//        overridePendingTransition(0, 0);
    }
}