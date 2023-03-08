package OrderFood.ute.udn.vn.ltdtdd_nhom1.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import OrderFood.ute.udn.vn.ltdtdd_nhom1.R;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.activity.HomeActivity;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.model.SaleFood;


public class SaleFoodAdapter extends RecyclerView.Adapter<SaleFoodAdapter.SaleFoodViewHolder> {
    Context context;
    List<SaleFood> saleFoods;

    public SaleFoodAdapter(Context context, List<SaleFood> saleFoods) {
        this.context = context;
        this.saleFoods = saleFoods;
    }

    @NonNull
    @Override
    public SaleFoodAdapter.SaleFoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.hot_sale_row_item, parent, false);
        return new SaleFoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SaleFoodAdapter.SaleFoodViewHolder holder, int position) {
        holder.foodImage.setImageResource(saleFoods.get(position).getImageUrl());
        holder.name.setText(saleFoods.get(position).getName());
        holder.location.setText(saleFoods.get(position).getLocation());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, HomeActivity.class);
                context.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return saleFoods.size();
    }

    public class SaleFoodViewHolder extends RecyclerView.ViewHolder {
        ImageView foodImage;
        TextView name, location;
        public SaleFoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage = itemView.findViewById(R.id.food_image);
            location = itemView.findViewById(R.id.edt_location);
            name = itemView.findViewById(R.id.food_name);
        }
    }
}
