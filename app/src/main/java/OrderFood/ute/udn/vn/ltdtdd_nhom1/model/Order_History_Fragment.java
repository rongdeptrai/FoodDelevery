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
import OrderFood.ute.udn.vn.ltdtdd_nhom1.adapter.Order_History_RecyclerViewAdapter;

public class Order_History_Fragment extends Fragment {
    View v;
    private Context context;
    private RecyclerView recyclerView;
    private List<Order_History> list;
    public Order_History_Fragment(){

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.oder_history_list, container, false);
        recyclerView=v.findViewById(R.id.order_history_recyclerview);
        Order_History_RecyclerViewAdapter adapter=  new Order_History_RecyclerViewAdapter(getContext(),list);
        recyclerView.setLayoutManager( new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        return v;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list= new ArrayList<>();
        list.add(new Order_History("Piza Compay","Big Piza","6 iteam","Hôm qua", R.drawable.asiafood1));
        list.add(new Order_History("Piza Compay","Big Piza","6 iteam","Hôm qua", R.drawable.asiafood1));
        list.add(new Order_History("Piza Compay","Big Piza","6 iteam","Hôm qua", R.drawable.asiafood1));
        list.add(new Order_History("Piza Compay","Big Piza","6 iteam","Thứ 2", R.drawable.asiafood1));
        list.add(new Order_History("Piza Compay","Big Piza","6 iteam","Hôm qua", R.drawable.asiafood1));
        list.add(new Order_History("Piza Compay","Big Piza","6 iteam","Hôm qua", R.drawable.asiafood1));
        list.add(new Order_History("Piza Compay","Big Piza","6 iteam","Thứ 5", R.drawable.asiafood1));
        list.add(new Order_History("Piza Compay","Big Piza","6 iteam","Hôm qua", R.drawable.asiafood1));
        list.add(new Order_History("Piza Compay","Big Piza","6 iteam","Hôm qua", R.drawable.asiafood1));
        list.add(new Order_History("Piza Compay","Big Piza","6 iteam","Thứ 6", R.drawable.asiafood1));

    }
}
