package OrderFood.ute.udn.vn.ltdtdd_nhom1.model;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import OrderFood.ute.udn.vn.ltdtdd_nhom1.R;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.adapter.Frament_NearbyAdapter;

public class FoodFrament extends Fragment {
    View v;
    private Context context;
    private RecyclerView recyclerView;
    private List<Nearby1> list;
    public FoodFrament(){
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,@Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.frament_nearby_list, container, false);
        recyclerView=v.findViewById(R.id.nearby_frament_recycle);
        Frament_NearbyAdapter adapter=  new Frament_NearbyAdapter(getContext(),list);
        recyclerView.setLayoutManager( new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
       return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list= new ArrayList<>();
        list.add(new Nearby1("Piza Compay","178 Hùng Vương","4.5",20,1, R.drawable.asiafood1,"12500 "));
        list.add(new Nearby1("Piza Compay","178 Hùng Vương","4.5",20,1, R.drawable.asiafood1,"12500 "));
        list.add(new Nearby1("Piza Compay","178 Hùng Vương","4.5",20,1, R.drawable.asiafood1,"12500 "));
        list.add(new Nearby1("Piza Compay","178 Hùng Vương","4.5",20,1, R.drawable.asiafood1,"12500 "));
        list.add(new Nearby1("Piza Compay","178 Hùng Vương","4.5",20,1, R.drawable.asiafood1,"12500 "));
        list.add(new Nearby1("Piza Compay","178 Hùng Vương","4.5",20,1, R.drawable.asiafood1,"12500 "));
        list.add(new Nearby1("Piza Compay","178 Hùng Vương","4.5",20,1, R.drawable.asiafood1,"12500 "));
        list.add(new Nearby1("Piza Compay","178 Hùng Vương","4.5",20,1, R.drawable.asiafood1,"12500 "));
        list.add(new Nearby1("Piza Compay","178 Hùng Vương","4.5",20,1, R.drawable.asiafood1,"12500 "));
        list.add(new Nearby1("Piza Compay","178 Hùng Vương","4.5",20,1, R.drawable.asiafood1,"12500 "));
        list.add(new Nearby1("Piza Compay","178 Hùng Vương","4.5",20,1, R.drawable.asiafood1,"12500 "));



    }

}
