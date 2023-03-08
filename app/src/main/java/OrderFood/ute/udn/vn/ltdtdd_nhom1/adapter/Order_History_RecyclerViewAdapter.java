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
import OrderFood.ute.udn.vn.ltdtdd_nhom1.model.Order_History;

public class Order_History_RecyclerViewAdapter extends RecyclerView.Adapter<Order_History_RecyclerViewAdapter.OrderHistory_ViewHolder> {
    Context context;
    List<Order_History> order_histories;

    public Order_History_RecyclerViewAdapter(Context context, List<Order_History> order_histories) {
        this.context = context;
        this.order_histories = order_histories;
    }

    @NonNull
    @Override
    public OrderHistory_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_history_iteam, parent, false);
        return new Order_History_RecyclerViewAdapter.OrderHistory_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHistory_ViewHolder holder, int position) {
        holder.imgStore.setImageResource(order_histories.get(position).getImageStore());
        holder.txtStore.setText(order_histories.get(position).getRestaurant_name());
        holder.txtFoodName.setText(order_histories.get(position).getFood_name());
        holder.txtIteam.setText(order_histories.get(position).getIteams());
        holder.txtTime.setText(order_histories.get(position).getTime());


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
        return order_histories.size();
    }

    public static final class OrderHistory_ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgStore;
        TextView txtStore,  txtTime, txtFoodName, txtIteam;

        public OrderHistory_ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgStore = itemView.findViewById(R.id.food_image);
            txtStore = itemView.findViewById(R.id.restaurant_name);
            txtFoodName = itemView.findViewById(R.id.food_name);
            txtTime = itemView.findViewById(R.id.time);
            txtIteam = itemView.findViewById(R.id.iteam);
        }
    }
}
