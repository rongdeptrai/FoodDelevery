package OrderFood.ute.udn.vn.ltdtdd_nhom1.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import OrderFood.ute.udn.vn.ltdtdd_nhom1.R;

public class Order_OnGoing_Frament extends Fragment {
    View v;
    public Order_OnGoing_Frament(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.order_ongoing,container,false);
        return v;
    }
}
