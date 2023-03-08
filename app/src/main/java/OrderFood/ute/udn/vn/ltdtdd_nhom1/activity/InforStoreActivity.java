package OrderFood.ute.udn.vn.ltdtdd_nhom1.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import OrderFood.ute.udn.vn.ltdtdd_nhom1.R;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.adapter.AllMenuAdapter;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.adapter.PopularAdapter;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.adapter.RecommendedAdapter;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.model.Allmenu;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.model.Popular;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.model.Recommended;


public class InforStoreActivity extends AppCompatActivity {

    RecyclerView popularRecyclerView, recommendedRecyclerView, allMenuRecyclerView;

    PopularAdapter popularAdapter;
    RecommendedAdapter recommendedAdapter;
    AllMenuAdapter allMenuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor_store);

        List<Popular> popularFoods = new ArrayList<>();
        List<Recommended> saleFoods = new ArrayList<>();
        List<Allmenu> allFoods = new ArrayList<>();
        popularFoods.add(new Popular("pizza", R.drawable.asiafood1,"4.5","5 mins","","50.000₫",""));
        popularFoods.add(new Popular("pizza", R.drawable.asiafood1,"4.5","5 mins","","50.000₫",""));
        popularFoods.add(new Popular("pizza", R.drawable.asiafood1,"4.5","5 mins","","50.000₫",""));
        popularFoods.add(new Popular("pizza", R.drawable.asiafood1,"4.5","5 mins","","50.000₫",""));
        popularFoods.add(new Popular("pizza", R.drawable.asiafood1,"4.5","5 mins","","50.000₫",""));

        saleFoods.add(new Recommended("creams", R.drawable.asiafood2,"4.5","10 mins","","20.000₫",""));
        saleFoods.add(new Recommended("creams", R.drawable.asiafood2,"4.5","10 mins","","20.000₫",""));
        saleFoods.add(new Recommended("creams", R.drawable.asiafood2,"4.5","10 mins","","20.000₫",""));
        saleFoods.add(new Recommended("creams", R.drawable.asiafood2,"4.5","10 mins","","20.000₫",""));
        saleFoods.add(new Recommended("creams", R.drawable.asiafood2,"4.5","10 mins","","20.000₫",""));

        allFoods.add(new Allmenu("Chicken", R.drawable.fried_chicken,"4.5","7 mins","","40.000₫",""));
        allFoods.add(new Allmenu("Chicken", R.drawable.fried_chicken,"4.5","7 mins","","40.000₫",""));
        allFoods.add(new Allmenu("Chicken", R.drawable.fried_chicken,"4.5","7 mins","","40.000₫",""));
        allFoods.add(new Allmenu("Chicken", R.drawable.fried_chicken,"4.5","7 mins","","40.000₫",""));
        allFoods.add(new Allmenu("Chicken", R.drawable.fried_chicken,"4.5","7 mins","","40.000₫",""));

        popularRecyclerView(popularFoods);
        getRecommendedData(saleFoods);
        getAllMenu(allFoods);


    }

    private void popularRecyclerView(List<Popular> saleFoods) {
        popularRecyclerView = findViewById(R.id.popular_recycler);
        popularAdapter = new PopularAdapter(this, saleFoods);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        popularRecyclerView.setLayoutManager(layoutManager);
        popularRecyclerView.setAdapter(popularAdapter);
    }


    private void  getRecommendedData(List<Recommended> recommendedList){

        recommendedRecyclerView = findViewById(R.id.recommended_recycler);
        recommendedAdapter = new RecommendedAdapter(this, recommendedList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recommendedRecyclerView.setLayoutManager(layoutManager);
        recommendedRecyclerView.setAdapter(recommendedAdapter);

    }

    private void  getAllMenu(List<Allmenu> allmenuList){

        allMenuRecyclerView = findViewById(R.id.all_menu_recycler);
        allMenuAdapter = new AllMenuAdapter(this, allmenuList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        allMenuRecyclerView.setLayoutManager(layoutManager);
        allMenuRecyclerView.setAdapter(allMenuAdapter);
        allMenuAdapter.notifyDataSetChanged();

    }
}
