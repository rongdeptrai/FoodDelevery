package OrderFood.ute.udn.vn.ltdtdd_nhom1.model;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import OrderFood.ute.udn.vn.ltdtdd_nhom1.R;

public class DrinkFrament extends Fragment {
    View v;
    public DrinkFrament(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.frament_nearby_list,container,false);
        return v;
    }
}
