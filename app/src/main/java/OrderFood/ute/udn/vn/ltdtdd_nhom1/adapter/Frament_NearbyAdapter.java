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
import OrderFood.ute.udn.vn.ltdtdd_nhom1.model.Nearby1;


public class Frament_NearbyAdapter extends RecyclerView.Adapter<Frament_NearbyAdapter.Frament_NearbyViewHolder> {
     Context context;
   List<Nearby1> nearby1;

    public Frament_NearbyAdapter(Context context, List<Nearby1> nearby1) {
        this.context = context;
        this.nearby1 = nearby1;
    }

    @NonNull
    @Override
    public Frament_NearbyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.frament_nearby__iteam, parent, false);
        return new Frament_NearbyAdapter.Frament_NearbyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Frament_NearbyViewHolder holder, int position) {
        holder.imgStore.setImageResource(nearby1.get(position).getImageStore());

        holder.txtStore.setText(nearby1.get(position).getNameStore());
        holder.txtLocation.setText(nearby1.get(position).getLocation());
        holder.txtReviewers.setText(nearby1.get(position).getReviewers());


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
        return nearby1.size();
    }

    public static final class Frament_NearbyViewHolder extends RecyclerView.ViewHolder{
        ImageView imgStore;
        TextView txtStore, txtLocation, txtRating, txtTime, txtDistance, txtReviewers;

        public Frament_NearbyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgStore = itemView.findViewById(R.id.imageStore);
            txtStore = itemView.findViewById(R.id.txtNameStore);
            txtDistance = itemView.findViewById(R.id.txtDistance);
            txtLocation = itemView.findViewById(R.id.txtLocation);
            txtRating = itemView.findViewById(R.id.txtRating);
            txtTime = itemView.findViewById(R.id.txtTime);
            txtReviewers = itemView.findViewById(R.id.txtReviewers);
        }
    }
}
